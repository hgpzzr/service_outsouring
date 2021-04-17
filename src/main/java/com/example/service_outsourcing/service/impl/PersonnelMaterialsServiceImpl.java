package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.*;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.*;
import com.example.service_outsourcing.mapper.*;
import com.example.service_outsourcing.service.PersonnelMaterialsService;
import com.example.service_outsourcing.utils.FileUtil;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/9 12:59
 */
@Service
@Slf4j
public class PersonnelMaterialsServiceImpl implements PersonnelMaterialsService {
	@Autowired
	private PersonnelMaterialMapper personnelMaterialMapper;
	@Autowired
	private IdentifyCardMapper identifyCardMapper;
	@Autowired
	private EducationProveMapper educationProveMapper;
	@Autowired
	private SocialInfoMapper socialInfoMapper;
	@Autowired
	private EntryRegisterMapper entryRegisterMapper;
	@Autowired
	private EntryPhysicalExaminationMapper entryPhysicalExaminationMapper;
	@Autowired
	private QuitProveMapper quitProveMapper;
	@Autowired
	private ProveFileMapper proveFileMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private GenerateIdUtil generateIdUtil;

	@Value("${img.ID.url}")
	private String imgIDUrl;
	@Value("${img.educationProve.url}")
	private String educationProveUrl;
	@Value("${img.socialInfo.url}")
	private String socialInfoUrl;
	@Value("${img.entryRegister.url}")
	private String registerUrl;
	@Value("${img.physicalExamination.url}")
	private String physicalExaminationUrl;
	@Value("${img.quitProve.url}")
	private String quitProveUrl;
	@Value("${img.proveFile.url}")
	private String proveFileUrl;
	@Value("${img.contract.url}")
	private String contractUrl;

	@Override
	public ResultVO insertPersonnelMaterial(String employeeId) {
		if (employeeMapper.selectByPrimaryKey(employeeId) == null) {
			log.error("【添加人事材料】：员工不存在");
			return ResultVOUtil.error(ResultEnum.EMPLOYEE_NOT_EXIST_ERROR);
		}
//		String materialId = GenerateIdUtil.getMaterialId(personnelMaterialMapper);
		String materialId = generateIdUtil.getRandomId(personnelMaterialMapper, "PM");
		PersonnelMaterial personnelMaterial = new PersonnelMaterial();
		personnelMaterial.setMaterialId(materialId);
		personnelMaterial.setEmployeeId(employeeId);
		log.info("personnelMaterial:{}", personnelMaterial.toString());
		int insert = personnelMaterialMapper.insert(personnelMaterial);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("materialId", materialId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO insertID(IDForm form, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(form.getMaterialId()) == null) {
			log.error("【添加身份证】：人事材料不存在");
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 判断过期时间是否在当前时间之前
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date);
		log.info("format:{}", format);
		if (format.compareTo(form.getOverdueTime()) >= 0) {
			return ResultVOUtil.error(ResultEnum.DATE_EARLY_ERROR);
		}
		// 上传文件
		// 获得url
		StringBuilder url = new StringBuilder();
		String filePath = imgIDUrl;
		// 生成随机文件名
		String fileName = FileUtil.generateFileName(file);
		url.append(filePath).append(fileName);
		// 上传
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			log.error("【添加身份证】：文件上传失败");
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		// 存入数据库
		IdentifyCard identifyCard = new IdentifyCard();
		BeanUtils.copyProperties(form, identifyCard);
//		String identifyCardId = GenerateIdUtil.getIdentifyCardId(identifyCardMapper);
		String identifyCardId = generateIdUtil.getRandomId(identifyCardMapper, "ID");
		identifyCard.setIdentityCardId(identifyCardId);
		identifyCard.setVerificationStatus(1);
		identifyCard.setIdentityCardPicUrl(url.toString());
		identifyCardMapper.insert(identifyCard);
		Map map = new HashMap();
		map.put("identifyCardId", identifyCardId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deleteID(String identifyCardId) {
		IdentifyCard identifyCard = identifyCardMapper.selectByPrimaryKey(identifyCardId);
		if (identifyCard == null) {
			log.error("【删除身份证】：身份证不存在");
			return ResultVOUtil.error(ResultEnum.ID_NOT_EXIST_ERROR);
		}
		// 删除图片
		FileUtil.deleteFile(identifyCard.getIdentityCardPicUrl());
		int delete = identifyCardMapper.deleteByPrimaryKey(identifyCardId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO updateID(UpdateIDForm form, MultipartFile file) {
		IdentifyCard identifyCard = identifyCardMapper.selectByPrimaryKey(form.getIdentityCardId());
		if (identifyCard == null) {
			return ResultVOUtil.error(ResultEnum.ID_NOT_EXIST_ERROR);
		}
		if (!file.isEmpty()) {
			// 删除原来的图片
			FileUtil.deleteFile(identifyCard.getIdentityCardPicUrl());
			// 上传新的图片
			String filePath = imgIDUrl;
			String fileName = FileUtil.generateFileName(file);
			boolean upload = FileUtil.upload(file, filePath, fileName);
			if (!upload) {
				return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
			}
			// 设置新的url
			StringBuilder url = new StringBuilder(filePath).append(fileName);
			identifyCard.setIdentityCardPicUrl(url.toString());
		}
		// 更新数据库
		BeanUtils.copyProperties(form, identifyCard);
		int update = identifyCardMapper.updateByPrimaryKey(identifyCard);
		if (update != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("更新成功");
	}

	@Override
	public ResultVO getID(String identifyCardId) {
		IdentifyCard identifyCard = identifyCardMapper.selectByPrimaryKey(identifyCardId);
		return ResultVOUtil.success(identifyCard);
	}

	@Override
	public ResultVO getAllID(String materialId) {
		List<IdentifyCard> identifyCards = identifyCardMapper.selectByMaterialId(materialId);
		return ResultVOUtil.success(identifyCards);
	}

	@Override
	public ResultVO insertEducationProve(String materialId, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(materialId) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传文件
		String filePath = educationProveUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);
		// 存入数据库
		EducationProve educationProve = new EducationProve();
		educationProve.setMaterialId(materialId);
//		String educationId = GenerateIdUtil.getEducationId(educationProveMapper);
		String educationId = generateIdUtil.getRandomId(educationProveMapper, "EP");
		educationProve.setEducationId(educationId);
		educationProve.setEducationProveStatus(1);
		educationProve.setEducationPicUrl(url.toString());
		int insert = educationProveMapper.insert(educationProve);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("educationId", educationId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deleteEducationProve(String educationId) {
		EducationProve educationProve = educationProveMapper.selectByPrimaryKey(educationId);
		if (educationProve == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		FileUtil.deleteFile(educationProve.getEducationPicUrl());
		int delete = educationProveMapper.deleteByPrimaryKey(educationId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO getEducationProve(String educationId) {
		EducationProve educationProve = educationProveMapper.selectByPrimaryKey(educationId);
		return ResultVOUtil.success(educationProve);
	}

	@Override
	public ResultVO getAllEducationProve(String materialId) {
		List<EducationProve> educationProves = educationProveMapper.selectByMaterialId(materialId);
		return ResultVOUtil.success(educationProves);
	}

	@Override
	public ResultVO insertSocialInfo(SocialInfoForm form, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(form.getMaterialId()) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传文件
		String filePath = socialInfoUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);

		//存入数据库
		SocialInfo socialInfo = new SocialInfo();
		BeanUtils.copyProperties(form, socialInfo);
//		String socialInfoId = GenerateIdUtil.getSocialInfoId(socialInfoMapper);
		String socialInfoId = generateIdUtil.getRandomId(socialInfoMapper, "SI");
		socialInfo.setSocialInfoId(socialInfoId);
		socialInfo.setSupportingMaterialUrl(url.toString());
		int insert = socialInfoMapper.insert(socialInfo);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("socialInfoId", socialInfoId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deleteSocialInfo(String socialInfoId) {
		SocialInfo socialInfo = socialInfoMapper.selectByPrimaryKey(socialInfoId);
		if (socialInfo == null) {
			return ResultVOUtil.error(ResultEnum.SOCIAL_INFO_NOT_EXIST_ERROR);
		}
		// 删除图片
		FileUtil.deleteFile(socialInfo.getSupportingMaterialUrl());
		int delete = socialInfoMapper.deleteByPrimaryKey(socialInfoId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO updateSocialInfo(UpdateSocialInfoForm form, MultipartFile file) {
		SocialInfo socialInfo = socialInfoMapper.selectByPrimaryKey(form.getSocialInfoId());
		if (socialInfo == null) {
			return ResultVOUtil.error(ResultEnum.SOCIAL_INFO_NOT_EXIST_ERROR);
		}
		if (!file.isEmpty()) {
			// 删除原来的图片
			FileUtil.deleteFile(socialInfo.getSupportingMaterialUrl());
			// 上传新的图片
			String filePath = socialInfoUrl;
			String fileName = FileUtil.generateFileName(file);
			boolean upload = FileUtil.upload(file, filePath, fileName);
			if (!upload) {
				return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
			}
			// 设置新的url
			StringBuilder url = new StringBuilder(filePath).append(fileName);
		}
		// 更新数据库
		BeanUtils.copyProperties(form, socialInfo);
		int update = socialInfoMapper.updateByPrimaryKey(socialInfo);
		if (update != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("更新成功");
	}

	@Override
	public ResultVO getSocialInfo(String socialInfoId) {
		SocialInfo socialInfo = socialInfoMapper.selectByPrimaryKey(socialInfoId);
		return ResultVOUtil.success(socialInfo);
	}

	@Override
	public ResultVO getAllSocialInfo(String materialId) {
		List<SocialInfo> socialInfos = socialInfoMapper.selectByMaterialId(materialId);
		return ResultVOUtil.success(socialInfos);
	}

	@Override
	public ResultVO insertEntryRegister(String materialId, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(materialId) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		//上传文件
		String filePath = registerUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);

		// 存入数据库
		EntryRegister entryRegister = new EntryRegister();
		entryRegister.setMaterialId(materialId);
//		String registerId = GenerateIdUtil.getRegisterId(entryRegisterMapper);
		String registerId = generateIdUtil.getRandomId(entryRegisterMapper, "ER");
		entryRegister.setRegisterId(registerId);
		entryRegister.setRegisterPicUrl(url.toString());
		entryRegister.setRegisterPassStatus(1);
		int insert = entryRegisterMapper.insert(entryRegister);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("registerId", registerId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deleteEntryRegister(String registerId) {
		EntryRegister entryRegister = entryRegisterMapper.selectByPrimaryKey(registerId);
		if (entryRegister == null) {
			return ResultVOUtil.error(ResultEnum.ENTRY_REGISTER_NOT_EXIST_ERROR);
		}
		// 删除图片
		FileUtil.deleteFile(entryRegister.getRegisterPicUrl());
		int delete = entryRegisterMapper.deleteByPrimaryKey(registerId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO getEntryRegister(String registerId) {
		EntryRegister entryRegister = entryRegisterMapper.selectByPrimaryKey(registerId);
		return ResultVOUtil.success(entryRegister);
	}

	@Override
	public ResultVO getAllEntryRegister(String materialId) {
		List<EntryRegister> entryRegisters = entryRegisterMapper.selectByMaterialId(materialId);
		return ResultVOUtil.success(entryRegisters);
	}

	@Override
	public ResultVO insertPhysicalExamination(String materialId, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(materialId) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传图片
		String filePath = physicalExaminationUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);

		// 存入数据库
		EntryPhysicalExamination physicalExamination = new EntryPhysicalExamination();
		physicalExamination.setMaterialId(materialId);
//		String physicalExaminationId = GenerateIdUtil.getPhysicalExaminationId(entryPhysicalExaminationMapper);
		String physicalExaminationId = generateIdUtil.getRandomId(entryPhysicalExaminationMapper, "EP");
		physicalExamination.setPhysicalExaminationId(physicalExaminationId);
		physicalExamination.setPhysicalExaminationStatus(1);
		physicalExamination.setPhysicalExaminationPicUrl(url.toString());
		int insert = entryPhysicalExaminationMapper.insert(physicalExamination);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("message", "添加成功");
		map.put("physicalExaminationId", physicalExaminationId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deletePhysicalExamination(String examinationId) {
		EntryPhysicalExamination physicalExamination = entryPhysicalExaminationMapper.selectByPrimaryKey(examinationId);
		if (physicalExamination == null) {
			return ResultVOUtil.error(ResultEnum.PHYSICAL_EXAMINATION_NOT_EXIST_ERROR);
		}
		String physicalExaminationPicUrl = physicalExamination.getPhysicalExaminationPicUrl();
		// 删除图片
		FileUtil.deleteFile(physicalExaminationPicUrl);
		int delete = entryPhysicalExaminationMapper.deleteByPrimaryKey(examinationId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO getPhysicalExamination(String examinationId) {
		return ResultVOUtil.success(entryPhysicalExaminationMapper.selectByPrimaryKey(examinationId));
	}

	@Override
	public ResultVO getAllPhysicalExamination(String materialId) {
		return ResultVOUtil.success(entryPhysicalExaminationMapper.selectByMaterialId(materialId));
	}

	@Override
	public ResultVO insertQuitProve(String materialId, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(materialId) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传图片
		String filePath = quitProveUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);
		// 存入数据库
		QuitProve quitProve = new QuitProve();
		quitProve.setMaterialId(materialId);
//		String quitId = GenerateIdUtil.getQuitId(quitProveMapper);
		String quitId = generateIdUtil.getRandomId(quitProveMapper, "QP");
		quitProve.setQuitId(quitId);
		quitProve.setQuitFilePicUrl(url.toString());
		quitProve.setQuitStatus(1);
		int insert = quitProveMapper.insert(quitProve);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("message", "添加成功");
		map.put("quitId", quitId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deleteQuitProve(String quitId) {
		QuitProve quitProve = quitProveMapper.selectByPrimaryKey(quitId);
		if (quitProve == null) {
			return ResultVOUtil.error(ResultEnum.QUIT_PROVE_NOT_EXIST_ERROR);
		}
		String quitFilePicUrl = quitProve.getQuitFilePicUrl();
		// 删除图片
		FileUtil.deleteFile(quitFilePicUrl);
		int delete = quitProveMapper.deleteByPrimaryKey(quitId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO getQuitProve(String quitId) {
		return ResultVOUtil.success(quitProveMapper.selectByPrimaryKey(quitId));
	}

	@Override
	public ResultVO getAllQuitProve(String materialId) {
		return ResultVOUtil.success(quitProveMapper.selectByMaterialId(materialId));
	}

	@Override
	public ResultVO insertProveFile(ProveFileForm proveFileForm, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(proveFileForm.getMaterialId()) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 判断项目是否已存在证明文件
		if (proveFileMapper.selectByProjectId(proveFileForm.getProjectId()) != null) {
			return ResultVOUtil.error(ResultEnum.PROJECT_PROVE_FILE_EXIST_ERROR);
		}
		// 上传文件
		String filePath = proveFileUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);

		// 存入数据库
		ProveFile proveFile = new ProveFile();
		BeanUtils.copyProperties(proveFileForm, proveFile);
		proveFile.setProveFilePicUrl(url.toString());
//		String proveId = GenerateIdUtil.getProveId(proveFileMapper);
		String proveId = generateIdUtil.getRandomId(proveFileMapper, "PF");
		proveFile.setProveId(proveId);
		proveFile.setProveStatus(1);
		int insert = proveFileMapper.insert(proveFile);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("message", "添加成功");
		map.put("proveId", proveId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deleteProveFile(String proveId) {
		ProveFile proveFile = proveFileMapper.selectByPrimaryKey(proveId);
		if (proveFile == null) {
			return ResultVOUtil.error(ResultEnum.PROVE_FILE_NOT_EXIST_ERROR);
		}
		// 删除图片
		FileUtil.deleteFile(proveFile.getProveFilePicUrl());
		// 删除数据库记录
		int delete = proveFileMapper.deleteByPrimaryKey(proveId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO updateProveFile(UpdateProveFileForm form, MultipartFile file) {
		ProveFile proveFile = proveFileMapper.selectByPrimaryKey(form.getProveId());
		if (proveFile == null) {
			return ResultVOUtil.error(ResultEnum.PROVE_FILE_NOT_EXIST_ERROR);
		}
		if (!file.isEmpty()) {
			// 删除原来的图片
			FileUtil.deleteFile(proveFile.getProveFilePicUrl());
			// 上传新的图片
			String filePath = proveFileUrl;
			String fileName = FileUtil.generateFileName(file);
			boolean upload = FileUtil.upload(file, filePath, fileName);
			if (!upload) {
				return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
			}
			// 设置新的url
			StringBuilder url = new StringBuilder(filePath).append(fileName);
			proveFile.setProveFilePicUrl(url.toString());
		}
		BeanUtils.copyProperties(form, proveFile);
		int update = proveFileMapper.updateByPrimaryKey(proveFile);
		if (update != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("更新成功");
	}

	@Override
	public ResultVO getProveFile(String proveId) {
		return ResultVOUtil.success(proveFileMapper.selectByPrimaryKey(proveId));
	}

	@Override
	public ResultVO getAllProveFile(String materialId) {
		return ResultVOUtil.success(proveFileMapper.selectByMaterialId(materialId));
	}

	@Override
	public ResultVO insertContract(ContractForm form, MultipartFile file) {
		if (personnelMaterialMapper.selectByPrimaryKey(form.getMaterialId()) == null) {
			return ResultVOUtil.error(ResultEnum.PERSONNEL_MATERIAL_NOT_EXIST_ERROR);
		}
		// 上传图片
		String filePath = contractUrl;
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		StringBuilder url = new StringBuilder();
		url.append(filePath).append(fileName);

		// 存入数据库
		Contract contract = new Contract();
		BeanUtils.copyProperties(form, contract);
		contract.setContractFilePicUrl(url.toString());
		contract.setContractStatus(1);
//		String contractId = GenerateIdUtil.getContractId(contractMapper);
		String contractId = generateIdUtil.getRandomId(contractMapper, "CO");
		contract.setContractId(contractId);
		int insert = contractMapper.insert(contract);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		Map map = new HashMap();
		map.put("message", "添加成功");
		map.put("contractId", contractId);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deleteContract(String contractId) {
		Contract contract = contractMapper.selectByPrimaryKey(contractId);
		if (contract == null) {
			return ResultVOUtil.error(ResultEnum.CONTRACT_NOT_EXIST_ERROR);
		}
		// 删除图片
		FileUtil.deleteFile(contract.getContractFilePicUrl());
		// 删除数据库记录
		int delete = contractMapper.deleteByPrimaryKey(contractId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO updateContract(UpdateContractForm form, MultipartFile file) {
		Contract contract = contractMapper.selectByPrimaryKey(form.getContractId());
		if (contract == null) {
			return ResultVOUtil.error(ResultEnum.CONTRACT_NOT_EXIST_ERROR);
		}
		if (!file.isEmpty()) {
			// 删除原来的图片
			FileUtil.deleteFile(contract.getContractFilePicUrl());
			// 上传新的图片
			String filePath = contractUrl;
			String fileName = FileUtil.generateFileName(file);
			boolean upload = FileUtil.upload(file, filePath, fileName);
			if (!upload) {
				return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
			}
			// 设置新的url
			StringBuilder url = new StringBuilder(filePath).append(fileName);
			contract.setContractFilePicUrl(url.toString());
		}
		// 更新数据库
		BeanUtils.copyProperties(form, contract);
		int update = contractMapper.updateByPrimaryKey(contract);
		if (update != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("更新成功");
	}

	@Override
	public ResultVO getContract(String contractId) {
		return ResultVOUtil.success(contractMapper.selectByPrimaryKey(contractId));
	}

	@Override
	public ResultVO getAllContract(String materialId) {
		return ResultVOUtil.success(contractMapper.selectByMaterialId(materialId));
	}

	@Override
	public ResultVO browsePersonnelMaterial(String materialId) {
		PersonnelMaterial personnelMaterial = personnelMaterialMapper.selectByPrimaryKey(materialId);
		List<IdentifyCard> identifyCards = identifyCardMapper.selectByMaterialId(materialId);
		List<EducationProve> educationProves = educationProveMapper.selectByMaterialId(materialId);
		List<SocialInfo> socialInfos = socialInfoMapper.selectByMaterialId(materialId);
		List<EntryRegister> entryRegisters = entryRegisterMapper.selectByMaterialId(materialId);
		List<EntryPhysicalExamination> entryPhysicalExaminations = entryPhysicalExaminationMapper.selectByMaterialId(materialId);
		List<QuitProve> quitProves = quitProveMapper.selectByMaterialId(materialId);
		List<ProveFile> proveFiles = proveFileMapper.selectByMaterialId(materialId);
		List<Contract> contracts = contractMapper.selectByMaterialId(materialId);
		Map map = new HashMap();
		map.put("personnelMaterial", personnelMaterial);
		map.put("identifyCards", identifyCards);
		map.put("educationProves", educationProves);
		map.put("socialInfos", socialInfos);
		map.put("entryRegisters", entryRegisters);
		map.put("entryPhysicalExaminations", entryPhysicalExaminations);
		map.put("quitProves", quitProves);
		map.put("proveFiles", proveFiles);
		map.put("contracts", contracts);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO deletePersonnelMaterial(String materialId) {
		PersonnelMaterial personnelMaterial = personnelMaterialMapper.selectByPrimaryKey(materialId);
		List<IdentifyCard> identifyCards = identifyCardMapper.selectByMaterialId(materialId);
		for (int i = 0; i < identifyCards.size(); i++) {
			IdentifyCard identifyCard = identifyCards.get(i);
			deleteID(identifyCard.getIdentityCardId());
		}
		List<EducationProve> educationProves = educationProveMapper.selectByMaterialId(materialId);
		for (int i = 0; i < educationProves.size(); i++) {
			EducationProve educationProve = educationProves.get(i);
			deleteEducationProve(educationProve.getEducationId());
		}
		List<SocialInfo> socialInfos = socialInfoMapper.selectByMaterialId(materialId);
		for (int i = 0; i < socialInfos.size(); i++) {
			SocialInfo socialInfo = socialInfos.get(i);
			deleteSocialInfo(socialInfo.getSocialInfoId());
		}
		List<EntryRegister> entryRegisters = entryRegisterMapper.selectByMaterialId(materialId);
		for (int i = 0; i < entryRegisters.size(); i++) {
			EntryRegister entryRegister = entryRegisters.get(i);
			deleteEntryRegister(entryRegister.getRegisterId());
		}
		List<EntryPhysicalExamination> entryPhysicalExaminations = entryPhysicalExaminationMapper.selectByMaterialId(materialId);
		for (int i = 0; i < entryPhysicalExaminations.size(); i++) {
			EntryPhysicalExamination physicalExamination = entryPhysicalExaminations.get(i);
			deletePhysicalExamination(physicalExamination.getPhysicalExaminationId());
		}
		List<QuitProve> quitProves = quitProveMapper.selectByMaterialId(materialId);
		for (int i = 0; i < quitProves.size(); i++) {
			QuitProve quitProve = quitProves.get(i);
			deleteQuitProve(quitProve.getQuitId());
		}
		List<ProveFile> proveFiles = proveFileMapper.selectByMaterialId(materialId);
		for (int i = 0; i < proveFiles.size(); i++) {
			ProveFile proveFile = proveFiles.get(i);
			deleteProveFile(proveFile.getProveId());
		}
		List<Contract> contracts = contractMapper.selectByMaterialId(materialId);
		for (int i = 0; i < contracts.size(); i++) {
			Contract contract = contracts.get(i);
			deleteContract(contract.getContractId());
		}
		personnelMaterialMapper.deleteByPrimaryKey(materialId);
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO getAllPersonnelMaterial() {
		List<PersonnelMaterial> personnelMaterials = personnelMaterialMapper.selectAll();
		return ResultVOUtil.success(personnelMaterials);
	}

}
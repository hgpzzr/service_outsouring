package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/19 20:01
 */
public interface BatchService {
	/**
	 * 通过excel批量上传技能特长
	 * @param file
	 * @return
	 * @throws IOException
	 */
	ResultVO batchUploadSkill(MultipartFile file) throws IOException;

	ResultVO batchUploadEducationBackground(MultipartFile file);
}

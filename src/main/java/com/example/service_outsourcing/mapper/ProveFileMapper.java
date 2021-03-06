package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.ProveFile;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProveFileMapper {
    int deleteByPrimaryKey(String proveId);

    int insert(ProveFile record);

    ProveFile selectByPrimaryKey(String proveId);

    ProveFile selectByProjectId(String projectId);

    List<ProveFile> selectByMaterialId(String materialId);

    List<ProveFile> selectAll();

    int updateByPrimaryKey(ProveFile record);
}
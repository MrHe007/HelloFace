package com.hnit.face.dao;

import com.hnit.face.bean.Face;
import com.hnit.face.bean.FaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FaceMapper {
    long countByExample(FaceExample example);

    int deleteByExample(FaceExample example);

    int insert(Face record);

    int insertSelective(Face record);

    List<Face> selectByExample(FaceExample example);

    int updateByExampleSelective(@Param("record") Face record, @Param("example") FaceExample example);

    int updateByExample(@Param("record") Face record, @Param("example") FaceExample example);
}
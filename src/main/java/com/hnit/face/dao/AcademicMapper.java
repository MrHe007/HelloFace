package com.hnit.face.dao;

import com.hnit.face.bean.Academic;
import com.hnit.face.bean.AcademicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicMapper {
    long countByExample(AcademicExample example);

    int deleteByExample(AcademicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Academic record);

    int insertSelective(Academic record);

    List<Academic> selectByExample(AcademicExample example);

    Academic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Academic record, @Param("example") AcademicExample example);

    int updateByExample(@Param("record") Academic record, @Param("example") AcademicExample example);

    int updateByPrimaryKeySelective(Academic record);

    int updateByPrimaryKey(Academic record);
}
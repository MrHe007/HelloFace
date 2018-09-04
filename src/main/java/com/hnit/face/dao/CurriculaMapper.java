package com.hnit.face.dao;

import com.hnit.face.bean.Curricula;
import com.hnit.face.bean.CurriculaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurriculaMapper {
    long countByExample(CurriculaExample example);

    int deleteByExample(CurriculaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Curricula record);

    int insertSelective(Curricula record);

    List<Curricula> selectByExample(CurriculaExample example);

    Curricula selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Curricula record, @Param("example") CurriculaExample example);

    int updateByExample(@Param("record") Curricula record, @Param("example") CurriculaExample example);

    int updateByPrimaryKeySelective(Curricula record);

    int updateByPrimaryKey(Curricula record);
}
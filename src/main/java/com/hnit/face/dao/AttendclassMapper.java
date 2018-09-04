package com.hnit.face.dao;

import com.hnit.face.bean.Attendclass;
import com.hnit.face.bean.AttendclassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendclassMapper {
    long countByExample(AttendclassExample example);

    int deleteByExample(AttendclassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attendclass record);

    int insertSelective(Attendclass record);

    List<Attendclass> selectByExample(AttendclassExample example);

    Attendclass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attendclass record, @Param("example") AttendclassExample example);

    int updateByExample(@Param("record") Attendclass record, @Param("example") AttendclassExample example);

    int updateByPrimaryKeySelective(Attendclass record);

    int updateByPrimaryKey(Attendclass record);
}
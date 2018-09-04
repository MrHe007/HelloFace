package com.hnit.face.dao;

import com.hnit.face.bean.TeacherApply;
import com.hnit.face.bean.TeacherApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherApplyMapper {
    long countByExample(TeacherApplyExample example);

    int deleteByExample(TeacherApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherApply record);

    int insertSelective(TeacherApply record);

    List<TeacherApply> selectByExample(TeacherApplyExample example);

    TeacherApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherApply record, @Param("example") TeacherApplyExample example);

    int updateByExample(@Param("record") TeacherApply record, @Param("example") TeacherApplyExample example);

    int updateByPrimaryKeySelective(TeacherApply record);

    int updateByPrimaryKey(TeacherApply record);
}
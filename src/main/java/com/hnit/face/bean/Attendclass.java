package com.hnit.face.bean;

import java.util.Date;

public class Attendclass {
    private Integer id;

    private Integer curriculaId;

    private Integer courseId;

    private Date time;

    private String situation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurriculaId() {
        return curriculaId;
    }

    public void setCurriculaId(Integer curriculaId) {
        this.curriculaId = curriculaId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }
}
package com.hnit.face.bean;

import java.util.Date;

public class Register {
    private Integer id;

    private Integer classId;

    private String studentId;

    private Integer teacherId;

    private String coureName;

    private String situation;

    private Date time;
    
    public Register() {
    	
    }
    

    public Register( Integer classId, String studentId, Integer teacherId, String coureName,
			String situation, Date time) {
		this.classId = classId;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.coureName = coureName;
		this.situation = situation;
		this.time = time;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getCoureName() {
        return coureName;
    }

    public void setCoureName(String coureName) {
        this.coureName = coureName == null ? null : coureName.trim();
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
package com.hnit.face.to;

public class StudentRegTo {
	
	private String className;
	private String stuId;
	private String name;
	private String email;
	private String situation;
	
	public StudentRegTo() {}
	
	public StudentRegTo(String className, String stuId, String name, String email, String situation) {
		super();
		this.className = className;
		this.stuId = stuId;
		this.name = name;
		this.email = email;
		this.situation = situation;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	@Override
	public String toString() {
		return "StudentRegTo [className=" + className + ", stuId=" + stuId + ", name=" + name + ", email=" + email
				+ ", situation=" + situation + "]";
	}
	
	

}
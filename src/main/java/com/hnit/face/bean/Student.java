package com.hnit.face.bean;

public class Student {
    private String stuId;

    private Integer classId;

    private String faceId;

    private String name;

    private String password;

    private String sex;

    private String contact;

    private String email;

    private Integer age;

    private String image;

    private String state;
    
    public  Student() {
    	this.classId = 3 ; 		// 默认的 stuId 为 3 ,为了增加学生不增加班级 id 的方便性 
    	this.password="abc";
    	this.sex = "1"; 
    	this.age=18;
    	this.name="hc";
    }

    @Override
	public String toString() {
		return "Student [stuId=" + stuId + ", classId=" + classId + ", faceId=" + faceId + ", name=" + name
				+ ", password=" + password + ", sex=" + sex + ", contact=" + contact + ", email=" + email + ", age="
				+ age + ", image=" + image + "]";
	}

	public Student(String stuId, Integer classId, String faceId, String name, String password, String sex,
			String contact, String email, Integer age, String image) {
		super();
		this.stuId = stuId;
		this.classId = classId;
		this.faceId = faceId;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.contact = contact;
		this.email = email;
		this.age = age;
		this.image = image;
	}

	public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId == null ? null : faceId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
package com.hnit.face.bean;

public class Teacher {
    private Integer id;

    private Integer academicId;

    private Integer age;

    private String name;

    private String sex;

    private String contact;

    private String image;

    private String loginName;

    private String loginPass;

    private String state;
    
    public Teacher() {
    	
    }

    public Teacher(Integer academicId, Integer age, String name, String sex, String contact, String image,
			String loginName, String loginPass, String state) {
		super();
		
		this.academicId = academicId;
		this.age = age;
		this.name = name;
		this.sex = sex;
		this.contact = contact;
		this.image = image;
		this.loginName = loginName;
		this.loginPass = loginPass;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", academicId=" + academicId + ", age=" + age + ", name=" + name + ", sex=" + sex
				+ ", contact=" + contact + ", image=" + image + ", loginName=" + loginName + ", loginPass=" + loginPass
				+ "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAcademicId() {
        return academicId;
    }

    public void setAcademicId(Integer academicId) {
        this.academicId = academicId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass == null ? null : loginPass.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
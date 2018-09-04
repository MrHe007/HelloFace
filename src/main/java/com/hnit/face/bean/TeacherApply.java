package com.hnit.face.bean;

public class TeacherApply {
    private Integer id;

    private Integer academicId;

    private Integer age;

    private String name;

    private Integer sex;

    private String contact;

    private String image;

    private String loginName;

    private String loginPass;

    private Integer state;
    
    public TeacherApply() {
    	this.age = 23;
    	this.academicId = 3; 
    	this.state = 0; 		// 默认比不激活的状态 
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "TeacherApply [id=" + id + ", academicId=" + academicId + ", age=" + age + ", name=" + name + ", sex="
				+ sex + ", contact=" + contact + ", image=" + image + ", loginName=" + loginName + ", loginPass="
				+ loginPass + ", state=" + state + "]";
	}
    
    
    
}
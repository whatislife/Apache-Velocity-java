/**
 * 
 */
package com.b510.velocity.bean;


/**
 * 用户实体类
 * 
 * @author hongten<br>
 * @date 2013-3-9
 */
public class User {

	/**
	 * 用户编号
	 */
	private Integer id;
	/**
	 * 用户名称
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 邮箱
	 */
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

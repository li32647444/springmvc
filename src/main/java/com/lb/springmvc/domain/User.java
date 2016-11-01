package com.lb.springmvc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SYS_USER")
	@SequenceGenerator(name = "SEQ_SYS_USER", allocationSize = 1, initialValue = 1, sequenceName = "SEQ_SYS_USER")
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String userName;
	@Column(name = "USER_PASSWORD", nullable = false)
	private String password;
	/**
	 * 用户状态0:锁定1:正常(默认)
	 */
	@Column(name = "USER_STATE", nullable = false)
	private Integer state;

	@ManyToMany
	@JoinTable(name = "SYS_USER_ROLE", 
		joinColumns = { @JoinColumn(name = "user_id") }, 
		inverseJoinColumns = {@JoinColumn(name = "role_id") })
	private List<Role> roles;

	public User() {
	}
	public User(String userName) {
		this.userName = userName;
	}
	public User(String userName, String password,Integer status) {
		this.userName = userName;
		this.password = password;
		this.state = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "id:" + id + " userName:" + userName + " password:******";
	}
}

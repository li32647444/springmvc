package com.lb.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEST_USER")     
    @SequenceGenerator(name="SEQ_TEST_USER",allocationSize=1,initialValue=1, sequenceName="SEQ_TEST_USER")  
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;
	@Column(name = "USER_NAME", unique = true,nullable = false)
	private String userName;
	@Column(name = "USER_PASSWORD", nullable = false)
	private String password;
	
	public User(){}
	public User(String userName,String password){
		this.userName = userName;
		this.password = password;
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
	
	public String toString(){
		return "id:"+id+" userName:"+userName+" password:******";
	}
}

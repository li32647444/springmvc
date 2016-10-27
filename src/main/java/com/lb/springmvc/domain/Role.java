package com.lb.springmvc.domain;

import java.util.Date;
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
@Table(name = "SYS_ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SYS_ROLE")     
    @SequenceGenerator(name="SEQ_SYS_ROLE",allocationSize=1,initialValue=1, sequenceName="SEQ_SYS_ROLE")  
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ROLE_NAME", unique = true,nullable = false)
	private String name;
	
	@Column(name = "CREATE_TIME")
	private Date createTime;
	
	@Column(name = "REMARK")
	private String remark;

	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	@ManyToMany
	@JoinTable(name = "SYS_ROLE_MODEL", 
		joinColumns = { @JoinColumn(name = "role_id") }, 
		inverseJoinColumns = {@JoinColumn(name = "module_id") })
	private List<Module> modules;
	
	public Role(){}
	public Role(String name){
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}

package com.lb.springmvc.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_MODULE")
public class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SYS_MODULE")     
    @SequenceGenerator(name="SEQ_SYS_MODULE",allocationSize=1,initialValue=1, sequenceName="SEQ_SYS_MODULE")  
	@Column(name = "MODULE_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "MODULE_NAME", unique = true,nullable = false)
	private String name;
	
	@Column(name = "MODULE_URL")
	private String url;
	
	@Column(name = "CREATE_TIME")
	private Date createTime;
	
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 菜单等级
	 */
	@Column(name = "MODULE_LEVEL", nullable = true)
	private Integer moduleLevel;
	/**
	 * 菜单权重
	 */
	@Column(name = "MODULE_WEIGHT", nullable = true)
	private Integer moduleWeight;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "FATHERMODULE_ID",nullable=true)
	private Module fatherModule;
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy="fatherModule")
	@OrderBy(value="moduleWeight asc")
	private List<Module> moduleChildrens;
	
	@ManyToMany(mappedBy="modules")
	private List<Role> roles;

	public Module(){}
	public Module(String name,String url,Integer moduleLevel,Integer moduleWeight){
		this.name = name;
		this.url = url;
		this.moduleLevel = moduleLevel;
		this.moduleWeight = moduleWeight;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getModuleLevel() {
		return moduleLevel;
	}
	public void setModuleLevel(Integer moduleLevel) {
		this.moduleLevel = moduleLevel;
	}
	public Integer getModuleWeight() {
		return moduleWeight;
	}
	public void setModuleWeight(Integer moduleWeight) {
		this.moduleWeight = moduleWeight;
	}
	public Module getFatherModule() {
		return fatherModule;
	}
	public void setFatherModule(Module fatherModule) {
		this.fatherModule = fatherModule;
	}
	public List<Module> getModuleChildrens() {
		return moduleChildrens;
	}
	public void setModuleChildrens(List<Module> moduleChildrens) {
		this.moduleChildrens = moduleChildrens;
	}
}

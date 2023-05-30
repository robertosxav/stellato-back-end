package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.TemporalType;

@Entity
@Table(name = "public.flyway_schema_history") 
public class FlywaySchemaHistory implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "installed_rank")
	private Long installedRank;

	@Column(name = "version")
	private String version;

	@Column(name = "description")
	private String description;

	@Column(name = "type")
	private String type;

	@Column(name = "script")
	private String script;

	@Column(name = "checksum")
	private Integer checksum;

	@Column(name = "installed_by")
	private String installedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "installed_on")
	private Date installedOn;

	@Column(name = "execution_time")
	private Integer executionTime;

	@Column(name = "success")
	private Integer success;

	public Long getInstalledRank() {
		return installedRank;
	}
	 
	public void setInstalledRank(Long installedRank) {
		this.installedRank = installedRank;
	}
	 
	public String getVersion() {
		return version;
	}
	 
	public void setVersion(String version) {
		this.version = version;
	}
	 
	public String getDescription() {
		return description;
	}
	 
	public void setDescription(String description) {
		this.description = description;
	}
	 
	public String getType() {
		return type;
	}
	 
	public void setType(String type) {
		this.type = type;
	}
	 
	public String getScript() {
		return script;
	}
	 
	public void setScript(String script) {
		this.script = script;
	}
	 
	public Integer getChecksum() {
		return checksum;
	}
	 
	public void setChecksum(Integer checksum) {
		this.checksum = checksum;
	}
	 
	public String getInstalledBy() {
		return installedBy;
	}
	 
	public void setInstalledBy(String installedBy) {
		this.installedBy = installedBy;
	}
	 
	public Date getInstalledOn() {
		return installedOn;
	}
	 
	public void setInstalledOn(Date installedOn) {
		this.installedOn = installedOn;
	}
	 
	public Integer getExecutionTime() {
		return executionTime;
	}
	 
	public void setExecutionTime(Integer executionTime) {
		this.executionTime = executionTime;
	}
	 
	public Integer getSuccess() {
		return success;
	}
	 
	public void setSuccess(Integer success) {
		this.success = success;
	}
	 

} 

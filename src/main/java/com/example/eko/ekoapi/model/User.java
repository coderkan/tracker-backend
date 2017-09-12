package com.example.eko.ekoapi.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"id", "email"})})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique=true)
	private Integer id;
	
	private String name;
	
	@NotNull
	@Column(name="email", unique=true, length=50)
	private String email;
	
	private String password;
	
	private Date createDate;
	private Date modifyDate;

	public User() {
		
	}
	
	public User(String name, String email, String password) {
		setName(name);
		setEmail(email);
		setPassword(password);
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@PrePersist
	public void onCreate() {
		createDate = modifyDate = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		modifyDate = new Date();
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getModifiedDate() {
		return this.modifyDate;
	}
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifyDate = modifiedDate;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

/*
create table user
 (
 id int AUTO_INCREMENT NOT NULL,
 name VARCHAR(100),
 email VARCHAR(100),
 password VARCHAR(100) NOT NULL ,
 create_date Date,
 modify_date Date,
 primary key(id, password)) ;
*/


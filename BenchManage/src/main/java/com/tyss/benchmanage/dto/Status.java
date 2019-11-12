package com.tyss.benchmanage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table
@Data
public class Status {
	@Id
	@GenericGenerator(name="String_based_custom_sequence",strategy="com.tyss.benchmanage.controller.StatusIdGenerator")
	@GeneratedValue(generator= "String_based_custom_sequence")
	@Column(name="status_Id")
private String statusId;
	@Column(name="req_Id")
private int reqId;
	@Column(name="user_Id")
private int userId;
	@Column(name="status")
private String status;
}

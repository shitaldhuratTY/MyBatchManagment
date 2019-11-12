package com.tyss.benchmanage.dto;

import java.util.Date;

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
public class Requriments {
	@Id
	@GenericGenerator(name="String_based_custom_sequence",strategy="com.tyss.benchmanage.controller.RequrimentIdGenerator")
	@GeneratedValue(generator= "String_based_custom_sequence")
	@Column(name="req_Id")
	private int reqId;
	@Column(name="client_id")
	private String clientId;
	@Column(name="company_name")
	private String companyName;
	@Column(name="role")
	private String role;
	@Column(name="no_of_openings")
	private int noOfOpenings;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="date_Of_Interview")
	private  Date dateOfInterview;
	@Column(name="time")
	private  Date time;
	@Column(name="location")
	private String location;
	@Column(name="no_Of_Students")
	private int noOfStudents;
	@Column(name="status")
	private String status;
}

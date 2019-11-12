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
public class Client {
	@Id
	@GenericGenerator(name="String_based_custom_sequence",strategy="com.tyss.benchmanage.controller.ClientIdGenerator")
	@GeneratedValue(generator= "String_based_custom_sequence")
	@Column(name="client_id")
private String clientId;
	@Column(name="client_name")
private String Clientname;
}

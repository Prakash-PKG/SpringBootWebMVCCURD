package com.app.pk.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer stdId;
	private String stdName;
	private String stdGen;
	private String stdPwd;
	private String stdCourse;
	private String stdAddr;
	@ElementCollection(fetch =FetchType.EAGER)
	private List<String> stdLangs;
	
}

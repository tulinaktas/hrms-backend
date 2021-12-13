package com.hrms.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertDetails {
	
	private String companyName;
	private String jobPositionName;
	private int openPositionCount;
	//private Date releaseDate;
	private Date dueDate;
	
	
}

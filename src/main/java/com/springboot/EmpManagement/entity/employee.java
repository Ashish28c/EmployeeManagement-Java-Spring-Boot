package com.springboot.EmpManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString


@Entity
public class employee {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String mobile;

}

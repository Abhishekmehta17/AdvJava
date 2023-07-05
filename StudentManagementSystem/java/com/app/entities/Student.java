package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 *eg : first name , last name , email , course title,score obtained. 
 */

@Entity
@Table(name="studentdetails")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = "password")
@JsonIgnoreType
public class Student extends BaseEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String Password;
	@ManyToOne
	private Course title;
	private Integer score;

}

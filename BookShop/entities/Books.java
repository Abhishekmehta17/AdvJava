package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class Books extends BaseEntity {
	//name prise,quantity,gener,Author
	@Column(unique = true,length= 100)
	private String name;
	
	private double price;
	
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	private Gener type;
	
	@ManyToOne
	private Author author;

}

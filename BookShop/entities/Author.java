package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class Author extends BaseEntity {
	@Column(length = 50)
	private String authorName;
	
	private int age;
	
	@Column(length = 50)
	private String address;
	
	@Column(length = 50)
	private String email;
	
	@OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
	private List<Books> allBooks = new ArrayList<>();

}

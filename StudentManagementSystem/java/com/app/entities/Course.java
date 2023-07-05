package com.app.entities;
//course title(unique) , start date , end date , fees , min score

import java.time.LocalDate;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreType
public class Course extends BaseEntity {
	@Column(unique = true)
	private String courseTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer fees;
	private Integer minScore;
	@OneToMany(mappedBy = "title", cascade = CascadeType.ALL)
	private List<Student> studentList = new ArrayList<>();

}

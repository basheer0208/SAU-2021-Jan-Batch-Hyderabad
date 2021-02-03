package com.accolite.kafka.assignment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rank {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer rank;
	
	private String name;
	
	private Integer id;
	
	private Date date;
	
	
	//

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		Date date = new Date();
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public Integer getRank() {
//		return rank;
//	}
//
//	public void setRank(Integer rank) {
//		this.rank = rank;
//	}
	
	
	
	//
	
	

}

package com.example.demo.items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "boot")
public class Boot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int length;
	private String name;
	private String lastName;
	
	@JsonCreator
	public Boot(@JsonProperty("name")String name, @JsonProperty("length")int length) {
		this.name = name;
		this.length = length;
	}
	
	public Boot(){
		this.name = "default";
		this.length = 0;
	}
	
	public long getId() {
		return id;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}

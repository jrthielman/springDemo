package com.example.demo.items;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestingBeans {
	
	@Autowired
	@ElementCollection(fetch= FetchType.EAGER)
	@CollectionTable(name = "categories", joinColumns = @JoinColumn(name="conference_id"))
	@Column(name="category")
	private Set<String> categories;

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}
	
	
	
	
}

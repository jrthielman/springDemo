package com.example.test.settings;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

	@Bean
	public int giveMe40() {
		return 40;
	}
	
	@Bean
	@Primary // niet doen!
	public int giveMe6() {
		return 6;
	}
	
	@Bean
	public Set<String> categories(){
		Set<String> categories = new TreeSet<String>((o1,o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));
		categories.add("TEST");
		categories.add("test");
		return categories;
	}
	
}

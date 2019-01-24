package com.example.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.items.Boot;

@Service
@Transactional
public class BService {
	
	@Autowired
	private Repository repository;

	public Boot save(Boot boot){
		return repository.save(boot);
	}
	
//	public Page<Boot> findByName(String name, Pageable pageRequest) {
//		return repository.findByName(name, pageRequest);
//	}
	
	public Optional<Boot> findById(long id) {
		return repository.findById(id);
	}

	public Iterable <Boot> findAll(){
		Iterable <Boot> result = repository.findAll();
		return result;
	}
}

package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.items.Boot;

public interface Repository extends CrudRepository <Boot, Long>{
	
//	Page<Boot> findByName(String name, Pageable pageable);
	
//	@Modifying
//	@Transactional
//	@Query(value = "update conference set name = :name where id = :id", nativeQuery = true)
//	public int changeName(@Param("id")long id, @Param("name")String name);
}

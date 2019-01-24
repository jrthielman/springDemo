package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.items.Mens;

public interface RepositoryMens extends CrudRepository<Mens, Long> {
}

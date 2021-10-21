package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Visitor;

public interface VisitorRepository extends CrudRepository<Visitor, Long>{

	@Query(value = "select * from visitor where username = ?1",nativeQuery = true)
	Visitor findVisitorByUsername(String telephone);

}

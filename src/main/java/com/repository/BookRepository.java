package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

	List<BookEntity> findAll();
	
	Optional<BookEntity> findByName(String name);
	//Optional<BookEntity> findByAuthorname(String authorname);
	
	Optional<BookEntity> findById(Integer id);
	List<BookEntity> findByPriceBetween(float min, float max);
	
	List<BookEntity> findByAvalaibleind(boolean b);
	
	List<BookEntity> findByAuthorname(String authorname);
}

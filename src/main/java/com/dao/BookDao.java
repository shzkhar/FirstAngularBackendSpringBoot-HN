package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Entity.BookEntity;

@Repository
public interface BookDao {
	 List<BookEntity> searchCriteria(String authorname, Integer min, Integer max);
}

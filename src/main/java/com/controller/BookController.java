package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.BookEntity;
import com.Entity.ResponseBean;
import com.dao.BookDaoImpl;
import com.repository.BookRepository;
@CrossOrigin
@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookDaoImpl bookDaoImpl;
	
	
	@PostMapping("/InsertBook")
	public ResponseEntity<ResponseBean<BookEntity>> insertBookDetails(@RequestBody BookEntity bookEntity)
	{
		Optional<BookEntity> opt = bookRepository.findByName(bookEntity.getName());
		List<BookEntity> AuthName = bookRepository.findByAuthorname(bookEntity.getAuthorname());
		
		if(opt.isEmpty() || AuthName.isEmpty() )
		{
			bookRepository.save(bookEntity);
			
			ResponseBean<BookEntity> res = new ResponseBean<>();
			
			res.setData(bookEntity);
			res.setMsg("Book Added Successfully");
			return ResponseEntity.ok(res);
		} 
		else
		{
			ResponseBean<BookEntity> res = new ResponseBean<>();
			res.setData(bookEntity);
			res.setMsg("Book Already Exist");

			return ResponseEntity.unprocessableEntity().body(res);
		}
	} 
	
	@GetMapping("/getBookById/{id}")
	public BookEntity getBookById(@PathVariable("id") Integer id)
	{
		Optional<BookEntity> opt = bookRepository.findById(id);
		
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			return opt.get();
		}
	}
	
	@GetMapping("/getAllBook")
	public ResponseEntity<ResponseBean<List<BookEntity>>> getAllBookDetails()
	{
		List<BookEntity> list = bookRepository.findAll();
		ResponseBean<List<BookEntity>> resp = new ResponseBean<>();
		
		resp.setData(list);
		resp.setMsg("All Books");
		return ResponseEntity.ok(resp);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<ResponseBean<BookEntity>> deleteBookById(@PathVariable("id") Integer id)
	{
		BookEntity book = bookRepository .findById(id).get();
		bookRepository.deleteById(id);
		
		ResponseBean<BookEntity> res = new ResponseBean<>();
		res.setData(book);
		res.setMsg("Book Delete successful");
		
		return ResponseEntity.ok(res);
		
	}
	
	@PutMapping("/updateById")
	public ResponseEntity<ResponseBean<BookEntity>> updateById(@RequestBody BookEntity bookEntity )
	{
		bookRepository.save(bookEntity);
		ResponseBean<BookEntity> resp = new ResponseBean<>();
		resp.setData(bookEntity);
		resp.setMsg("Book Details Update Successfully");
		return ResponseEntity.ok(resp);
	} 
	

	

	
	@GetMapping("/searchByRange/{min}/{max}")
	public ResponseEntity<ResponseBean<List<BookEntity>>> searchBookByRange(@PathVariable("min")float min, @PathVariable("max")float max){
	
		List<BookEntity> book = bookRepository.findByPriceBetween(min,max);
		
		ResponseBean<List<BookEntity>> resp = new ResponseBean<>();
		resp.setData(book);
		resp.setMsg("Search By Range");
		return ResponseEntity.ok(resp);
	}
	
	
	@GetMapping("/bookavailable/{avalaibleind}")
	public ResponseEntity<ResponseBean<List<BookEntity>>> bookAvalability(@PathVariable boolean avalaibleind) {
		
		List<BookEntity> bookList = bookRepository.findByAvalaibleind(avalaibleind);
		ResponseBean<List<BookEntity>> resp = new ResponseBean<>();
		resp.setData(bookList);
		resp.setMsg("Available Book List");
		return ResponseEntity.ok(resp);
		
	}
	
//	@GetMapping("/getBookByAuthorName/{authorname}")
//    public ResponseEntity<ResponseBean<List<BookEntity>>> getProductByName(@PathVariable("authorname") String authorname){
//    	List<BookEntity> bookList =  bookRepository.findByAuthorname(authorname);  
//    	   
//    	ResponseBean<List<BookEntity>> resp = new ResponseBean<>();
//    	resp.setData(bookList);
//		resp.setMsg("Available Book List");
//		return ResponseEntity.ok(resp);
//    }
	
	@GetMapping("/search/{authorname}/{min}/{max}")
	public ResponseEntity<List<BookEntity>> searchByCriteria(@PathVariable("authorname") String authorname, @PathVariable("min") Integer min, @PathVariable("max") Integer max)
	{
		List<BookEntity> book=bookDaoImpl.searchCriteria(authorname, min, max);
		return ResponseEntity.ok(book);
	}
	
}

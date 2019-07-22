package cn.whh.bookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.whh.bookstore.entites.Book;

public interface BookDAO {

	public List<Book> getAllBooks();
	
	//给id参数命名为id
	public Book getBookById(@Param("id") int id);
	
	public int add(Book entity);
	
	public int delete(int id);
	
	public int update(Book entity);
}

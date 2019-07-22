package cn.whh.bookstore.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

import cn.whh.bookstore.entites.Book;
import cn.whh.bookstore.mapper.BookDAO;

@Service
public class BookService {

	@Resource
	BookDAO bookdao;
	
	public List<Book> getAllBooks(){
		return bookdao.getAllBooks();
	}
	
	public int add(Book entity) throws Exception {
		if(entity.getTitle()==null || entity.getTitle().equals("")) {
			throw new Exception("书名不能为空");
		}
		return bookdao.add(entity);
	}
	
	@Transactional
	public int add(Book entity,Book entityBak) {
		int rows=0;
		rows=bookdao.add(entity);
		rows=bookdao.add(entityBak);
		return rows;
	}
	
	public int delete(int id) {
		return bookdao.delete(id);
	}
	
	//多删除
	public int delete(String[] ids) {
		int rows=0;
		for(String id:ids) {
			int sid=Integer.parseInt(id);
			rows+=delete(sid);
		}
		return rows;
	}
	
	public int update(Book entity) {
		return bookdao.update(entity);
	}
	
	public Book getBookById(int id) {
		return bookdao.getBookById(id);
	};
}

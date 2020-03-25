package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tedu.cloudnote.dao.BookDao;
import com.tedu.cloudnote.entity.Book;

import test.TestBase;

public class TestBookDao extends TestBase{
	private BookDao bookDao;
	
	@Before
	public void init(){
		bookDao = super.getContext().getBean(
			"bookDao",BookDao.class);
	}
	
	@Test
	public void test1(){
		List<Book> list = 
			bookDao.findByUserId(
			"48595f52-b22c-4485-9244-f4004255b972");
		for(Book book:list){
			System.out.println(
				book.getCn_notebook_id()+" "
				+book.getCn_notebook_name());
		}
	}
	
}

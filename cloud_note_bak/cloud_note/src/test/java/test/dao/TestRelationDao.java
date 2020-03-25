package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tedu.cloudnote.dao.RelationDao;
import com.tedu.cloudnote.entity.Book;
import com.tedu.cloudnote.entity.User;

import test.TestBase;

public class TestRelationDao extends TestBase{
	
	private RelationDao rdao;
	@Before
	public void init(){
		rdao = getContext().getBean(
			"relationDao",RelationDao.class);
	}
	
	@Test
	public void test2(){
		List<Book> list = rdao.findBookAndUser1();
		for(Book book:list){
			System.out.print(
				book.getCn_notebook_name()+""
				+book.getCn_notebook_createtime()+" ");
			if(book.getUser() != null){
				System.out.println(book.getUser().getCn_user_name());
			}
		}
	}
	
	@Test
	public void test1(){
		User user = rdao.findUserAndBooks1(
			"39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		System.out.println("===用户信息===");
		System.out.println("名字："+user.getCn_user_name());
		System.out.println("昵称："+user.getCn_user_nick());
		System.out.println("拥有笔记本数量:"+
		user.getBooks().size());
		System.out.println("===笔记本列表===");
		for(Book book:user.getBooks()){
			System.out.println(book.getCn_notebook_name());
		}
	}
	
}

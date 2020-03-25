package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.cloudnote.entity.User;
import com.tedu.cloudnote.service.UserService;
import com.tedu.cloudnote.util.NoteResult;

public class TestUserService {
	UserService service ;
	
	@Before
	public void init(){
		String[] conf = {
			"conf/spring-mybatis.xml",
			"conf/spring-mvc.xml",
			"conf/spring-transaction.xml"};
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(conf);
		service = ac.getBean(
			"userService",UserService.class);
	}
	
	@Test//用例-1 ,预期：用户不存在
	public void test1(){
		NoteResult<User> result = 
			service.checkLogin("zhang", "123");
		System.out.println(service.getClass().getName());
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	
	@Test//用例-2 ,预期：密码错误
	public void test2(){
		NoteResult<User> result = 
			service.checkLogin("demo", "123");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	
	@Test//用例-3 ,预期：登录成功
	public void test3(){
		NoteResult<User> result = 
			service.checkLogin("demo", "123456");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	
	@Test 
	//注册用例-1=用户名:demo,昵称DEMO,密码123abc
	//预期返回status=1,msg=用户名已被占用
	public void test4(){
		NoteResult<Object> result = 
		service.addUser("demo","DEMO","123abc");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	
	@Test 
	//注册用例-2=用户名:tedu,昵称TEDU,密码123123
	//预期返回status=0,msg=注册成功
	public void test5(){
		NoteResult<Object> result = 
		service.addUser("tedu","TEDU","123123");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	
}

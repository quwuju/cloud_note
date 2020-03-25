package test.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.cloudnote.dao.UserDao;
import com.tedu.cloudnote.entity.User;

public class TestUserDao {

	//测试dbcp
	@Test
	public void test1() throws SQLException{
		String[] conf = {
			"conf/spring-mybatis.xml",
			"conf/spring-mvc.xml"};
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(conf);
//		DataSource dbcp = ac.getBean(
//			"dbcp",DataSource.class);
//		System.out.println(dbcp.getConnection());
//		SqlSessionFactory ssf = ac.getBean(
//			"ssf",SqlSessionFactory.class);
//		System.out.println(ssf.openSession());
		UserDao dao = ac.getBean(
			"userDao",UserDao.class);
		User user = dao.findByName("demo1");
		if(user!=null){
			System.out.println("用户存在");
		}else{
			System.out.println("用户不存在");
		}
	}
	
}

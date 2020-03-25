package test.dao;

import org.junit.Before;
import org.junit.Test;

import com.tedu.cloudnote.dao.EmpDao;
import com.tedu.cloudnote.entity.Emp;

import test.TestBase;

public class TestEmpDao extends TestBase{
	
	private EmpDao empDao;
	
	@Before
	public void init(){
		empDao = getContext().getBean(
			"empDao",EmpDao.class);
	}
	
	@Test
	public void test1(){
		Emp emp = new Emp();
		emp.setName("thomas");
		emp.setAge(20);
		empDao.save(emp);
		//获取emp记录刚插入的id值
		int id = emp.getId();
		System.out.println("刚插入记录的ID="+id);
	}
	
}

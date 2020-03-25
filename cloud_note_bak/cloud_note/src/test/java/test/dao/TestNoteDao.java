package test.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.tedu.cloudnote.dao.NoteDao;
import com.tedu.cloudnote.entity.Note;

import test.TestBase;

public class TestNoteDao extends TestBase{
	private NoteDao noteDao;
	@Before
	public void init(){
		noteDao = super.getContext().getBean(
			"noteDao",NoteDao.class);
	}
	@Test
	public void test1(){
		List<Map> list = 
			noteDao.findByBookId(
		"fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		for(Map note:list){
			System.out.println(
			  note.get("cn_note_id")+" "+
			  note.get("cn_note_title"));
		}
	}
	
	@Test
	public void test2(){
		//创建查询参数
		Map<String, Object> params = 
			new HashMap<String, Object>();
		//params.put("title","%测试%");//标题参数值
		//params.put("status", "2");//状态参数值
		Date begin = Date.valueOf("2016-07-01");
		params.put("begin", begin.getTime());//开始时间参数值
		//params.put("end", value);//结束时间参数值
		//执行查询
		List<Note> list = 
			noteDao.findNotes(params);
		for(Note note:list){
			System.out.println(note.getCn_note_title());
		}
		System.out.println("结果数:"+list.size());
	}
	
	@Test
	public void test3(){
		String[] ids = {
				"93cc3694fcda4a81815b95cefe57167a",
				"7e48274f57024a58be117ec139de93ed",
				"11076e6513964274b488196dc92d3838"};
		int rows = noteDao.deleteNotes(ids);
		System.out.println("删除记录数："+rows);
	}
	
	
}

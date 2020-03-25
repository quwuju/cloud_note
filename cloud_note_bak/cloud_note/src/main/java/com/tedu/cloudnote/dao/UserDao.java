package com.tedu.cloudnote.dao;

import com.tedu.cloudnote.entity.User;
import com.tedu.cloudnote.util.NoteResult;

public interface UserDao {
	public User findByName(String name);
	public void save(User user);
	//public NoteResult<User> updateById(String finallPassword,String userId);
}

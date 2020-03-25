/*package com.tedu.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.cloudnote.entity.User;
import com.tedu.cloudnote.service.UserService;
import com.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/user")
public class ChangePasswordController {
	@Resource
	private UserService userService;
	@RequestMapping("/change.do")
	@ResponseBody
	public NoteResult<User> execute(String finallPassword,String userId){
		System.out.println(userId);
		User user = new User();
		user = userService.changePassword(String finallPassword,String userId);
	}

}
*/
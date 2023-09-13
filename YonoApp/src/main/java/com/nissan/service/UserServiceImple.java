package com.nissan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.repo.IUserRepository;
import com.nissan.util.JwtUtilAdmin;
import com.nissan.util.JwtUtilCustomer;

@Service
public class UserServiceImple implements IUserService {

	@Autowired
	private JwtUtilAdmin jwtUtil1;
	
	@Autowired
	private JwtUtilCustomer jwtUtil2;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private APIResponse apiResponse;

	@Override
	public APIResponse findUserByNameAndPassword(String userName, String password) {
		String token;
// verify user exist or not
		User user = userRepository.findUserByUserNameAndPassword(userName, password);
		if (user == null) {
			apiResponse.setData("Invalid Credentials!!");
			return apiResponse;
		}

// credentials are correct, thenL
if(user.getRoleId()==1) {
		 token = jwtUtil1.generateJwt(user);
}
else {
	 token = jwtUtil2.generateJwt(user);
}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("ACCESSTOKEN", token);
		data.put("role", user.getRoleId());
		data.put("UserName", user.getUserName());

		apiResponse.setStatus(200);
		apiResponse.setData(data);

		return apiResponse;
	}

}

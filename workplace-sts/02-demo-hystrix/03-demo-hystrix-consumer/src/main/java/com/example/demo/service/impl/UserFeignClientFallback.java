
package com.example.demo.service.impl;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserFileDto;
import com.example.demo.service.UserFeignClient;

@Component
public class UserFeignClientFallback implements UserFeignClient {

	@Override
	public String login() {
		return "fegin:异常";
	}

	@Override
	public String upload1(MultipartFile file) {
		return "upload1:异常";
	}

	@Override
	public String upload2(String message, MultipartFile file) {
		return "upload2:异常";
	}

	@Override
	public String upload3(String id, Map<Object, Object> map, String userName) {
		return "upload3:异常";
	}

	@Override
	public String upload4(UserDto userDto) {
		return "upload4:异常";
	}

	@Override
	public String upload5(UserFileDto userFileDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload6(UserDto userDto, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

}


package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserFileDto;
import com.example.demo.service.UserFeignClient;

@RestController
public class UserController {

	@Autowired
	private UserFeignClient userFeignClient;

	@RequestMapping("userlogin")
	public String login() {
		return "userlogin:" + userFeignClient.login();
	}

	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String upload1(@RequestPart(value = "file") MultipartFile file) {
		return "upload1:" + userFeignClient.upload1(file);
	}

	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public String upload2(@RequestParam(value = "message") String message,
			@RequestPart(value = "file") MultipartFile file) {
		return "upload2:" + userFeignClient.upload2(message, file);
	}

	@RequestMapping(value = "/upload3", method = RequestMethod.POST)
	public String upload3() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("one", 1);
		map.put("two", 2);
		String userName = "popa";
		String id = "42";
		userFeignClient.upload3(id, map, userName);
		return "upload3";
	}

	@RequestMapping(value = "/upload4", method = RequestMethod.POST)
	public String upload4(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age) {

		UserDto userDto = new UserDto(name, age);
		return "upload4:" + userFeignClient.upload4(userDto);
	}

	@RequestMapping(value = "/upload5", method = RequestMethod.POST)
	public String upload5(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, @RequestPart(value = "file") MultipartFile file) {

		UserFileDto userFileDto = new UserFileDto(name, age, file);
		return "upload5:" + userFeignClient.upload5(userFileDto);
	}

	@RequestMapping(value = "/upload6", method = RequestMethod.POST)
	public String upload6(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, @RequestPart(value = "file") MultipartFile file) {

		UserDto userDto = new UserDto(name, age);
		return "upload6:" + userFeignClient.upload6(userDto, file);
	}
}

package com.example.demo.controller;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserFileDto;

@RestController
public class UserConterller {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		return "用户已验证";
	}

	@RequestMapping(value = "/feignUpload1", method = RequestMethod.POST)
	public String upload1(@RequestPart(value = "file") MultipartFile file) {
		System.out.println("upload1");
		return file.getOriginalFilename();
	}

	@RequestMapping(value = "/feignUpload2", method = RequestMethod.POST)
	public String upload2(@RequestParam(value = "message") String message,
			@RequestPart(value = "file") MultipartFile file) {
		System.out.println("upload2");
		return message + ":" + file.getOriginalFilename();
	}

	@RequestMapping(path = "/feignUpload3", method = RequestMethod.POST)
	public String upload3(@RequestParam("id") String id, @RequestBody Map<String, Object> map,
			@RequestParam String userName) {
		System.out.println(map.toString());
		return userName + ':' + id + ':' + map.size();
	}

	/** 要加 @RequestBody 不然拿不到值 */
	@RequestMapping(value = "/feignUpload4", method = RequestMethod.POST)
	String upload4(@RequestBody UserDto userDto) throws IOException {
		System.out.println(userDto.toString());
		return userDto.getName();
	}

	/** 失败 */
	@RequestMapping(path = "/feignUpload5", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
	public String upload5(@RequestBody UserFileDto userFileDto) {
		System.out.println(userFileDto.toString());
		return userFileDto.getName() + ':' + userFileDto.getAge();
	}

	@RequestMapping(path = "/feignUpload6", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
	public String upload6(@RequestParam("userDto") UserDto userDto, @RequestPart(value = "file") MultipartFile file) {
		System.out.println(userDto.toString());
		return userDto.getName() + ':' + userDto.getAge();
	}
}

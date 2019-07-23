
package com.example.demo.service;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserFileDto;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

//@FeignClient(name = "demo-eureka-provider", configuration = UserFeignClient.ClientConfiguration.class, fallback = UserFeignClientFallback.class)
@FeignClient(name = "demo-eureka-provider", configuration = UserFeignClient.ClientConfiguration.class)
public interface UserFeignClient {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login();

	@RequestMapping(value = "/feignUpload1", method = POST, consumes = MULTIPART_FORM_DATA_VALUE)
	public String upload1(@RequestPart(value = "file") MultipartFile file);

	@RequestMapping(value = "/feignUpload2", method = POST, consumes = MULTIPART_FORM_DATA_VALUE)
	public String upload2(@RequestParam(value = "message") String message,
			@RequestPart(value = "file") MultipartFile file);

	@RequestMapping(path = "/feignUpload3", method = POST, produces = APPLICATION_JSON_VALUE)
	String upload3(@RequestParam("id") String id, @RequestBody Map<Object, Object> map,
			@RequestParam("userName") String userName);

	@RequestMapping(value = "/feignUpload4", method = RequestMethod.POST)
	String upload4(@RequestBody UserDto userDto);

	@RequestMapping(value = "/feignUpload5", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
	String upload5(@RequestBody UserFileDto userFileDto);

	@RequestMapping(path = "/feignUpload6", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
	public String upload6(@RequestParam("userDto") UserDto userDto, @RequestPart(value = "file") MultipartFile file);

	/** Spring MultipartFile and Spring Cloud Netflix @FeignClient support */
	class ClientConfiguration {

		@Autowired
		private ObjectFactory<HttpMessageConverters> messageConverters;

		@Bean
		public Encoder feignEncoder() {
			return new SpringFormEncoder(new SpringEncoder(messageConverters));
		}
	}

	/** if you don't need Spring's standard encoder */
	public class MultipartSupportConfig {

		@Bean
		public Encoder feignFormEncoder() {
			return new SpringFormEncoder();
		}
	}

}

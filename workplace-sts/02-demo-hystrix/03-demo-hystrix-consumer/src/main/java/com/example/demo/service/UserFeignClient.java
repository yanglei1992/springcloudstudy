
package com.example.demo.service;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.impl.UserFeignClientFallback;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@FeignClient(name = "demo-eureka-provider", configuration = UserFeignClient.ClientConfiguration.class, fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login();

	@RequestMapping(value = "/upload1", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
	public String upload1(@RequestPart(value = "file") MultipartFile file);

	@RequestMapping(value = "/upload2", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
	public String upload2(@RequestParam(value = "message") String message,
			@RequestPart(value = "file") MultipartFile file);


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

package com.demo0.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2Controller {

	@GetMapping("/test2")
	public Result getResult() {
		Result result = new Result();
		result.setCode(1);
		result.setData("data");
		result.setMessage("message");
		return result;
	}
	
	
	public static class Result{
		
		private int code;
		private String message;
		private String data;
		public int getCode() {
			return code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public void setCode(int code) {
			this.code = code;
		}
	}
}

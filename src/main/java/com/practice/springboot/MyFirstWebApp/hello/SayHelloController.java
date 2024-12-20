package com.practice.springboot.MyFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	// http://localhost:8081/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hey Hi, How are you doing?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb =  new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML page </title>");
		sb.append("</head");
		sb.append("<body>");
		sb.append("My FIrst html page");
		sb.append("</body>");
		sb.append("</html>");
//		sb.append("<html>");

		return sb.toString();
	}
	//say-hello-jsp=> sayHello.jsp
	
	// @ResponseBody - if this annotation is removed it will redirect to the jsp page provided
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}

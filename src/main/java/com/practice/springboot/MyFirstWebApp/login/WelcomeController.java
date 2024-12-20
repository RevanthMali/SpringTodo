package com.practice.springboot.MyFirstWebApp.login;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")  // Add this line
public class WelcomeController {
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
    	model.put("name", getLoggedinUsername());
        return "welcome";
    }
    private String getLoggedinUsername() {
    org.springframework.security.core.Authentication authentication = 
    				SecurityContextHolder.getContext().getAuthentication();
    	return authentication.getName();
    }

}

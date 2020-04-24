package com.webservice.webserviceDemo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "com.webservice.webserviceDemo.service.Iwebservice",
name = "Login",
serviceName = "Iwebservice", 
targetNamespace = "http://com.webservice.webserviceDemo.service" 

)
public class WebServiceImpl implements Iwebservice {
	@WebMethod
	public String sayHello(@WebParam(name="user")  User  name) {
		
		System.out.println(name);
		return "succesdafsdfasdfas"+name;
	}
	@WebMethod
	@Override
	public String say(@WebParam(name="user")  User  name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		return "succesdafsdfasdfas"+name;
	}

}

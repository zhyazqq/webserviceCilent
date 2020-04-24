package com.webservice.webserviceDemo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRefs;

@WebService(name = "Login",
serviceName = "Iwebservice", 
targetNamespace = "http://com.webservice.webserviceDemo.service" 
)
public interface Iwebservice {
	@WebMethod(operationName = "authorization")
	String sayHello(@WebParam(name="user") User  name);
}

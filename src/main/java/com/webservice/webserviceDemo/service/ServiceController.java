package com.webservice.webserviceDemo.service;

import javax.xml.ws.Endpoint;

public class ServiceController {
	public static void main(String[] args) {
		String urlString = "http://localhost:9999/demo";
		Endpoint.publish(urlString, new WebServiceImpl());
		System.out.println("success");
	}
}

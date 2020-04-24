package com.demo.webserviceDemo.webserviceCilent;

import com.eviware.soapui.impl.wsdl.WsdlOperation;

public class OperationInfo 
{
    private String operationName;

    private String requestXml;

    private String responseXml;

    public OperationInfo(WsdlOperation operation)
    {
        operationName = operation.getName();
        requestXml = operation.createRequest( true );
        responseXml = operation.createResponse(true);    
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getRequestXml() {
        return requestXml;
    }

    public void setRequestXml(String requestXml) {
        this.requestXml = requestXml;
    }

    public String getResponseXml() {
        return responseXml;
    }

    public void setResponseXml(String responseXml) {
        this.responseXml = responseXml;
    }
}
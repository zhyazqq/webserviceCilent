package com.demo.webserviceDemo.webserviceCilent;
public class WSDLParseTest 
{
    public static void main(String[] args) throws Exception
    {
        String url = "http://localhost:9999/demo?wsdl";
        WsdlInfo wsdlInfo = new WsdlInfo(url);
        System.out.println("WSDL URL is " + wsdlInfo.getWsdlName());

        for(InterfaceInfo interfaceInfo : wsdlInfo.getInterfaces())
        {
            System.out.println("Interface name is " + interfaceInfo.getInterfaceName());
            for(String ads : interfaceInfo.getAdrress())
            {
                System.out.println("Interface address is " + ads);
            }
            for(OperationInfo operation : interfaceInfo.getOperations())
            {
                System.out.println("operation name is " + operation.getOperationName());
                System.out.println("operation request is ");
                System.out.println("operation request is " + operation.getRequestXml());
                System.out.println("operation response is ");
                System.out.println(operation.getResponseXml());
            }
        }
    }
}
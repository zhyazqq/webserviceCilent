package com.demo.webserviceDemo.webserviceCilent;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;

import java.util.ArrayList;
import java.util.List;


public class InterfaceInfo 
{
    private String interfaceName;

    private List<OperationInfo> operations;

    private String[] adrress;

    public InterfaceInfo(WsdlInterface wsdlInterface)
    {
    	wsdlInterface.getName();
        this.interfaceName = wsdlInterface.getName();

        this.adrress = wsdlInterface.getEndpoints();

        int operationNum = wsdlInterface.getOperationCount();
        List<OperationInfo> operations = new ArrayList<OperationInfo>();

        for(int i = 0; i < operationNum; i++)
        {
            WsdlOperation operation = ( WsdlOperation )wsdlInterface.getOperationAt( i );
            OperationInfo operationInfo = new OperationInfo(operation);
            operations.add(operationInfo);
        }

        this.operations = operations;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<OperationInfo> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationInfo> operations) {
        this.operations = operations;
    }

    public String[] getAdrress() {
        return adrress;
    }

    public void setAdrress(String[] adrress) {
        this.adrress = adrress;
    }
}
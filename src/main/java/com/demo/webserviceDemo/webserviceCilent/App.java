package com.demo.webserviceDemo.webserviceCilent;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.XMLConstants;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.XML;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        String url ="http://localhost:9999/demo?wsdl";
        StringBuilder soapBuilder = new StringBuilder(64);
        soapBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        soapBuilder.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://com.webservice.webserviceDemo.service\">");
        soapBuilder.append("   <soapenv:Header/>");
        soapBuilder.append("       <soapenv:Body>");
        soapBuilder.append("             <web:authorization>");
        soapBuilder.append("                     <user>");
        soapBuilder.append("                     <userId>").append("admin").append("</userId>");
        soapBuilder.append("                     <password>").append("123456").append("</password>");
        soapBuilder.append("                     </user>");

        soapBuilder.append("               </web:authorization>");
        soapBuilder.append("    </soapenv:Body>");
        soapBuilder.append("</soapenv:Envelope>");
        //创建httpcleint对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建http Post请求
        HttpPost httpPost = new HttpPost(url);
        // 构建请求配置信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) // 创建连接的最长时间
                .setConnectionRequestTimeout(500) // 从连接池中获取到连接的最长时间
                .setSocketTimeout(3 * 1000) // 数据传输的最长时间10s
                .build();
        httpPost.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            //采用SOAP1.1调用服务端，这种方式能调用服务端为soap1.1和soap1.2的服务
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");

            //采用SOAP1.2调用服务端，这种方式只能调用服务端为soap1.2的服务
            // httpPost.setHeader("Content-Type", "application/soap+xml;charset=UTF-8");
            StringEntity stringEntity = new StringEntity(soapBuilder.toString(), Charset.forName("UTF-8"));
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                
                JSONObject JS = XML.toJSONObject(content);
                System.out.println(JS);
                System.out.println(content);

            } else {
                System.out.println("调用失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != response) {
                try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if (null != httpClient) {
                try {
					httpClient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }


    }

}

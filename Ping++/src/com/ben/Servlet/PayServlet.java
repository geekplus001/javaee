package com.ben.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;

/**
 * Servlet implementation class PayServlet
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Pingpp.apiKey = "sk_test_8yvPG8nXjfnP90KivHz1eH88";
		
		//获取客户端参数count channel
		ServletInputStream in = request.getInputStream();
		byte[] bytes = new byte[512];
		int len = -1;
		StringBuffer sb = new StringBuffer();
		while((len=in.read(bytes))!=-1)
		{
			sb.append(new String(bytes,0,len));
		}
		
		Gson gson = new Gson();
		PaymentRequest pay = gson.fromJson(sb.toString(), PaymentRequest.class);
		
		Map<String, Object> chargeMap = new HashMap<String, Object>();
	    //某些渠道需要添加extra参数，具体参数详见接口文档
	    chargeMap.put("amount", pay.amount);
	    chargeMap.put("currency", "cny");
	    chargeMap.put("subject", "这是商品名称");
	    chargeMap.put("body", "商品描述");
	    chargeMap.put("order_no", "11112222");
	    chargeMap.put("channel", pay.channel);
	    chargeMap.put("client_ip", request.getRemoteAddr());//
	    Map<String, String> app = new HashMap<String, String>();
	    app.put("id", "app_KKSqX55SiDCSL8S8");
	    chargeMap.put("app", app);
	    try {
	        //发起交易请求
	        Charge charge = Charge.create(chargeMap);
	        System.out.println(charge);
	        out.write(charge.toString());
	    } catch (PingppException e) {
	        e.printStackTrace();
	    }
	}

}

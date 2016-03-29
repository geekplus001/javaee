package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * �Զ��������
 * 
 */
public class MyFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("filter destroy...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("do filter...");
		
		//ִ�й������е���һ�������������û����һ������������ô��ִ��Ŀ�����
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter init...");
	}

}

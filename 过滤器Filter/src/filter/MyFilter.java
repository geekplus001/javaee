package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 自定义过滤器
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
		
		//执行过滤链中的下一个过滤器，如果没有下一个过滤器，那么将执行目标对象
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter init...");
	}

}

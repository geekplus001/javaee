package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharsetEncodingFilter
 */
public class CharsetEncodingFilter implements Filter {

	private static String CODE = "UTF-8";
    public CharsetEncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(CODE);
		response.setCharacterEncoding(CODE);
		
		System.out.println("CharsetEncodingFilter do filter...");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("CharsetEncodingFilter init...");
		String code = fConfig.getInitParameter("code");
		CODE = code;
	}

}

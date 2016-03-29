package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */


//Servlet���̲߳���ȫ�ģ�����̰߳�ȫ�����ⷽ���ǣ�
//1��Servletʵ��SingleThreadModel�ӿڣ��ѹ�ʱ�����Ƽ�ʹ�ã���Ϊ�����Ĵ����ģ�
//2��ʹ��ͬ�������


@SuppressWarnings("deprecation")
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet  implements SingleThreadModel{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private int count = 10;//��Servlet�ж����Ա��������Ҫ�����̰߳�ȫ
	
	public MyServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		synchronized (this) {
			count++;
		}
	}

}

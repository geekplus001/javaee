package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listener.MyAsyncListener;

@WebServlet(urlPatterns = {"/AsyncServlet"},asyncSupported=true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AsyncServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("tex/html;charset=utf-8");		
		PrintWriter out = response.getWriter();
		out.write("start...");
		
		//比较耗时的业务
		AsyncContext ac = request.startAsync();
		ac.addListener(new MyAsyncListener());
		ac.setTimeout(3000*5);
		ac.start(new MyThread(ac));
		
		out.write("end...");
		
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//模拟耗时业务
	class MyThread implements Runnable
	{
		private AsyncContext ac;
		public MyThread(AsyncContext ac) {
			this.ac = ac;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				PrintWriter out = ac.getResponse().getWriter();
				out.write("耗时操作完成。");
				ac.complete();//完成
//				ac.dispatch(path);
//				ac.getRequest().getRequestDispatcher(path);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
		System.out.println("onComplete...");
	}

	@Override
	public void onError(AsyncEvent arg0) throws IOException {
		
	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		
	}

  
	
}

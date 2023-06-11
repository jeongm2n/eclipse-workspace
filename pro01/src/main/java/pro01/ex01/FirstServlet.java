package pro01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		System.out.println("doPost");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		System.out.println("init");
	}

	
}

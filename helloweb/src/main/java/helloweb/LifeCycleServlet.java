package helloweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycleServlet.doGet(...) called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet.service(...) called");
		super.service(req, resp);
	}

	@Override
	public void destroy() { //톰캣 안에서 내려갈때 불림
		System.out.println("LifeCycleServlet.destroy() called");
		super.destroy();
	}

	@Override
	public void init() throws ServletException { //최초 요청때 servlet을 new하고 부름
		System.out.println("LifeCycleServlet.init() called");
		super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycleServlet.doPost(...) called");
		doGet(request, response);
	}

}

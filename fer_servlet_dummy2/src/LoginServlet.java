

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.servce.Impl.FERServiceImpl;
import com.rs.fer.service.FERService;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
		super.init(config);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.to get input
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 2.to call the service for business execution

		int userid = ferService.login(username, password);
		// 3.to print the status

		PrintWriter out = resp.getWriter();

		if (userid > 0) {

			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userId", userid);
			
			LayoutUtil.displayHEaderAndLeftFrame(req, resp, out, username);
			out.println("wellcome to the user:..."+username);
			LayoutUtil.displayFooter(req, resp);
			
			
		} else {
			out.println("incorrect username/password please try again later.. ");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}

	}

	@Override
	public void destroy() {
		ferService = null;
		super.destroy();
	}
}

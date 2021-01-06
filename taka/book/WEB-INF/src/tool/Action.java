package tool;

import javax.servlet.http.*;

public abstract class Action  extends HttpServlet{
	public abstract String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception;
}

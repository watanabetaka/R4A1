package eiga;

import tool.Page;
import java.util.List;
import bean.Cinama;
import dao.CinamaDAO;
import java.io.PrintWriter;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.io.IOException;

public class Cinamadata extends HttpServlet{
public String hoge;

	public List<Cinama>  data() throws Exception {
	CinamaDAO dao = new CinamaDAO();
	List<Cinama> list = dao.hyouzi();
	return list;
	}
}


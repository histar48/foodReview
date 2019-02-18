package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ResListDao;

@WebServlet(urlPatterns = "*.res")
public class ResListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();

		String page = req.getRequestURI();
		page = page.substring(page.lastIndexOf("/") + 1, page.lastIndexOf("."));
		
		String url = "restaurant/";
		
		// / 다음부터니 뒤에 오는 단어로만 case 조회
		// 예 ) foodReView/insert.res > insert 로 나옴 
		// 필요한거 실행하고 마지막은 out.print로 json 타입 출력해서 페이지에서 받을수있게
		switch(page) {
			case "view":
				/*int serial = Integer.parseInt(req.getParameter("resNum"));
				ResListDao dao = new ResListDao();
				String str = dao.view(serial);
				out.print(str);*/
				break;
			case "list":
				String search = req.getParameter("search");
				int nowPage = Integer.parseInt(req.getParameter("nowPage"));
				ResListDao dao = new ResListDao();
				String str = dao.list(search, nowPage);
				out.print(str);
				break;
		}
		
	}
	
	public void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
}

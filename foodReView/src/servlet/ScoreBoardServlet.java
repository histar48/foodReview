package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ScoreBoardDao;

@WebServlet (urlPatterns="*.rev")
public class ScoreBoardServlet extends HttpServlet {

	
	MultipartRequest multi;
	
	
	String folder = "M:/JHTA/1806/foodReView/WebContent/img/reviewImg/";
	int size  = 1024 * 1024 * 100;
	String encode = "utf-8";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
	
		
		String msg="";
		PrintWriter out = resp.getWriter();
		
		String page = req.getRequestURI();
		page = page.substring(page.lastIndexOf("/")+1, page.lastIndexOf("."));
		
		
		boolean b = false;
		
		
		switch(page) {

		case "insertR" : 
				
			ScoreBoardDao dao = new ScoreBoardDao();
			
			
			
			//multi = new MultipartRequest(req, folder, size, encode, new DefaultFileRenamePolicy());
			
			
			
			b = dao.insert(req);

			
			//System.out.println(multi.getParameter("revId"));
			
			if(b) {
				msg = "리뷰 등록 완료";
			}else {
				msg = "리뷰 등록 실패";
			}
			
			
			out.print(msg);
			break;		
		
		}
	
	
	}

	
	
	
	
}

package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ScoreBoardDao {

	MultipartRequest multi;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	
	
	
	String folder = "M:/JHTA/1806/foodReView/WebContent/img/reviewImg/";
	int size  = 1024 * 1024 * 100;
	String encode = "utf-8";
	
	
	
	public ScoreBoardDao() {
		try {
		conn = new DBConnect().getConn();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	public boolean insert(HttpServletRequest req) {
		boolean b = false;
			try {
			ScoreBoardVo vo = getScoreBoardVo(req);
			
			
			String sql = "insert into scoreboard values( "
					+ " SEQ_SCOREBOARD.nextval, "
					+ " ?, "
					+ " sysdate, "
					+ " ?, "
					+ " ?, "
					+ " ?, "
					+ " ?, "
					+ " ? "
					+ " )";
				
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getContent());
			ps.setString(2, vo.getId());
			ps.setInt(3, vo.getScore());
			ps.setInt(4, vo.getpSerial());
			ps.setString(5, vo.getAttFile());
			ps.setString(6, vo.getOrFile());
				
			int cnt = ps.executeUpdate();
			
			if(cnt > 0) {
				b = true;
			}
			}catch (Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					ps.close();
					conn.close();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				return b;
			}


	}
	
	public ScoreBoardVo getScoreBoardVo(HttpServletRequest req) throws Exception{
		ScoreBoardVo v = new ScoreBoardVo();
		
		System.out.println(1234);
		//
		
		multi = new MultipartRequest(req, folder, size, encode, new DefaultFileRenamePolicy());
		
		
		System.out.println("---------------");
		
		System.out.println(multi.getParameter("revId"));
		System.out.println();
		//첨부파일
		Enumeration<String> e = multi.getFileNames();
		while(e.hasMoreElements()) {
			String tagName = (String)e.nextElement();
			String att = multi.getFilesystemName(tagName);
			String ori = multi.getOriginalFileName(tagName);
			if(att == null || att.equals("")) continue;
			
			v.setAttFile(att);
			v.setOrFile(ori);
			
		}
		
		
		v.setId(multi.getParameter("revId"));
		v.setContent(multi.getParameter("revContent"));
		v.setpSerial(Integer.parseInt(multi.getParameter("revpSerial")));
		v.setScore(Integer.parseInt(multi.getParameter("revScore")));
		
		
		
		
		
		return v;
		
		
	}
	
	
}

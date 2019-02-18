package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ResListDao {
	MultipartRequest multi;
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int listSize;
	public int blockSize;

	public int startList;
	public int endList;
	public int startNo;
	public int endNo;
	
	public int totSize;
	public int totPage;
	public int totBlock;
	public int nowPage;
	public int nowBlock;
	
	String folder = "C:/Users/JHTA/eclipse-workspace/foodReView/WebContent/img/restaurant_img/";
	int size = 1024*1024*10; //10Mb
	String encode = "utf-8";
	
	public String msg = "";
	public String search = "";
	
	// 생성자 호출하면 connection 생성
	public ResListDao() {
		conn = new DBConnect().getConn();
	}
	
	// 입력 메소드 - 페이지 입력된값 DB로
	public String insert(HttpServletRequest req) {
		// vo 만들어서 setVo(req) 실행
		
		// sql문 생성
		
		// conn, sql로 ps 생성 (conn.autocommit(false))
		
		// ps에 vo값 입력
		
		// ps 실행
		
		// ps 실행결과 정상이면 attFile(vo) 실행
		
		// attFile(vo) 반환값 true면 commit()
		
		// 각 구간에 실패나 성공시 msg값 변환해서 마지막에 리턴
		return msg;
	}
	
	// 조회 메소드 이거 req대신 serial만 받아서 serial로 조회 바로 해도 됨
	public ResListVo view(int serial) {
		ResListVo vo = null;
		try {
			String sql = "select sl.*, (select avg(sb.score) from scoreboard sb where sl.serial = sb.pserial) score from storelist sl where sl.serial = " + serial;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = getVo(rs, 2);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		return vo;  
	}
	
	// 수정 메소드 - 페이지 입력된값 DB로
	public String modify(HttpServletRequest req) {
		
		return msg;
	}
	
	// 삭제 메소드 -
	// 삭제 확인용 비번 받아서 등록한 사람의 pwd와 일치하는지 여부 확인하고 맞으면 삭제해서 메시지 보내주기
	// 관리자페이지에서만 삭제하게 만들면 관리자 비밀번호랑 비교해서 실행
	public String delete(HttpServletRequest req) {
		
		return msg;
	}
	
	public String list(String findStr, int nowPage) {
		this.nowPage = nowPage;
		pageCompute(findStr);
		StringBuilder sb = new StringBuilder();
		List<ResListVo> data = new ArrayList<ResListVo>();
		
		String sql = "select * from ( "
				+ "	select rownum rno, s.* from ( "
				+ "		select sl.*, (select avg(sb.score) from scoreboard sb where sl.serial = sb.pserial) score from storelist sl where sl.name like ? "
				+ "		order by score desc ) s "
				+ ") where rno between ? and ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + findStr + "%");
			ps.setInt(2, startNo);
			ps.setInt(3, endNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ResListVo vo = getVo(rs, 1);
				data.add(vo);
			}
			
			if(data.size() > 0) {
				sb.append("[");
				String paging = String.format("{'startList':'%d','endList':'%d','nowPage':'%d','totPage':'%d','nowBlock':'%d','totBlock':'%d'}",
						this.startList, this.endList, this.nowPage, this.totPage, this.nowBlock, this.totBlock);
				sb.append(paging.replaceAll("'", "\""));
				for(int i = 0; i< data.size(); i++) {
					sb.append(",");
					sb.append(data.get(i).toListJson());
				}
				sb.append("]");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		return sb.toString();
	}
	
	public boolean attFile(ResListVo vo) throws Exception{
		boolean chk = true;
		for(int i = 0; i < vo.getResAttFiles().size(); i++) {
			String sql = "insert into storeAtt(serial, pSerial, attFile, oriFile) values(seq_storeAtt.nextval,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getResSerial());
			ps.setString(2, vo.getResAttFiles().get(i));
			ps.setString(3, vo.getResAttFiles().get(i));
			int cnt = ps.executeUpdate();
			// 한번이라도 저장 실패하면 바로 실패 반환
			if(cnt < 1) {
				chk = false;
				break;
			}
		}
		return chk;
	}
	
	// request에 있는 data를 StoreListVo에 저장하는 메소드
	public ResListVo setVo(HttpServletRequest req) throws Exception{
		ResListVo vo = new ResListVo();
		multi = new MultipartRequest(req, folder, size, encode, new DefaultFileRenamePolicy());
		setFiles(vo, multi);
		if(multi.getParameterValues("delFiles") != null) {
			setDelFiles(vo, multi);
		}
		
		// 다른거 vo에 추가
		if(multi.getParameter("resSerial") != null) {
			vo.setResSerial(Integer.parseInt(multi.getParameter("resSerial")));
		}
		vo.setResName(multi.getParameter("resName"));
		vo.setResPhone(multi.getParameter("resPhone"));
		vo.setResSite(multi.getParameter("resSite"));
		vo.setResPostal(multi.getParameter("resPostal"));
		vo.setResAddress(multi.getParameter("resAddress"));
		vo.setResRdate(multi.getParameter("resRdate"));
		vo.setResCategory(multi.getParameter("resCategory"));
		vo.setResOpentime(multi.getParameter("resOpentime"));
		vo.setResClosetime(multi.getParameter("resClosetime"));
		vo.setResHoliday(multi.getParameter("resHoliday"));
		vo.setResState(1);
		vo.setResHit(0);
		vo.setResLocation(multi.getParameter("resLocation"));
		
		// DB저장파일명 리스트
		setFiles(vo, multi);
		// 삭제된파일명 리스트 있으면 파일목록 vo에 저장
		if(multi.getParameterValues("delFiles") != null) {
			setDelFiles(vo, multi);
		}
		return vo;
	}
	
	// db정보 vo에 저장 num은 list 조회일때 1, view 조회일때 2
	public ResListVo getVo(ResultSet rs, int num) throws Exception{
		ResListVo vo = new ResListVo();
		vo.setResSerial(rs.getInt("serial"));
		vo.setResName(rs.getString("name"));
		vo.setResScore(String.format("%.1f", rs.getDouble("score")));
		switch(num) {
			case 1:
				vo.setResLocation(rs.getString("location"));
				vo.setResHit(rs.getInt("hit"));
				break;
			case 2:
				vo.setResPhone(rs.getString("phone"));
				vo.setResSite(rs.getString("site"));
				vo.setResAddress(rs.getString("address"));
				vo.setResCategory(rs.getString("category"));
				vo.setResOpentime(rs.getString("opentime"));
				vo.setResClosetime(rs.getString("closetime"));
				vo.setResHoliday(rs.getString("holiday"));
				vo.setResContent(rs.getString("content"));
				getAttFiles(vo);
				break;
		}
		return vo;
	}
	
	// vo에 첨부파일 목록 저장하는 메소드 - db에서 읽어오는거
	public void getAttFiles(ResListVo vo) throws Exception{
		List<String> attFiles = new ArrayList<String>();
		try {
			String sql = "select * from storeatt where pserial = " + vo.getResSerial();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				attFiles.add(rs.getString("attfile"));
			}
			vo.setResAttFiles(attFiles);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// multipartRequest에 첨부된 파일 목록 vo에 저장하는 메소드 // 페이지에서 날아온 첨부파일 목록 저장
	public void setFiles(ResListVo vo, MultipartRequest multi) throws Exception{
		List<String> attFiles = new ArrayList<String>();
		List<String> oriFiles = new ArrayList<String>();

		Enumeration<String> e = multi.getFileNames();
		while(e.hasMoreElements()) {
			String tagName = (String)e.nextElement();
			String att = multi.getFilesystemName(tagName);
			String ori = multi.getOriginalFileName(tagName);
			if(att == null || att.equals("")) continue;
			attFiles.add(att);
			oriFiles.add(ori);
		}
		
		vo.setResAttFiles(attFiles);
		vo.setResOriFiles(oriFiles);
	}
	
	// multipartRequest에 첨부된 파일 목록 vo에 저장하는 메소드 // 페이지에서 날아온 삭제파일 목록 저장
	public void setDelFiles(ResListVo vo, MultipartRequest multi) throws Exception{
		List<String> delFiles = new ArrayList<String>();
		
		String[] temp = multi.getParameterValues("delFiles");
		for(String s:temp) {
			delFiles.add(s);
		}
		vo.setResDelFiles(delFiles);
	}
	
	// 조회수 증가 메소드
	public void addHit(int serial) {
		try {
			String sql = "update storelist set hit = hit + 1 where serial = " + serial;
			ps = conn.prepareStatement(sql);
			int cnt = ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 페이지 변수 계산
	public void pageCompute(String search) {
		try {
			String sql = "select count(*) cnt from storelist where name like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + search + "%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				totSize = rs.getInt("CNT");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(rs != null && !rs.isClosed()) rs.close();
				if(ps != null && !ps.isClosed()) ps.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		listSize = 10;
		blockSize = 5;
		nowBlock = ((nowPage - 1) / blockSize) + 1;
		totPage = ((totSize - 1) / listSize) + 1;
		if(nowPage > totPage) nowPage = totPage;
		totBlock = ((totPage - 1) / blockSize) + 1;
		startList = ((nowBlock - 1) * blockSize) + 1;
		endList = nowBlock * blockSize;
		if(endList > totPage) endList = totPage;
		startNo = ((nowPage - 1) * listSize) + 1;
		endNo = (nowPage * listSize) > totSize ? totSize : (nowPage * listSize);
	}
	
	void close() {
		try {
			conn.rollback();
			if(rs != null && !rs.isClosed()) rs.close();
			if(ps != null && !ps.isClosed()) ps.close();
			if(conn != null && !conn.isClosed()) conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

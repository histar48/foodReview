
package bean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StoreDao {
	Connection conn;
	PreparedStatement ps = null;
	ResultSet rs;
	String sql;
	
	public StoreDao() {
		conn = new DBConnect().getConn();
		ps = null;
		rs = null;
	}
	
	public StoreVo login(StoreVo vo) {
		StoreVo v = null;
		ps = null;
		rs = null;
		
		sql = " select * from member where id=? and pwd=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new StoreVo();
				vo.setIrum(rs.getString("name"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			return v;
		}
	}
	
	public boolean insert(StoreVo vo) {
		boolean b = false;
		int cnt = 0;
		
		sql = " insert into memberlist(id, pwd, name, email, phone, postal, address, pwd_chk) "
			+ " values(?,?,?,?,?,?,?,?) ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getIrum());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getPhone());
			ps.setString(6, vo.getPostal());
			ps.setString(7, vo.getAddress());
			ps.setString(8, vo.getPwd_chk());
			
			cnt = ps.executeUpdate();
			
			if(cnt>0) {
				b = true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			return b;
		}
	}
	
	public boolean modify(StoreVo vo) {
		boolean b = false;
		int cnt = 0;
		sql = null;
		
		try {
			if(vo.getId() != null) {
				sql = " update memberlist set "
					+ " email=? "
					+ " phone=? "
					+ " postal=? "
					+ " address=? "
					+ " where id=? and pwd=? ";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getEmail());
				ps.setString(2, vo.getPhone());
				ps.setString(3, vo.getPostal());
				ps.setString(4, vo.getAddress());
				ps.setString(5, vo.getId());
				ps.setString(6, vo.getPwd());
				
				cnt = ps.executeUpdate();
				
				if(cnt>0) {
					b = true;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			return b;
		}
	}
	
	public boolean delete(StoreVo vo) {
		boolean b = false;
		int cnt = 0;
		
		sql = " delete from memberlist where id=? and pwd=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			
			cnt = ps.executeUpdate();
			
			if(cnt>0) {
				b = true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			return b;
		}
	}
	
	public StoreVo view(String id) {
		StoreVo vo = null;
		
		sql = " select * from memberlist where id=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new StoreVo();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIrum(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setPostal(rs.getString("postal"));
				vo.setAddress(rs.getString("address"));
				vo.setPwd_chk(rs.getString("pwd_chk"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}


	public String findId(String findType, String id, String name, String email) {
		ps = null;
		rs = null;
		sql = null;
		String msg = "가입정보가 없습니다.";		  
	   
		try {
			if(findType.equals("find_id")) {
				sql = " select * from memberlist where name = ? and email = ? " ;

				ps = conn.prepareStatement(sql);
				ps.setString(1, name); 
				ps.setString(2, email); 
				rs = ps.executeQuery();
		  
				while(rs.next()) {
					msg = "아이디는 '" + rs.getString("id").substring(0, 3) + "*****" + "' 입니다.";
				}
			}else if(findType.contentEquals("find_pwd")){
				sql = "select * from members where name = ? and email = ? and id = ? " ;

				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, email); 
				ps.setString(3, id);
				rs = ps.executeQuery();
		  
				while(rs.next()) {
					msg = "암호는 '" + rs.getString("pwd") + "' 입니다.";
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}return msg;
	}
}
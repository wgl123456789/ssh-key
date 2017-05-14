package netctoss.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.crypto.provider.RSACipher;

import netctoss.controller.dao.AdminDAO;
import netctoss.controller.entity.Admin;

@Repository("adminDAO")
//持久层 访问数据库就用这个注解
public class AdminDAOJdbcImpl implements AdminDAO {
	@Resource(name="ds")
	private DataSource ds;
	
	public Admin findByAdminCode(String adminCode) {
      Connection conn = null;
      PreparedStatement ps=null;
      ResultSet rs = null;
      try {
		conn = ds.getConnection();
		String sql="select * from admin_info_wgl where admin_code=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, adminCode);
	    rs = ps.executeQuery();
	    if(rs.next()){
	    	Admin a = new Admin();
	    	a.setAdminId(rs.getInt("admin_id"));
			a.setAdminCode(rs.getString("admin_code"));
			a.setPassword(rs.getString("password"));
			a.setName(rs.getString("name"));
			a.setTelephone(rs.getString("telephone"));
			a.setEmail(rs.getString("email"));
            a.setEnrolldate(rs.getTimestamp("enrolldate"));
			return a;
	    	
	    }
	} catch (SQLException e) {
		//记日志
		e.printStackTrace();
		throw new RuntimeException(e);
	}finally{
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
      return null;
      
      
		
		
	}
  
}

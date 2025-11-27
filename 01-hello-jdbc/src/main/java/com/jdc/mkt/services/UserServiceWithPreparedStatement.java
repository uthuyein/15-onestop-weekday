package com.jdc.mkt.services;

import com.jdc.mkt.entity.User;
import static com.jdc.mkt.utils.ConnectionManager.*;

import java.util.List;

public class UserServiceWithPreparedStatement {
	
	public int insert(User user) {
		String sql = "insert into user_tbl(username,loginId,password)values(?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getLoginId());
			stmt.setString(3, user.getPassword());
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0 ;
	}
	
	public int update(User user) {
		String sql = "update user_tbl set username= ? , password = ? where id = ? ";
		try(var con = getConnection(); var stmt = con.prepareCall(sql)){
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getId());
			return stmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(int id) {
		return 0;
	}
	
	public List<User> select(){
		return null;
	}
	
}

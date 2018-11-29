package com.internousdev.casablanca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.casablanca.dto.UserInfoDTO;
import com.internousdev.casablanca.util.DBConnector;

public class UserInfoDAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public int createUser(String familyName, String firstName, String familyNameKana, String firstNameKana, String sex, String email, String loginId, String password) {
		DBConnector db = new DBConnector();
		con = db.getConnection();
		int count = 0;
		String sql = "insert into user_info(user_id, password, family_name, first_name, family_name_kana,"
					+ " first_name_kana, sex, email, status, logined, regist_date, update_date)"
					+ " values (?,?,?,?,?,?,?,?,?,?, now(), now())";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, sex);
			ps.setString(8, email);
			ps.setInt(9, 0);
			ps.setInt(10, 1);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public UserInfoDTO getLoginInfo(String loginId, String password) {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		DBConnector db = new DBConnector();
		con = db.getConnection();
		String sql = "select * from user_info where user_id = ? and password = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userInfoDTO;
	}

	public UserInfoDTO getUserInfo(String loginId) {
		DBConnector db = new DBConnector();
		con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			rs = ps.executeQuery();
			while(rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userInfoDTO;
	}

	public boolean isExistsLoginId(String loginId) {
		DBConnector db = new DBConnector();
		con = db.getConnection();
		boolean result = false;{
		String sql = "select count(*) as count from user_info where user_id= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt("count") >0){
					result = true;
				}
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
			}
		}

	public boolean isExistsUserInfo(String loginId, String password) {
		DBConnector db = new DBConnector();
		con = db.getConnection();
		boolean result = false;{
		String sql = "select count(*) as count from user_info where user_id=? and password=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt("count") >0){
					result = true;
				}
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
			}
		}

	public void login(String loginId, String password) {
		DBConnector db =new DBConnector();
		con = db.getConnection();
		String sql = "update user_info set logined=1 where user_id = ? and password = ?";
		try {
			ps =con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void logout(String loginId) {
		DBConnector db = new DBConnector();
		con = db.getConnection();
		String sql = "update user_info set logined=0 where user_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int resetPassword(String loginId, String password) {
		DBConnector db = new DBConnector();
		con = db.getConnection();
		String sql = "update user_info set password=? where user_id=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, loginId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
 	}

}

package com.college.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.college.project.dto.UserDTO;
import com.college.project.util.DBUtil;

public class UserDAO {

    private DBUtil dbUtil;

    public UserDAO(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    private final String USER_DATA_INSERT = "INSERT INTO user (name, email, mobile_number, city) VALUES (?, ?, ?, ?)";

    private final String USER_DATA_FIND_ALL = "select * from user";
    
    public int save(UserDTO userDTO) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count;

        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(USER_DATA_INSERT);

            pstmt.setString(1, userDTO.getName());
            pstmt.setString(2, userDTO.getEmail());
            pstmt.setString(3, userDTO.getMobile_number());
            pstmt.setString(4, userDTO.getCity());

            count = pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            dbUtil.close(connection, pstmt);
        }

        return count;
    }
    
    public List<UserDTO> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDTO> userDTOList = new ArrayList<>();
		try {
			connection = dbUtil.getConnection();
			pstmt = connection.prepareStatement(USER_DATA_FIND_ALL);

			rs = pstmt.executeQuery(); 

			while (rs.next()) { 
				UserDTO userDTO = new UserDTO();
				userDTO.setUserId(rs.getInt("id"));
				userDTO.setName(rs.getString("name"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setMobile_number(rs.getString("mobile_number"));
				userDTO.setCity(rs.getString("city"));
				userDTOList.add(userDTO);

			}

		} catch (Exception e) {
			throw e;
		} finally {
			dbUtil.close(connection, pstmt, rs);
		}

		return userDTOList;
	}
}

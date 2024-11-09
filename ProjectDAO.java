

package com.college.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.college.project.dto.ProjectDTO;

import com.college.project.util.DBUtil;

public class ProjectDAO {
    private DBUtil dbUtil;

    public ProjectDAO(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    private final String PROJECT_DATA_INSERT = "INSERT INTO PROJECT(image, name, description) VALUES(?, ?, ?)";
    private final String PROJECT_DATA_FIND_ALL = "select * from project";
    private final String PROJECT_DATA_UPDATE = "update project set name = ?, image = ?,description=?  where id = ?";	
	private final String PROJECT_DATA_DELETE_BY_ID = "delete from project where id = ?";
	
    public int addProject(ProjectDTO projectDTO) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;

        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(PROJECT_DATA_INSERT);
            pstmt.setString(1, projectDTO.getImage());
            pstmt.setString(2, projectDTO.getName());
            pstmt.setString(3, projectDTO.getDescription());

            count = pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            dbUtil.close(connection, pstmt, null);
        }
        return count;
    }


public List<ProjectDTO> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProjectDTO> projectDTOList = new ArrayList<>();
		try {
			connection = dbUtil.getConnection();
			pstmt = connection.prepareStatement(PROJECT_DATA_FIND_ALL);

			rs = pstmt.executeQuery(); 

			while (rs.next()) { 
				ProjectDTO projectDTO = new ProjectDTO();
				projectDTO.setProjectId(rs.getInt("id"));
				projectDTO.setName(rs.getString("name"));
				projectDTO.setDescription(rs.getString("description"));
				projectDTO.setImage(rs.getString("image"));
				projectDTOList.add(projectDTO);

			}

		} catch (Exception e) {
			throw e;
		} finally {
			dbUtil.close(connection, pstmt, rs);
		}

		return projectDTOList;
	}

//Update Project
public int updateProject(ProjectDTO projectDTO) throws Exception {
 Connection connection = null;
 PreparedStatement pstmt = null;
 int count;
 try {
     connection = dbUtil.getConnection();
     pstmt = connection.prepareStatement(PROJECT_DATA_UPDATE);
     
     // Set values for the project
     pstmt.setString(1, projectDTO.getName());
     pstmt.setString(2, projectDTO.getImage());
     pstmt.setString(3, projectDTO.getDescription());
     pstmt.setInt(4, projectDTO.getProjectId()); // Assuming the project has an ID
     
     count = pstmt.executeUpdate();
 } catch (Exception e) {
     throw e;
 } finally {
     dbUtil.close(connection, pstmt);
 }
 return count;
}

//Delete Project by ID
public int deleteProjectById(int id) throws ClassNotFoundException, SQLException {
 Connection connection = null;
 PreparedStatement pstmt = null;
 int count = 0;
 try {
     connection = dbUtil.getConnection();
     pstmt = connection.prepareStatement(PROJECT_DATA_DELETE_BY_ID);
     pstmt.setInt(1, id);
     count = pstmt.executeUpdate();
 } catch (Exception e) {
     throw e;
 } finally {
     dbUtil.close(connection, pstmt);
 }

 return count;
}

}
package com.college.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.college.project.dto.ClientDTO;
import com.college.project.util.DBUtil;

public class ClientDAO {
	
	
	private DBUtil dbUtil;

	public ClientDAO(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	 private final String CLIENT_DATA_INSERT = "insert into client(image,name,description,designation)"
	 		+ "value(?,?,?,?)";
	 private final String CLIENT_DATA_FIND_ALL = "select * from client";
	 private final String CLIENT_DATA_UPDATE = "update client set name = ?, image = ?,description=? ,designation=?  where id = ?";	
     private final String CLIENT_DATA_DELETE_BY_ID = "delete from client where id = ?";
		

	
	public int addClient(ClientDTO clientDTO) throws ClassNotFoundException, SQLException {
	
		Connection connection = null;
		PreparedStatement pstmt = null;
				int count;
				
		try {
			connection = dbUtil.getConnection();
			pstmt = connection.prepareStatement(CLIENT_DATA_INSERT);
			
			pstmt.setString(1, clientDTO.getImage());
			pstmt.setString(2, clientDTO.getName());
			pstmt.setString(3, clientDTO.getDescription());
			pstmt.setString(4, clientDTO.getDesignation());
		
			
			count = pstmt.executeUpdate(); 
		}catch(Exception e) {
			throw e;
		}
		
		finally {
			dbUtil.close(connection, pstmt);
		}
		return count;
		 
	}
	
	public List<ClientDTO> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClientDTO> clientDTOList = new ArrayList<>();
		try {
			connection = dbUtil.getConnection();
			pstmt = connection.prepareStatement(CLIENT_DATA_FIND_ALL);

			rs = pstmt.executeQuery(); 

			while (rs.next()) { 
				ClientDTO clientDTO = new ClientDTO();
				clientDTO.setClientId(rs.getInt("id"));
				clientDTO.setName(rs.getString("name"));
				clientDTO.setDescription(rs.getString("description"));
				clientDTO.setDescription(rs.getString("designation"));
				clientDTO.setImage(rs.getString("image"));
				clientDTOList.add(clientDTO);

			}

		} catch (Exception e) {
			throw e;
		} finally {
			dbUtil.close(connection, pstmt, rs);
		}

		return clientDTOList;
	}
    
	// Update Client
	public int updateClient(ClientDTO clientDTO) throws Exception {
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    int count;
	    try {
	        connection = dbUtil.getConnection();
	        pstmt = connection.prepareStatement(CLIENT_DATA_UPDATE);
	        
	        // Set values for the client
	        pstmt.setString(1, clientDTO.getName());
	        pstmt.setString(2, clientDTO.getImage());
	        pstmt.setString(3, clientDTO.getDescription());
	        pstmt.setString(4, clientDTO.getDesignation());
	        pstmt.setInt(5, clientDTO.getClientId()); // Assuming the client has an ID
	        
	        count = pstmt.executeUpdate();
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        dbUtil.close(connection, pstmt);
	    }
	    return count;
	}

	// Delete Client by ID
	public int deleteClientById(int id) throws ClassNotFoundException, SQLException {
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    int count = 0;
	    try {
	        connection = dbUtil.getConnection();
	        pstmt = connection.prepareStatement(CLIENT_DATA_DELETE_BY_ID);
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

package com.college.project.service;

import java.sql.SQLException;
import java.util.List;

import com.college.project.dao.ClientDAO;
import com.college.project.dto.ClientDTO;


public class ClientService {
	
	 private ClientDAO clientDAO;

     public ClientService(ClientDAO clientDAO) {
 		this.clientDAO = clientDAO;
 	}
     

 	public int addClient(ClientDTO clientDTO) throws Exception {
		int count =clientDAO.addClient(clientDTO);
		if(count != 0 ) {
			
		}
		return count;
	}

 	 public List<ClientDTO> findAll() throws ClassNotFoundException, SQLException {
  		return clientDAO.findAll();
  	}
 	 

 	    public int updateClient(ClientDTO clientDTO) throws Exception {
 	        return clientDAO.updateClient(clientDTO);
 	    }

 	    // Delete Client by ID
 	    public int deleteClientById(int id) throws ClassNotFoundException, SQLException {
 	        int count = clientDAO.deleteClientById(id);
 	        if (count != 0) {
 	            // Perform any additional logic if needed (like logging, etc.)
 	        }
 	        return count;
 	    }
 	}



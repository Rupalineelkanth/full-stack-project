package com.college.project.service;


import java.sql.SQLException;
import java.util.List;

import com.college.project.dao.UserDAO;
import com.college.project.dto.UserDTO;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int save(UserDTO userDTO) throws Exception {
        return userDAO.save(userDTO);
    }
    
    public List<UserDTO> findAll() throws ClassNotFoundException, SQLException {
		return userDAO.findAll();
	}
}


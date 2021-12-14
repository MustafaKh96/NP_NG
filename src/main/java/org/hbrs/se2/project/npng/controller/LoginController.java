package org.hbrs.se2.project.npng.controller;

import org.hbrs.se2.project.npng.controller.exception.DatabaseUserException;
import org.hbrs.se2.project.npng.dto.UserDTO;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    private UserDTO userDTO;

    public boolean authentificate(String eMail, String password) throws DatabaseUserException {

        this.userDTO = this.getUserWithJPA(eMail, password);

        if (userDTO == null){

            return false;
        }
        return true;
    }

    public UserDTO getCurrentUser(){

        return this.userDTO;
    }

    public UserDTO getUserWithJPA (String eMail, String password) throws DatabaseUserException{

        UserDTO userDTO;
        try{

            userDTO = userRepository.findUserByMailAndPassword(eMail, password);
        }catch ( org.springframework.dao.DataAccessResourceFailureException e ) {

            throw new DatabaseUserException("A failure occured while trying to connect to database with JPA");
        }
        return userDTO;
    }
}

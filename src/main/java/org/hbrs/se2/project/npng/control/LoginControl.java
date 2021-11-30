package org.hbrs.se2.project.npng.control;

import org.hbrs.se2.project.npng.control.exception.DatabaseUserException;
import org.hbrs.se2.project.npng.dtos.UserDTO;
import org.hbrs.se2.project.npng.repository.UserRepository;

public class LoginControl {

    private UserRepository repository;
    private UserDTO userDTO = null;

    public boolean authentificate(String username, String password ) throws DatabaseUserException {

        // User wird mit Spring JPA ausgelesen.
        UserDTO tmpUser = this.getUser( username , password );
        if ( tmpUser == null ) {
            return false;
        }
        this.userDTO = tmpUser;
        return true;
    }

    public UserDTO getCurrentUser(){
        return this.userDTO;

    }

    private UserDTO getUser( String username , String password ) throws DatabaseUserException {
        UserDTO userTmp;
        try {
            userTmp = repository.findUserByUseridAndPassword(username, password);
        } catch ( org.springframework.dao.DataAccessResourceFailureException e ) {
            // Analyse und Umwandlung der technischen Errors in 'lesbaren' Darstellungen.
            throw new DatabaseUserException("A failure occured while trying to connect to database with JPA");
        }
        return userTmp;
    }
}

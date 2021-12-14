package org.hbrs.se2.project.npng.repository;

import org.hbrs.se2.project.npng.dto.UserDTO;
import org.hbrs.se2.project.npng.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {


    UserDTO findUserByMailAndPassword (String eMail, String password);
    UserDTO findUserByPassword(String password);
}

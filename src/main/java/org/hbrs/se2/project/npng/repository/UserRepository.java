package org.hbrs.se2.project.npng.repository;

import org.hbrs.se2.project.npng.dtos.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {

    // SELECT firstname, lastname, id
    // FROM User p
    // WHERE p.userid = [StringValueOf( userid )] AND p.password = [StringValueOf( password )]
    UserDTO findUserByUseridAndPassword (String userid , String password);

}

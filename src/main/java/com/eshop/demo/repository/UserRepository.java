package com.eshop.demo.repository;

import com.eshop.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Ani Poghosyan on 14/02/2022
 */
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
}

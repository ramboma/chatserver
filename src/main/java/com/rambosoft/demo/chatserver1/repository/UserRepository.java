package com.rambosoft.demo.chatserver1.repository;

import com.rambosoft.demo.chatserver1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rambo on 2019/3/24.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}

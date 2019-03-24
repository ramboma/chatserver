package com.rambosoft.demo.chatserver1.controller;

import com.rambosoft.demo.chatserver1.model.Result;
import com.rambosoft.demo.chatserver1.model.User;
import com.rambosoft.demo.chatserver1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rambo on 2019/3/24.
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value="/add",method= RequestMethod.POST)
   public Result addUser(@RequestBody User user)
   {
       userRepository.save(user);
       Result result=new Result();
       result.setSuccess(true);
       return result;
   }
   @RequestMapping(value="/list",method=RequestMethod.GET)
   public Result<List<User>> getUserList()
   {
       List<User> list=userRepository.findAll();
       Result<List<User>> userlist=new Result<List<User>>();
       userlist.setSuccess(true);
       userlist.setDate(list);
       userlist.setStatusCode(100);
       return userlist;
   }

}

package com.example.service;

import com.example.entity.Users;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xiuchong
 * @Date: 2020/8/13 15:12
 * @Description:
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Users getPassByNick(String nick) {

        Users users = usersRepository.findByNick(nick);

        return users;
    }
}

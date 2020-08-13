package com.example.repository;

import com.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiuchong
 * @Date: 2020/8/13 15:14
 * @Description:
 */
public interface UsersRepository  extends JpaRepository<Users,String> {

    Users findByNick(String nick);

}

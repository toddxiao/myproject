package com.mycompany.myproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.mycompany.myproject.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}

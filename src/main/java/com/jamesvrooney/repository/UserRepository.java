package com.jamesvrooney.repository;

import com.jamesvrooney.entities.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}

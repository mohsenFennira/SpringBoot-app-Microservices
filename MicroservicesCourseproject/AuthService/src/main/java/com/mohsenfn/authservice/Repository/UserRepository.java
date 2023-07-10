package com.mohsenfn.authservice.Repository;

import com.mohsenfn.authservice.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}

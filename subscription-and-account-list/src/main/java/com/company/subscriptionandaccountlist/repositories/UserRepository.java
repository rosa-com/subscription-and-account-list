package com.company.subscriptionandaccountlist.repositories;

import com.company.subscriptionandaccountlist.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByPasswordAndEmail(@Param("password") String password,
                                          @Param("email") String email);
}

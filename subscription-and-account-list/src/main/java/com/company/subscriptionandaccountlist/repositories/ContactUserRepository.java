package com.company.subscriptionandaccountlist.repositories;

import com.company.subscriptionandaccountlist.models.ContactUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUserRepository extends CrudRepository<ContactUser, Long> {

}

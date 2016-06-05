package org.tiscs.reststack.identity.models.mappers;

import org.springframework.stereotype.Repository;
import org.tiscs.reststack.identity.models.User;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();
}

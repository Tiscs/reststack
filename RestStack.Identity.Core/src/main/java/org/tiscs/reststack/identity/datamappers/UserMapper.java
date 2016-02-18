package org.tiscs.reststack.identity.datamappers;

import org.springframework.stereotype.Repository;
import org.tiscs.reststack.identity.datamodels.User;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();
}

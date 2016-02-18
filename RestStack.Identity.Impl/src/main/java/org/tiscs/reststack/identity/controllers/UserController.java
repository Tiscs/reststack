package org.tiscs.reststack.identity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.tiscs.reststack.core.annotations.RequestQuery;
import org.tiscs.reststack.core.generic.DataQuery;
import org.tiscs.reststack.identity.datamappers.UserMapper;
import org.tiscs.reststack.identity.datamodels.User;
import org.tiscs.reststack.identity.dataservices.UserService;

import java.util.List;

@RestController
public class UserController implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(@RequestQuery DataQuery dataQuery) {
        return userMapper.findAll();
    }
}

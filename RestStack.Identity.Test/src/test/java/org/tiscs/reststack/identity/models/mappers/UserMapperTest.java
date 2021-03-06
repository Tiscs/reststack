package org.tiscs.reststack.identity.models.mappers;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.tiscs.reststack.core.contexts.DbContext;
import org.tiscs.reststack.core.contexts.WebContext;
import org.tiscs.reststack.identity.controllers.UserController;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DbContext.class, WebContext.class})
public class UserMapperTest {
    @Autowired
    private ApplicationContext applicationContext;
    private UserController userController;
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        this.userController = applicationContext.getBean(UserController.class);
        this.userMapper = applicationContext.getBean(UserMapper.class);
    }

    @org.junit.Test
    public void findAll() throws Exception {
        assertNotNull(userController);
        assertNotNull(userMapper);
    }
}
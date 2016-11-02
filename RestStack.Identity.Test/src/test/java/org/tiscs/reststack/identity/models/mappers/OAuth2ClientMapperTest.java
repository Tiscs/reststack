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

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DbContext.class, WebContext.class})
public class OAuth2ClientMapperTest {
    @Autowired
    private ApplicationContext applicationContext;
    private OAuth2ClientMapper oAuth2AgentMapper;

    @Before
    public void setUp() throws Exception {
        this.oAuth2AgentMapper = applicationContext.getBean(OAuth2ClientMapper.class);
    }

    @org.junit.Test
    public void findOneById() throws Exception {
        oAuth2AgentMapper.findOneById(UUID.fromString("53c846cc-bda4-4961-b723-fab6bb9fc579"));
    }
}

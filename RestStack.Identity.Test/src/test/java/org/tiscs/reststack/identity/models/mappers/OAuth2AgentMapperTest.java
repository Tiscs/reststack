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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DbContext.class, WebContext.class})
public class OAuth2AgentMapperTest {
    @Autowired
    private ApplicationContext applicationContext;
    private OAuth2AgentMapper oAuth2AgentMapper;

    @Before
    public void setUp() throws Exception {
        this.oAuth2AgentMapper = applicationContext.getBean(OAuth2AgentMapper.class);
    }

    @org.junit.Test
    public void findOneByAccessToken() throws Exception {
        oAuth2AgentMapper.findOneByAccessToken("***");
    }

    @org.junit.Test
    public void findOneByRefreshToken() throws Exception {
        oAuth2AgentMapper.findOneByRefreshToken("***");
    }
}

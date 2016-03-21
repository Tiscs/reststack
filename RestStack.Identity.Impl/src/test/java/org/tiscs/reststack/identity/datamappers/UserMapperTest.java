package org.tiscs.reststack.identity.datamappers;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.tiscs.reststack.core.contexts.AppContext;
import org.tiscs.reststack.core.contexts.DbContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class, DbContext.class}, loader = AnnotationConfigContextLoader.class)
public class UserMapperTest {
    @Autowired
    private BasicDataSource dataSource;

    @org.junit.Test
    public void findAll() throws Exception {
        assertNotNull(dataSource);
    }
}
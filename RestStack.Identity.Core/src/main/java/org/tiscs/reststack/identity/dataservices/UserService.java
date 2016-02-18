package org.tiscs.reststack.identity.dataservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tiscs.reststack.core.annotations.RequestQuery;
import org.tiscs.reststack.core.generic.DataQuery;
import org.tiscs.reststack.identity.datamodels.User;

import java.util.List;

@RequestMapping(value = "users")
public interface UserService {
    @RequestMapping(value = "", method = RequestMethod.GET)
    List<User> findAll(@RequestQuery DataQuery dataQuery);
}

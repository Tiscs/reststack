package org.tiscs.reststack.identity.dataservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tiscs.reststack.core.annotations.ApiDoc;
import org.tiscs.reststack.core.annotations.RequestQuery;
import org.tiscs.reststack.core.annotations.RequiresPermissions;
import org.tiscs.reststack.core.generic.DataQuery;
import org.tiscs.reststack.identity.datamodels.User;

import java.util.List;

@ApiDoc(owner = "suncy", name = "Users")
@RequestMapping(value = "users")
public interface UserService {
    @ApiDoc(owner = "suncy", name = "Find users", description = "Find users.")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @RequiresPermissions("Authenticated")
    List<User> findAll(@ApiDoc(name = "DataQuery")
                       @RequestQuery DataQuery dataQuery);
}

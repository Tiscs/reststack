package org.tiscs.reststack.core.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tiscs.reststack.core.models.ServiceDoc;

@RequestMapping(value = "$docs")
public interface ApiDocService {
    @RequestMapping(value = "services", method = RequestMethod.GET)
    Iterable<ServiceDoc> getServiceDocs();
}

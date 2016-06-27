package org.tiscs.reststack.identity.models.mappers;

import org.springframework.stereotype.Repository;
import org.tiscs.reststack.identity.models.OAuth2Request;

@Repository
public interface OAuth2RequestMapper {
    OAuth2Request findOneByCode(String code);
}

package org.tiscs.reststack.identity.models.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiscs.reststack.identity.models.OAuth2Client;

import java.util.UUID;

@Repository
public interface OAuth2ClientMapper {
    OAuth2Client findOneById(@Param("id") UUID id);
}

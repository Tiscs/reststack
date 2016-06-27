package org.tiscs.reststack.identity.models.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiscs.reststack.identity.models.OAuth2Agent;

@Repository
public interface OAuth2AgentMapper {
    OAuth2Agent findOneByAccessToken(@Param("accessToken") String accessToken);

    OAuth2Agent findOneByRefreshToken(@Param("refreshToken") String refreshToken);
}

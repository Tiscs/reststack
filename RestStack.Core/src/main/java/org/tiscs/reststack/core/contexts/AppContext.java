package org.tiscs.reststack.core.contexts;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DbContext.class)
public class AppContext {
}

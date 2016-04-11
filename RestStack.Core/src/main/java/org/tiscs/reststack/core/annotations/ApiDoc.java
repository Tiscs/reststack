package org.tiscs.reststack.core.annotations;

import java.lang.annotation.*;

/**
 * 接口文档描述注解。
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiDoc {
    String name();

    String description() default "";

    String owner() default "";
}

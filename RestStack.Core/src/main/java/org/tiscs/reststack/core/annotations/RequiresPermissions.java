package org.tiscs.reststack.core.annotations;

import java.lang.annotation.*;

/**
 * 权限声明注解。
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RequiresPermissions {
    String[] value() default {};
}

package 设计模式.结构型模式.代理模式.agent;

import java.lang.annotation.*;

/**
 * @Author cxc
 * @Date 2023/3/29 9:10 PM
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
    String value() default "";
}

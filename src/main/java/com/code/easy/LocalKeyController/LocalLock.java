package com.code.easy.LocalKeyController;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description
 * 锁注解
 * DATE 2019/3/27.
 *
 * @author daijinwu.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    /**
     *
     * @return string
     */
    String key() default "";

    /**
     *过期时间
     * TODO 由于用的 guava 暂时就忽略这属性吧 集成 redis 需要用到
     * @return int
     */
    int expire() default 5;

}

package com.code.easy.streamcode;

/**
 * Description
 * DATE 2019/10/21.
 *
 * @author daijinwu.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T covert(F from);
}

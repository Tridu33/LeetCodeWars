package com.tridu33.JavaNotes.FP;

import java.util.Objects;

/**
 * 代表这一个方法，能够接受参数，并且返回一个结果
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Function<T, R> {
    /**
     * 将参数赋予给相应方法
     *
     * @param t
     * @return
     */
    R apply(T t);

    /**
     * 先执行参数(即也是一个Function)的，再执行调用者(同样是一个Function)
     */
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    /**
     * 先执行调用者，再执行参数，和compose相反。
     */
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    /**
     * 返回当前正在执行的方法
     */
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}

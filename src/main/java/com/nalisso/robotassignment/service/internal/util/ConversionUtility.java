package com.nalisso.robotassignment.service.internal.util;

import java.util.Arrays;
import java.util.function.Predicate;

public class ConversionUtility<T> {

    public T convert(Predicate<? super T> predicate, T[] values) {
        return Arrays.stream(values)
                .filter(predicate)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

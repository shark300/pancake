package io.github.pancake.app.domain.support;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts {@link List} of type T to {@link List} of type U.
 * @author Bence_Kornis
 */
public class ListConverter {
    /**
     * Converts the two {@link List}
     * @param from the {@link List} of type T to be converted
     * @param func {@link Function} definess the conversion
     * @param <T> the type to be converted
     * @param <U> the converted type
     * @return the converted {@link List} of type U
     */
    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func){
        return from.stream().map(func).collect(Collectors.toList());
    }
}

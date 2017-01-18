
package com.todolist;

import java.util.function.BiFunction;

/**
 *
 * @author yedenguele
 */
public class BiFunctionalExample implements BiFunction<Integer, Float, String> {

    @Override
    public String apply(Integer t, Float u) {

        return t.toString() + u.toString();

    }
}

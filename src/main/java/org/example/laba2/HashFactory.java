package org.example.laba2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HashFactory {

    public static <T> List<Function<T, Integer>> simpleHashes(int k, int seed) {
        List<Function<T, Integer>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            final int s = seed * (i + 1);
            list.add(x -> x.toString().hashCode() + s);
        }
        return list;
    }
}
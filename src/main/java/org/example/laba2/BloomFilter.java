package org.example.laba2;

import java.util.BitSet;
import java.util.function.Function;
import java.util.List;

public class BloomFilter<T> {

    private final BitSet bits;
    private final int size;
    private final List<Function<T, Integer>> hashFunctions;

    public BloomFilter(int size, List<Function<T, Integer>> hashFunctions) {
        this.size = size;
        this.bits = new BitSet(size);
        this.hashFunctions = hashFunctions;
    }

    public void add(T key) {
        for (Function<T, Integer> f : hashFunctions) {
            int pos = Math.abs(f.apply(key)) % size;
            bits.set(pos);
        }
    }

    public boolean contains(T key) {
        for (Function<T, Integer> f : hashFunctions) {
            int pos = Math.abs(f.apply(key)) % size;
            if (!bits.get(pos)) return false;   // явно нет
        }
        return true;                            // возможно, есть
    }

    public int bitCount() {
        return bits.cardinality();
    }
}

package org.example.laba2;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Function;

@Service
public class BloomFilterService {
    private BloomFilter<String> filter;

    public void init(int size, List<Function<String,Integer>> hashes) {
        filter = new BloomFilter<>(size, hashes);
    }

    public void add(String key) {
        ensureInit();
        filter.add(key);
    }

    public boolean contains(String key) {
        ensureInit();
        return filter.contains(key);
    }

    private void ensureInit() {
        if (filter == null) {
            init(1_000, HashFactory.simpleHashes(3, 12345));
        }
    }
}


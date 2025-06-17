package org.example.laba2;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filter")

public class BloomFilterController {
    private final BloomFilterService service;

    public BloomFilterController(BloomFilterService service) {
        this.service = service;
    }


    @PostMapping("/init")
    public ResponseEntity<?> init(@RequestBody InitReq req) {
        service.init(req.size,
                HashFactory.simpleHashes(req.k, req.seed));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KeyReq req) {
        service.add(req.key);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contains")
    public ResponseEntity<Boolean> contains(@RequestParam String key) {
        return ResponseEntity.ok(service.contains(key));
    }

    // Dto
    @Data static class InitReq { public int size; public int k; public int seed = 31; }
    @Data static class KeyReq  { public String key; }
}

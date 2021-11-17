package com.postgres.fulltextsearch.web.controller;

import com.postgres.fulltextsearch.entities.FtsGlobal;
import com.postgres.fulltextsearch.entities.FtsOne;
import com.postgres.fulltextsearch.repository.FtsGlobalRepository;
import com.postgres.fulltextsearch.repository.FtsOneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ftglobal")
@RequiredArgsConstructor
public class FtsGlobalController {

    private final FtsGlobalRepository repository;

    @GetMapping
    public List<FtsGlobal> findByDescription(@RequestParam String description, @RequestParam String name){
        return repository.search(FtsGlobal.builder().description(description).name(name).build());
    }
}

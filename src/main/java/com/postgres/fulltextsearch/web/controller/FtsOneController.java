package com.postgres.fulltextsearch.web.controller;

import com.postgres.fulltextsearch.entities.FtsOne;
import com.postgres.fulltextsearch.repository.FtsOneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ftsone")
@RequiredArgsConstructor
public class FtsOneController {

    private final FtsOneRepository repository;

    @GetMapping
    public List<FtsOne> findByDescription(@RequestParam String search){
        return repository.search(FtsOne.builder().description(search).build());
    }
}

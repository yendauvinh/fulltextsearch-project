package com.postgres.fulltextsearch.service.impl;

import com.postgres.fulltextsearch.repository.FtsGlobalRepository;
import com.postgres.fulltextsearch.service.FtsGlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class FtsGlobalServiceImpl implements FtsGlobalService {
    private final FtsGlobalRepository repository;

    @Override @Async
    public void saveNewToken(String description, String name, UUID tokenId) {
        repository.saveNewFts(description, name, tokenId);
    }
}

package com.postgres.fulltextsearch.service;

import java.util.UUID;

public interface FtsGlobalService {
    void saveNewToken(String description, String name, UUID tokenId);
}

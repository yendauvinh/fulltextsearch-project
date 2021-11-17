package com.postgres.fulltextsearch.repository;

import com.postgres.fulltextsearch.entities.FtsGlobal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface FtsGlobalRepository extends BaseRepository<FtsGlobal> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO fts_global(description, name, fts_one_id) VALUES " +
            "(to_tsvector(?1), to_tsvector(?2), ?3)", nativeQuery = true)
    void saveNewFts(String description, String name, UUID uuid);
}

package com.postgres.fulltextsearch.configurations;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.BooleanType;

public class SqlFunctionMetaBuilderContributor implements MetadataBuilderContributor {
    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
//        metadataBuilder.applySqlFunction("fts",
//                new SQLFunctionTemplate(BooleanType.INSTANCE,
//                        "to_tsvector(description) @@ plainto_tsquery(?1)"));
        metadataBuilder.applySqlFunction("fts",
                new SQLFunctionTemplate(BooleanType.INSTANCE,
                        "description @@ plainto_tsquery(?1)"));
    }
}
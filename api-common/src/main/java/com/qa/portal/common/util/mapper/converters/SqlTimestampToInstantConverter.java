package com.qa.portal.common.util.mapper.converters;

import org.dozer.DozerConverter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

public class SqlTimestampToInstantConverter extends DozerConverter<Timestamp, Instant> {

    public SqlTimestampToInstantConverter() {
        super(Timestamp.class, Instant.class);
    }

    private static Instant get() {
        return null;
    }

    @Override
    public Instant convertTo(Timestamp timestamp, Instant instant) {
       return Optional.ofNullable(timestamp).map(t -> t.toInstant()).orElseGet(() -> null);
    }

    @Override
    public Timestamp convertFrom(Instant instant, Timestamp timestamp) {
        return Optional.ofNullable(instant).map(i -> Timestamp.from(i)).orElseGet(() -> null);
    }
}

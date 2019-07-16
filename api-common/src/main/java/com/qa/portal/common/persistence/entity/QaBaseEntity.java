package com.qa.portal.common.persistence.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public class QaBaseEntity {

    @Column(name="last_updated_timestamp")
    protected Timestamp lastUpdatedTimestamp;

    @Column(name="last_updated_by")
    protected String lastUpdatedBy;

    public Timestamp getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}

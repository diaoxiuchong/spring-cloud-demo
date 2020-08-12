package com.example.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class EntityAutoListener {

    @PrePersist
    public void prePersist(EntityAuto entityAuto) {
        Date now = new Date();
        entityAuto.setCreateTime(now);
        entityAuto.setModifyTime(now);
    }

    @PreUpdate
    public void preUpdate(EntityAuto entityAuto) {
        Date now = new Date();
        entityAuto.setModifyTime(now);
    }
}

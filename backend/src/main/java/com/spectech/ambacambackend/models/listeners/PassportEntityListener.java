package com.spectech.ambacambackend.models.listeners;

import com.spectech.ambacambackend.models.Action;
import com.spectech.ambacambackend.models.Passport;
import com.spectech.ambacambackend.models.history.PassportHistory;
import com.spectech.ambacambackend.utils.BeanUtil;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.MANDATORY;

public class PassportEntityListener {

    @PrePersist
    public void prePersist(Passport passport) {
        perform(passport, Action.CREATE);
    }

    @PreUpdate
    public void preUpdate(Passport passport) {
        perform(passport, Action.UPDATE);
    }

    @PreRemove
    public void preRemove(Passport passport) {
        perform(passport, Action.DELETE);
    }

    @Transactional(MANDATORY)
    void perform(Passport passport, Action action) {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        entityManager.persist(new PassportHistory(passport, action));
    }
}

package com.spectech.ambacambackend.models.history;

import com.spectech.ambacambackend.models.Action;
import com.spectech.ambacambackend.models.Passport;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class PassportHistory {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passport_id", foreignKey = @ForeignKey(name = "FK_passport_history_file"))
    private Passport passport;

    private String fileContent;

    @CreatedBy
    private String modifiedBy;


    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date modifiedDate;


    @Enumerated(STRING)
    private Action action;


    public PassportHistory() {
    }

    public PassportHistory(Passport passport, Action action) {
        this.passport = passport;
        this.fileContent = passport.toString();
        this.action = action;
    }

}

package com.tte.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.util.UUID;
import lombok.Data;

import java.util.Date;
import java.util.List;
 
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    private boolean isActive;
    
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phone> Phones;
    
    @PrePersist
    protected void onCreate() {
        created = new Date();
        modified = new Date();
        lastLogin = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modified = new Date();
    }

    
}

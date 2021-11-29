package com.folcademy.clinica.Model.Entities.Security;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "scopes")
@Data
public class Scope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "deleted", columnDefinition = "TINYINT")
    boolean deleted;
    @Column(name = "created")
    Timestamp created;
    @Column(name = "modified")
    Timestamp modified;
}


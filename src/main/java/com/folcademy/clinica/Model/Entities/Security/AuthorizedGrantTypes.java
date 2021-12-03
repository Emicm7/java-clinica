package com.folcademy.clinica.Model.Entities.Security;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "authorized_grant_types")
@Data
public class AuthorizedGrantTypes {
    @Column(name = "name")
    String name;
    @Column(name = "deleted", columnDefinition = "TINYINT")
    boolean deleted;
    @Column(name = "created")
    Timestamp created;
    @Column(name = "modified")
    Timestamp modified;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}

package com.qst.mikq.storage.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

/**
 * The entity class for role of users
 * example: Software-Engineer, Web-Designer etc.
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "role_entity")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true)
    String nameOfRole;

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    List<User> userWithThisRole = new ArrayList<>();
}

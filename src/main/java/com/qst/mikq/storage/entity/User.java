package com.qst.mikq.storage.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "user_entity")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @Column(unique = true)
    String login;

    String password;

    Integer level;

    Long experience;

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    List<Task> userTasks = new ArrayList<>();

}

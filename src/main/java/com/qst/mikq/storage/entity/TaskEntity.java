package com.qst.mikq.storage.entity;

import com.qst.mikq.storage.entity.enums.Priority;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@Builder
@Entity
@Table(name = "task_entity")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    String description;

    Long experience;

    @Builder.Default
    Instant createdAt = Instant.now();

    Instant deadline;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    User ownerId;

    @Enumerated(EnumType.STRING)
    Priority priority;
}

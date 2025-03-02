package com.baribir.events.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private Integer name;

    @Column(name = "code", nullable = false, length = Integer.MAX_VALUE)
    private String code;

}

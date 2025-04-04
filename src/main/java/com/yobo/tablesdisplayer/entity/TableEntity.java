package com.yobo.tablesdisplayer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mytables")

public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    public TableEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public TableEntity(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public TableEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TableEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

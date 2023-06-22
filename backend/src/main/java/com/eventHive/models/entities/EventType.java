package com.eventHive.models.entities;

import jakarta.persistence.*;

/**
 * @author vmikolyuk
 * @since 21.06.2023
 */
@Entity
@Table(name = "tbl_event_types")
public class EventType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

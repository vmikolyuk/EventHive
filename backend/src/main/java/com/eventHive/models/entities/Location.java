package com.eventHive.models.entities;

import jakarta.persistence.*;

/**
 * @author vmikolyuk
 * @since 21.06.2023
 */
@Entity
@Table(name = "tbl_locations")
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private Float latitude;

    @Column
    private Float longitude;

    @Column
    private Float address;


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

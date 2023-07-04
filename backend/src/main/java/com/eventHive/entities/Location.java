package com.eventHive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author vmikolyuk
 * @since 21.06.2023
 */
@Entity
@Table(name = "tbl_locations")
public class Location
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false)
    private Float longitude;

    @Column
    private String address;

    public String getAddress()
    {
        return address;
    }

    public Long getId()
    {
        return id;
    }

    public Float getLatitude()
    {
        return latitude;
    }

    public Float getLongitude()
    {
        return longitude;
    }

    public String getTitle()
    {
        return title;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setLatitude(Float latitude)
    {
        this.latitude = latitude;
    }

    public void setLongitude(Float longitude)
    {
        this.longitude = longitude;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}

package com.eventHive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author vmikolyuk
 * @since 21.06.2023
 */
@Entity
@Table(name = "tbl_locations")
public class Location extends AbstractEntity
{
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false)
    private Float longitude;

    @Column(nullable = false)
    private String address;

    @Column
    private String imagePath;

    public String getAddress()
    {
        return address;
    }

    public String getImagePath()
    {
        return imagePath;
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

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
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

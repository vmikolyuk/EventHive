package com.eventHive.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author vmikolyuk
 * @since 21.06.2023
 */
@Entity
@Table(name = "tbl_events")
public class Event extends AbstractEntity
{
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Long duration;

    @Column(nullable = false)
    private Integer totalMembers;

    @Column(nullable = false)
    private Integer countMembers;

    @ManyToOne(optional = false)
    private Location location;

    public Integer getCountMembers()
    {
        return countMembers;
    }

    public Long getDuration()
    {
        return duration;
    }

    public Location getLocation()
    {
        return location;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public Integer getTotalMembers()
    {
        return totalMembers;
    }

    public void setCountMembers(Integer countMembers)
    {
        this.countMembers = countMembers;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public void setTotalMembers(Integer totalMembers)
    {
        this.totalMembers = totalMembers;
    }
}

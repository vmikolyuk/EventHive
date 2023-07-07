package com.eventHive.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@MappedSuperclass
public abstract class AbstractEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date creationDate = new Date();

    public Date getCreationDate()
    {
        return creationDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}

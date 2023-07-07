package com.eventHive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@Entity
public class File extends AbstractEntity
{
    @Column(nullable = false)
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

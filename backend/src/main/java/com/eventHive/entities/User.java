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
@Table(name = "tbl_users")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String avatarPath;

    public String getAvatarPath()
    {
        return avatarPath;
    }

    public String getFullName()
    {
        return fullName;
    }

    public Long getId()
    {
        return id;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setAvatarPath(String avatarPath)
    {
        this.avatarPath = avatarPath;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}

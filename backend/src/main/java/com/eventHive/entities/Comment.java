package com.eventHive.entities;

import javax.xml.crypto.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@Entity
public class Comment
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Data creationDate;

    @Column(length = 1000, nullable = false)
    private String text;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Event event;

    public Data getCreationDate()
    {
        return creationDate;
    }

    public Event getEvent()
    {
        return event;
    }

    public Long getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }

    public User getUser()
    {
        return user;
    }

    public void setCreationDate(Data creationDate)
    {
        this.creationDate = creationDate;
    }

    public void setEvent(Event event)
    {
        this.event = event;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}

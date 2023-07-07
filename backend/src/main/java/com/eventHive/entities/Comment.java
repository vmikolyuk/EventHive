package com.eventHive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@Entity
@Table(name = "tbl_comments")
public class Comment extends AbstractEntity
{
    @Column(length = 1000, nullable = false)
    private String text;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Event event;

    public Event getEvent()
    {
        return event;
    }

    public String getText()
    {
        return text;
    }

    public User getUser()
    {
        return user;
    }

    public void setEvent(Event event)
    {
        this.event = event;
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

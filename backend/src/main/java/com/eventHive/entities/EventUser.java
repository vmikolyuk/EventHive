package com.eventHive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author vmikolyuk
 * @since 21.06.2023
 */
@Entity
@Table(name = "tbl_events_users")
public class EventUser extends AbstractEntity
{
    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    @Column
    private Integer memberCount;

    public Event getEvent()
    {
        return event;
    }

    public Integer getMemberCount()
    {
        return memberCount;
    }

    public User getUser()
    {
        return user;
    }

    public void setEvent(Event event)
    {
        this.event = event;
    }

    public void setMemberCount(Integer memberCount)
    {
        this.memberCount = memberCount;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}

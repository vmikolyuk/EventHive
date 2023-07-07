package com.eventHive.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.eventHive.entities.Event;

/**
 * @author vmikolyuk
 * @since 29.06.2023
 */
public interface EventRepository extends AbstractCrudRepository<Event>
{
    //List<Event> findAllByLocationIdIn(List<Long> locationIds);

    @Query("FROM Event WHERE startDate <= :date")
    List<Event> findActiveEvents(Date date);

    List<Event> findAllByLocationId(Long locationId);
}
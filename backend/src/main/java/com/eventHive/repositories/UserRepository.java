package com.eventHive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eventHive.entities.User;

/**
 * @author vmikolyuk
 * @since 22.06.2023
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    @Query("SELECT user FROM EventUser WHERE event.id = :eventId")
    List<User> findByEventId(Long eventId);
}

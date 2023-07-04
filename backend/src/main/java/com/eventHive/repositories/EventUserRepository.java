package com.eventHive.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eventHive.entities.EventUser;

/**
 * @author vmikolyuk
 * @since 22.06.2023
 */
public interface EventUserRepository extends CrudRepository<EventUser, Long>
{
}

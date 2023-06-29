package com.eventHive.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eventHive.models.entities.Location;

/**
 * @author vmikolyuk
 * @since 22.06.2023
 */
public interface LocationRepository extends CrudRepository<Location, Long>
{
}

package com.eventHive.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eventHive.entities.AbstractEntity;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
public interface AbstractCrudRepository<T extends AbstractEntity> extends CrudRepository<T, Long>
{
}

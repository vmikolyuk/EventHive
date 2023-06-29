package com.eventHive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventHive.models.entities.User;

/**
 * @author vmikolyuk
 * @since 22.06.2023
 */
public interface UserRepository extends JpaRepository<User, Long>
{
}

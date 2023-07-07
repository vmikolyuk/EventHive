package com.eventHive.repositories;

import java.util.List;

import com.eventHive.entities.Comment;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
public interface CommentRepository extends AbstractCrudRepository<Comment>
{
    List<Comment> findAllByEventId(Long eventId);
}

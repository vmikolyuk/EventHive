package com.eventHive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHive.entities.Comment;
import com.eventHive.repositories.CommentRepository;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@Service
public class CommentService
{
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository)
    {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getByEventId(Long eventId)
    {
        return commentRepository.findAllByEventId(eventId);
    }
}

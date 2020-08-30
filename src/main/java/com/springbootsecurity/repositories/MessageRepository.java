package com.springbootsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsecurity.entities.Message;

/**
 * @author Sonu Agrawal
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

}

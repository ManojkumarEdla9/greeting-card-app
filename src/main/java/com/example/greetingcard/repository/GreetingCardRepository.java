package com.example.greetingcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.greetingcard.entity.GreetingCard;

@Repository
public interface GreetingCardRepository extends JpaRepository<GreetingCard, Long> {
}

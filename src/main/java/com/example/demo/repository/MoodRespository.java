package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Mood;

public interface MoodRespository extends CrudRepository<Mood, Long>{

}

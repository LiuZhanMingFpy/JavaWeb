package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Mood;

public interface MoodService {

	void savaMood(Mood mood);

	List<Mood> findAllMood();

	void deleteMoodById(Long id);

}

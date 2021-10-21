package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.example.demo.domain.Mood;
import com.example.demo.repository.MoodRespository;
import com.example.demo.service.MoodService;
@Component
public class MoodServiceImpl implements MoodService{
	@Autowired
	private MoodRespository moodRespository;
	@Override
	public void savaMood(Mood mood) {
		// TODO Auto-generated method stub
		moodRespository.save(mood);
	}
	@Override
	public List<Mood> findAllMood(){
	Iterable<Mood> moods = moodRespository.findAll();
	return (List<Mood>)moods;
}
	@Override
	public void deleteMoodById(Long id) {
		// TODO Auto-generated method stub
		moodRespository.deleteById(id);
	}
}

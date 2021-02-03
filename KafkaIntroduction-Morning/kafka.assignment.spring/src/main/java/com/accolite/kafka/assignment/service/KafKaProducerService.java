package com.accolite.kafka.assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.accolite.kafka.assignment.model.Rank;
import com.accolite.kafka.assignment.model.Student;
import com.accolite.kafka.assignment.model.Teacher;

@Service
public class KafKaProducerService 
{
	private static final Logger log = 
			LoggerFactory.getLogger(KafKaProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;


	public Student sendStudentDetails(Student student) {
		log.info("Student details sent");
		this.kafkaTemplate.send("StudentTopic", student);
		return student;
	}
	
	public Teacher sendTeacherDetails(Teacher teacher) {
		log.info("Teacher details sent");
		this.kafkaTemplate.send("TeacherTopic", teacher);
		return teacher;
	}

	
	public Rank sendRankDetails(Rank rank) {
		log.info("Rank details sent");
		this.kafkaTemplate.send("RankTopic", rank);
		return rank;
	}

	
	
	
	
}

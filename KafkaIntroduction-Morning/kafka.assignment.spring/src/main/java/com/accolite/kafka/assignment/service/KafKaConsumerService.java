package com.accolite.kafka.assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.accolite.kafka.assignment.model.Rank;
import com.accolite.kafka.assignment.model.Student;
import com.accolite.kafka.assignment.model.Teacher;
//import com.accolite.kafka.assignment.repository.StudentRepository;


@Service
public class KafKaConsumerService 
{
	private final Logger log 
		= LoggerFactory.getLogger(KafKaConsumerService.class);
	
	
	Integer rankno = 0;
//	@Autowired
//	StudentRepository studentRepository;

	@KafkaListener(topics = "StudentTopic", groupId = "group_id")
	public void consume(Student student) {
		//studentRepository.save(student);
		log.info("Student data Received");
		log.info("Student Id : "+  student.getId());
		log.info("Student Name :  "+ student.getName());
		log.info("Student Subject :  "+ student.getSubject());
		
	}

	@KafkaListener(topics = "TeacherTopic", groupId = "group_id")
	public void consume(Teacher teacher) {
		//kasfkaStudentRepository.save(student);
		log.info("Teacher data Received");
		log.info("Teacher Id : "+ teacher.getId());
		log.info("Teacher Name :  "+ teacher.getName());
		log.info("Teacher Subject :  "+ teacher.getSubject());
		
	}

	@KafkaListener(topics = "RankTopic", groupId = "group_id")
	public void consume(Rank rank) {
		//kasfkaStudentRepository.save(student);
		rankno++;
		log.info("Rank data Received");
		log.info("Rank : "+ rankno);
		log.info("Student Id :  "+ rank.getId());
		log.info("Student Name : "+ rank.getName());
		log.info("Date Submitted : "+ rank.getDate());
		
		
	}


	
	
	
}

package com.accolite.kafka.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.kafka.assignment.model.Rank;
import com.accolite.kafka.assignment.model.Student;
import com.accolite.kafka.assignment.model.Teacher;
import com.accolite.kafka.assignment.service.KafKaProducerService;

@RestController
@RequestMapping("/school")
public class KafkaProducerController {
	
	@Autowired
	KafKaProducerService producerService;
	
	
	@PostMapping("/student")
    public Student sendStudent(@RequestBody Student student) {
       
        return producerService.sendStudentDetails(student);
    }


	
	@PostMapping("/teacher")
    public Teacher sendTeacher(@RequestBody Teacher teacher) {
       
        return producerService.sendTeacherDetails(teacher);
    }

	@PostMapping("/rank")
    public Rank sendRank(@RequestBody Rank rank) {
       
        return producerService.sendRankDetails(rank);
    }

	
	
}
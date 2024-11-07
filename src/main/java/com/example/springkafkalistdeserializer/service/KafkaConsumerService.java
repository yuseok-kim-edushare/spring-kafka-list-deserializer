package com.example.springkafkalistdeserializer.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.springkafkalistdeserializer.model.User;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(List<User> users) {

		if (users.isEmpty()) {
			System.out.println("No users found");
		} else {
			users.forEach(System.out::println);
		}

	}
}

package com.example.springkafkalistdeserializer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springkafkalistdeserializer.deserializer.ListDeserializer;

@EnableKafka
@Configuration
public class KafkaConfig {

	@Value("${spring.kafka.consumer.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;


	@Bean
	public ConsumerFactory<String, List<Object>> consumerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class.getName());
		config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, ListDeserializer.class.getName());

		return new DefaultKafkaConsumerFactory<>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, List<Object>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, List<Object>> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
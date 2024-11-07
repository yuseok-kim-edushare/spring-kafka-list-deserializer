package com.example.springkafkalistdeserializer.deserializer;

import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// build gradle에 이거 추가하셔야 해요
// implementation 'com.fasterxml.jackson.core:jackson-databind'

import java.util.List;
import java.util.Map;

public class ListDeserializer<T> implements Deserializer<List<T>> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// nothing to configure
	}

	@Override
	public List<T> deserialize(String topic, byte[] data) {
		if (data == null) {
			return null;
		}

		try {
			return objectMapper.readValue(data, new TypeReference<List<T>>() {});
		} catch (Exception e) {
			throw new RuntimeException("Failed to deserialize list", e);
		}
	}

	@Override
	public void close() {
		// nothing to close
	}
}
# spring kafka list deserializer
 simple example spring kafka list deserializer
### this project is a simple example of how to use a custom deserializer to deserialize a list of objects from a kafka topic

### project structure
```
spring-kafka-list-deserializer
│
└── src
    └── main
        └── java
           └── com
             └── example
                 └── springkafkalistdeserializer
                        ├── SpringKafkaListDeserializerApplication.java
                        ├── config
                        │   └── KafkaConfig.java
                        ├── deserializer
                        │   └── CustomListDeserializer.java
                        ├── model
                        │   └── User.java
                        └── service
                            └── KafkaConsumerService.java
```
### dependencies
on java 21 and spring boot 3.3.5 based

- spring-boot-starter spring kafka
- fasterxml.jackson.core jackson-databind

package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.entity.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class HelloWorld {

    @Value("${cloudtrain.config.stringValue:???cloudtrain.config.stringValue???}")
    private String stringConfigValue;

    @Value("${cloudtrain.config.numericValue:-1}")
    private int numericConfigValue;

    public Message getHelloMessage() {
        Message result = new Message(UUID.randomUUID());
        result.setCode("hello");
        result.setText("Welcome to Cloud Native Java with Spring Boot!");
        result.setStringConfigValue(this.stringConfigValue);
        result.setNumericConfigValue(this.numericConfigValue);
        result.setLocale(Locale.ENGLISH);
        return result;
    }
}

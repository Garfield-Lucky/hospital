package org.wu.work.util;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class FooMessageListener implements MessageListener {

    public void onMessage(Message message) {
        String messageBody = new String(message.getBody());
        System.out.println(" [x] Received '" + messageBody + "'");
    }
}
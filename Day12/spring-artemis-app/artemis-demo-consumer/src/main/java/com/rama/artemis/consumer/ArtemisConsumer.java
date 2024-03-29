package com.rama.artemis.consumer;

import com.rama.artemis.model.User;
import com.rama.artemis.producer.ArtemisProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {
    @Autowired
    ArtemisProducer producer;

    @JmsListener(destination = "${jms.out.queue.destination}")
    public void receive(String msg){
        System.out.println("Consumer Got Message: " + msg);
        producer.send("Consumer send back:"+msg);
    }

    @JmsListener(destination = "${jms.user.queue.destination}")
    public void receiveUser(User user){
        System.out.println("Consumer Got Message: Id: " + user.getId()+" Name:"+user.getName());
    }

}


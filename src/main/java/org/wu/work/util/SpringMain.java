package org.wu.work.util;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMain {
    public static void main(final String... args) throws Exception {

        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        template.convertAndSend("Hello, world!");
//        Thread.sleep(1000);
//        ctx.destroy();
    }
}
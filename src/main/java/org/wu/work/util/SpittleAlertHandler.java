package org.wu.work.util;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by Administrator on 2016/11/18.
 */
public class SpittleAlertHandler implements MessageListener {
    public void onMessage(Message message) {
        try {
            String body=new String(message.getBody(),"UTF-8");
            System.out.println(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
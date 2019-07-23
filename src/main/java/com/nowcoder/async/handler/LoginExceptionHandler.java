package com.nowcoder.async.handler;

import com.nowcoder.async.EventHandler;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventType;
import com.nowcoder.model.Message;
import com.nowcoder.service.MessageService;
import com.nowcoder.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LoginExceptionHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    MailSender mailSender;

    @Override
    public void doHandle(EventModel model) {
        //判断是否有异常登录
        Message message = new Message();
        message.setToId(model.getActorId());
        message.setContent("你上次的登录异常");
        message.setFromId(3);
        message.setCreatedDate(new Date());
        message.setConversationId(3 < model.getActorId() ? String.format("%d_%d", 3, model.getActorId()) : String.format("%d_%d", model.getActorId(), 3));
        messageService.addMessage(message);

        /*Map<String,Object> map = new HashMap<>();
        map.put("username",model.getExt("username"));
        mailSender.sendWithHTMLTemplate(model.getExt("email"),"登录异常","mails/welcome.html",map);*/
    }

    @Override
    public List<EventType> getSupportEventType() {
        return Arrays.asList(EventType.LOGIN);
    }
}

package org.starichkov.java.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.starichkov.java.spring.jms.SenderConfigurationJMS;

/**
 * @author Vadim Starichkov
 * @since 27.12.2016 17:19
 */
@RestController
public class SenderRestController {
    private SenderConfigurationJMS jms;

    @Autowired
    public void setJms(SenderConfigurationJMS jms) {
        this.jms = jms;
    }

    @RequestMapping(value = "/topic", method = RequestMethod.POST)
    public void sendTopic() {
        jms.sendTopic();
    }

    @RequestMapping(value = "/queue", method = RequestMethod.POST)
    public void sendQueue() {
        jms.sendQueue();
    }
}

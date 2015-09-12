package com.joshlong.spring.walkingtour.services.messaging.jms;


import java.math.BigInteger;
import java.util.Date;

import javax.jms.Message;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.TaskScheduler;

import com.joshlong.spring.walkingtour.services.model.Customer;

// TODO make sure that you have ActiveMQ or HornetQ up and running!
public class Main {
    public static void main(String[] args) throws Exception {

        Log log = LogFactory.getLog(Main.class);

        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JmsConfiguration.class);
        applicationContext.registerShutdownHook();


        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);

        Customer customer = new Customer("Mario", "Gray");

        String destinationName = "customers";

        jmsTemplate.convertAndSend(destinationName, customer);
        jmsTemplate.convertAndSend(destinationName, customer); // weve sent the same message, twice

        Customer ogCustomer = (Customer) jmsTemplate.receiveAndConvert(destinationName);
        log.info("converted message: " + ToStringBuilder.reflectionToString(ogCustomer));

        Message m = jmsTemplate.receive(destinationName);
        //Assert.isInstanceOf(ActiveMQObjectMessage.class, m);
        //ActiveMQObjectMessage message = (ActiveMQObjectMessage) m;
        log.info("unconverted message: " + m);


        final DefaultMessageListenerContainer jmsMessageListenerContainer = applicationContext.getBean(DefaultMessageListenerContainer.class);
        final TaskScheduler taskScheduler = applicationContext.getBean(TaskScheduler.class);
        Runnable goodbyeCruelWorld = new Runnable() {
            @Override
            public void run() {
                System.out.println("shutting down!");
                System.exit(0);            }
        };
        final Date dateToStopTheMessageListenerContainer = DateUtils.addSeconds(new Date(System.currentTimeMillis()), 10);
        taskScheduler.schedule(goodbyeCruelWorld, dateToStopTheMessageListenerContainer);

        for (long i = 0; i < 10; i++)
            jmsTemplate.convertAndSend(destinationName, new Customer(BigInteger.valueOf(i), "First" + i, "Last" + i));

        jmsMessageListenerContainer.start();
    }
}

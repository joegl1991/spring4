package com.joshlong.spring.walkingtour.services.messaging.jms;

import java.math.BigInteger;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.joshlong.spring.walkingtour.services.model.Customer;

public class CustomerConverter implements MessageConverter {

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {

		Customer customer = (Customer) object;
		  MapMessage message = session.createMapMessage();
		  //message.setString("id", customer.getId().toString());
		  message.setString("firstName", customer.getFirstName());
		  message.setString("lastName", customer.getLastName());
		  return message;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		MapMessage mapMessage = (MapMessage) message;
		Customer customer = new Customer();
		//customer.setId(new BigInteger(mapMessage.getString("id")));
		customer.setFirstName(mapMessage.getString("firstName"));
		customer.setLastName(mapMessage.getString("lastName"));
		return customer;
	}

}

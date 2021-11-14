/**
 * 
 */
package com.springcavaj.rabbitmq.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.springcavaj.rabbitmq.exception.RabbitMQException;
import com.springcavaj.rabbitmq.model.Car;

import io.micrometer.core.lang.NonNull;

/**
 * @author springcavaj
 *
 */
@Component
@RabbitListener(queues = "${rabbit.mq.queue.name}")
public class RabbitMQConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
    @RabbitHandler
    public void receiveMessage(@NonNull Car car, Channel channel, Message message) throws IOException {
    	try {
			if(null != car) {
				LOGGER.info("Message payload : {}", car.toString());
				LOGGER.info("Car Name : {}", car.getCarName());
				LOGGER.info("Car Model Name : {}", car.getModelName());
				LOGGER.info("Car Model No : {}", car.getCarModelNo());
				LOGGER.info("Car Type : {}", car.getTypeOfCar());
				LOGGER.info("Car Manufacture Date : {}", car.getDateOfManufacture());
			}
    	} catch(Exception e) {
    		LOGGER.info("Message Delivery Sequence Number : {}", message.getMessageProperties().getDeliveryTag());
    		channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
    		throw new RabbitMQException("Car object as consumed from Queue is null");
    	} finally {
            LOGGER.info("Message Delivery Sequence Number : {}", message.getMessageProperties().getDeliveryTag());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }

}

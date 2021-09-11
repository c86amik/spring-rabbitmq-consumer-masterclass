/**
 * 
 */
package com.springcavaj.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
    public void receiveMessage(@NonNull Car car) {
    	if(null != car) {
    		LOGGER.info("Message payload : {}", car.toString());
    		LOGGER.info("Car Name : {}", car.getCarName());
    		LOGGER.info("Car Model Name : {}", car.getModelName());
    		LOGGER.info("Car Model No : {}", car.getCarModelNo());
    		LOGGER.info("Car Type : {}", car.getTypeOfCar());
    		LOGGER.info("Car Manufacture Date : {}", car.getDateOfManufacture());
    	} else {
    		throw new RabbitMQException("Car object as consumed from Queue is null");
		}
    }

}

package com.ncgroup2.eventmanager;

import com.ncgroup2.eventmanager.model.Customer;
import com.ncgroup2.eventmanager.service.CustomerService;
import com.ncgroup2.eventmanager.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@SpringBootApplication
//("com.ncgroup2.eventmanager.service.impl", "com.ncgroup2.eventmanager.dao.impl")
@Configuration

@ComponentScan(

		"com.ncgroup2.eventmanager.service.impl," +
				" com.ncgroup2.eventmanager.dao.impl")

public class EventmanagerApplication {

	@Autowired
	CustomerServiceImpl customerService;

	public static void main(String[] args) {

		Random r = new Random(1000);

		ApplicationContext context = SpringApplication.run(EventmanagerApplication.class, args);

		CustomerService cusService = context.getBean(CustomerService.class);

		Customer customer1 = new Customer();
		customer1.setId(r.nextInt());
		customer1.setLogin("myName"+Integer.toString(r.nextInt()));
		customer1.setPassword("mySecondName"+Integer.toString(r.nextInt()));

		cusService.insert(customer1);

		Customer customer2 = cusService.getCustomerById(111);
		System.out.println(customer2.getLogin());

	}
}

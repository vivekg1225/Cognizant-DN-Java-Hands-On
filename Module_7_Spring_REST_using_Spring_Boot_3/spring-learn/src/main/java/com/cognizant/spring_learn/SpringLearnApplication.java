package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		System.out.println("Application Starting...");

		SpringApplication.run(SpringLearnApplication.class, args);

		System.out.println("Application Started Successfully");

		displayDate();
	}

	public static void displayDate() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

			SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

			Date date = format.parse("31/12/2018");

			System.out.println(date);
		} catch(ParseException e){
			e.printStackTrace();
		}
	}

}

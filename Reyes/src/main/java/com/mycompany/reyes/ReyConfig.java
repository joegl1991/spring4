package com.mycompany.reyes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReyConfig {

	@Bean
	public Rey getRey(){
		return new ReyBravo(getAventura());
	}
	
	@Bean
	public Aventura getAventura(){
		return new MatarDragonAventura(System.out);
	}
}

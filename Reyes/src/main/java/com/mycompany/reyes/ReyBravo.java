package com.mycompany.reyes;

/**
 * 
 * @author Celeritech Peru
 * version: desacoplada
 */
public class ReyBravo implements Rey {

	private Aventura aventura;
	
	public ReyBravo(Aventura aventura){
		this.aventura = aventura;
	}
	
	@Override
	public void embarcarEnAventura() {
		aventura.embarcar();

	}

}

package com.mycompany.reyes;

/**
 * 
 * @author Celeritech Peru
 * version: acoplada
 */
public class ReyArturo implements Rey {

	private RescatarPrincesaAventura aventura;
	
	public ReyArturo(){
		this.aventura = new RescatarPrincesaAventura();
	}
	
	@Override
	public void embarcarEnAventura() {
		aventura.embarcar();

	}

}

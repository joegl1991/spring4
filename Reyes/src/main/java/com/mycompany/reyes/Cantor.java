package com.mycompany.reyes;

import java.io.PrintStream;

public class Cantor {

	private PrintStream stream;
	
	public Cantor(PrintStream stream){
		this.stream = stream;
	}
	
	public void cantarAntesAventura(){
		stream.println("Buena suerte Rey lalala");
	}
	
	public void cantarDespuesAventura(){
		stream.println("Llego victorioso nuestro Rey lalalala");
	}
	
}

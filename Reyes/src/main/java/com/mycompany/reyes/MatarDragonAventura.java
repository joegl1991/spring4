package com.mycompany.reyes;

import java.io.PrintStream;

public class MatarDragonAventura implements Aventura {

	private PrintStream stream;
	
	public MatarDragonAventura(PrintStream stream){
		this.stream = stream;
	}
	
	@Override
	public void embarcar() {
		stream.println("Embarcandome en la aventura"
				+ " para matar al dragón.");

	}

}

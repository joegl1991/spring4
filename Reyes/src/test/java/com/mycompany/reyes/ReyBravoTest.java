package com.mycompany.reyes;


import org.junit.Test;
import static org.mockito.Mockito.*;

public class ReyBravoTest {

	@Test
	public void test() {
		Aventura aventuraFalsa =
				mock(Aventura.class);
		ReyBravo rey = new ReyBravo(aventuraFalsa);
		rey.embarcarEnAventura();
		verify(aventuraFalsa, times(1)).embarcar();
	}

}

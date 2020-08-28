package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
	private CalculadorDescuentos calcular = new CalculadorDescuentos();
	/**
	calcular la tarifa de cada billete según el trayecto, la antelación
	en la que se obtiene el billete y la edad del pasajero, de acuerdo
	con la normativa 005.
	@param tarifaBase valor base del vuelo
	@param diasAntelacion dias de antelación del vuelo
	@param edad - edad del pasajero
	@throws ExcepcionParametrosInvalidos [XXXXXXXXXXXXXXXXXXXXXXXXXXX]
	**/
	/**public long calculoTarifa(long tarifaBase, int diasAntelacion, int edad)
	*/

	@Test
    	public void deberiaValidTarifa() {
        	Assert.assertEquals(2500.0, (calcular.calculoTarifa(2500,3,22)),0.0);
        	Assert.assertEquals(2125.0, (calcular.calculoTarifa(2500,25,18)),0.0);
        	Assert.assertEquals(2375.0, (calcular.calculoTarifa(2500,0,8)),0.0);
		Assert.assertEquals(2300.0, (calcular.calculoTarifa(2500,0,67)),0.0);
		Assert.assertEquals(2000.0, (calcular.calculoTarifa(2500,21,8)),0.0);
		Assert.assertEquals(1925.0, (calcular.calculoTarifa(2500,22,67)),0.0);

        	//Excepción edad.
        	Assert.assertEquals(2375.0, (calcular.calculoTarifa(2500,3,-5)),0.0);
    	}
   
}
package psa;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TicketsExternosSteps {

    private FachadaSistema sistema;
    private int clienteId;
    private boolean resultadoExitoso;

    @Dado("^que existe el cliente \"(.*?)\" con numero de telefono \"(.*?)\"$")
    public void que_existe_un_cliente_con_contacto(String nombre, String contacto) throws Throwable {
        this.sistema = new FachadaSistema();
        this.clienteId = this.sistema.crearCliente(nombre, contacto);
    }

    @Cuando("^carga el ticket \"(.+?)\"$")
    public void cuando_carga_el_ticket(String descripcion) throws Throwable {
    	this.resultadoExitoso = this.sistema.crearTicketExterno(descripcion, this.clienteId);
    }

    @Entonces("^se crea el ticket cuyo reportante es \"(.+?)\" y cuya descripcion es \"(.+?)\"$")
    public void se_crea_el_ticket_del_cliente_con_descripcion(String nombre,String descripcion) throws Throwable {
        assertTrue(this.resultadoExitoso);
    	assertEquals(nombre, this.sistema.buscarClientePorId(this.clienteId).getNombre());
        assertEquals(descripcion, this.sistema.buscarTicketExternoClientePorId(this.clienteId).getDescripcion());
    }

}

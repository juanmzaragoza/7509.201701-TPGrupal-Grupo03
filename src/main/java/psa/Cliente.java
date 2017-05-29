package psa;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nombre;
	private String contacto;
	private List<TicketExterno> tickets;
	
	public Cliente(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.tickets = new ArrayList<TicketExterno>();
    }

	public TicketExterno crearTicket(String descripcion) {
		TicketExterno ticket = new TicketExterno(descripcion,this);
		this.tickets.add(ticket);
		return ticket;
	}

	public String getNombre() {
		return this.nombre;
	}

	public TicketExterno getTicketPorDescripcion(String descripcion) {
		
		for(TicketExterno ticket: this.tickets){
			if(ticket.getDescripcion().equals(descripcion)){
				return ticket;
			}
		}
		
		throw new NoExisteTicketException();
		
	}
	
	
}

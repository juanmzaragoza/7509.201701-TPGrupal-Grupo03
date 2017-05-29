package psa;

import java.util.ArrayList;
import java.util.List;

public class FachadaSistema {

	List<Cliente> clientes;
	List<TicketExterno> ticketsExternos;
	
	public FachadaSistema() {
		this.clientes = new ArrayList<Cliente>();
		this.ticketsExternos = new ArrayList<TicketExterno>();
	}
	
	public int crearCliente(String nombre, String contacto){
		Cliente cliente = new Cliente(nombre,contacto);
		this.clientes.add(cliente);
		return cliente.getId();
	}
	
	public boolean crearTicketExterno(String descripcion, int clienteId){
		try{
			Cliente cliente = this.buscarClientePorId(clienteId);
			this.ticketsExternos.add(new TicketExterno(descripcion,cliente));
		}catch(Exception e){
			return false;
		}
		return true;
		
	}
	
	public Cliente buscarClientePorId(int clienteId){
		for(Cliente cliente: this.clientes){
			if(cliente.getId() == clienteId){
				return cliente;
			}
		}
		throw new ClienteInexistenteException();
	}
	
	public TicketExterno buscarTicketExternoClientePorId(int clienteId){
		for(TicketExterno ticket: this.ticketsExternos){
			if(ticket.getReportante().getId() == clienteId){
				return ticket;
			}
		}
		throw new NoExisteTicketException();
	}
}

package psa;

import java.util.ArrayList;
import java.util.List;

import psa.excepciones.NoExisteEmpleadoException;
import psa.excepciones.NoExisteTareaException;
import psa.excepciones.NoExisteTicketException;

public class FachadaSistema {
	
	private List<Cliente> clientes;
	private List<TicketExterno> ticketsExternos;
	private List<Empleado> empleados;
	private List<Tarea> tareas;
	
	public FachadaSistema() {
		this.clientes = new ArrayList<Cliente>();
		this.ticketsExternos = new ArrayList<TicketExterno>();
		this.empleados = new ArrayList<Empleado>();
		this.tareas = new ArrayList<Tarea>();
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

	public void crearEmpleado(String empleadoNombre) {
		this.empleados.add(new Empleado(empleadoNombre));
	}
	
	public void crearTarea(String nombreTarea) {
		this.tareas.add(new Tarea(nombreTarea));	
	}

	public boolean asignarEmpleadoaTarea(String nombreEmpleado, String nombreTarea) {
		
		try{
			Tarea tarea = this.obtenerTarea(nombreTarea);
			Empleado empleado = this.obtenerEmpleado(nombreEmpleado);
			
			tarea.asignarEmpleado(empleado);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	public boolean estaEmpleadoTrabajandoEnTarea(String nombreEmpleado, String tareaNombre) {
		try{
			Tarea tarea = this.obtenerTarea(tareaNombre);
			Empleado empleado = this.obtenerEmpleado(nombreEmpleado);
			
			return tarea.estaTrabajando(empleado) && empleado.estaAsignadoA(tarea);
		}catch(Exception e){
			return false;
		}
	}
	
	private Empleado obtenerEmpleado(String nombreEmpleado) {
		for(Empleado empleado: this.empleados){
			if(empleado.getNombre().equals(nombreEmpleado)){
				return empleado;
			}
		}
		throw new NoExisteEmpleadoException();
	}
	
	private Tarea obtenerTarea(String nombreTarea) {
		for(Tarea tarea: this.tareas){
			if(tarea.getNombre().equals(nombreTarea)){
				return tarea;
			}
		}
		throw new NoExisteTareaException();
	}

	
}

package psa;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AsignarEmpleado {
	
	private FachadaSistema sistema;
	private String nombreEmpleado;
	private boolean resultadoExitoso;
	
	private final String proyecto = "PSA New Sprintg v1.0.2";
	private final String requerimiento = "Pruebas no funcionales";
	
	@Dado("^que existe el empleado \"(.*?)\"$")
	public void que_existe_el_empleado(String empleadoNombre) throws Throwable {
		sistema = new FachadaSistema();
		sistema.crearEmpleado(empleadoNombre);
		
		nombreEmpleado = empleadoNombre;
	}

	@Cuando("^quiero asignarlo a la tarea \"(.*?)\"$")
	public void quiero_asignarlo_a_la_tarea_que_es_parte_del_requerimiento_del_proyecto(String nombreTarea) throws Throwable {
		sistema.crearTarea(nombreTarea);
		resultadoExitoso = sistema.asignarEmpleadoaTarea(nombreEmpleado,nombreTarea);
	}

	@Entonces("^aparecerá asignado a la tarea \"(.*?)\"$")
	public void aparecera_asignado_al_proyecto(String tareaNombre) throws Throwable {
		assertTrue(resultadoExitoso);
		assertTrue(sistema.estaEmpleadoTrabajandoEnTarea(nombreEmpleado, tareaNombre));
	}

}

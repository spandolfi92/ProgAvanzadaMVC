package edu.usal.controlador.grafica;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Ventas;
import edu.usal.negocio.dominio.Vuelos;

public class ControladorVenta {
	
	private static AerolineaDAO aerolineaDAO;
	private static VueloDAO vueloDAO;
	private static VentaDAO ventaDAO;
	private static ClienteDAO clienteDAO;
	
	
	public ControladorVenta(AerolineaDAO aerolineaDAO, VueloDAO vueloDAO, VentaDAO ventaDAO, ClienteDAO clienteDAO) {
		
		this.aerolineaDAO = aerolineaDAO;
		this.vueloDAO = vueloDAO;
		this.ventaDAO = ventaDAO;
		this.clienteDAO = clienteDAO;
	}

	public static AerolineaDAO getAerolineaDAO() {
		return aerolineaDAO;
	}


	public static void setAerolineaDAO(AerolineaDAO aerolineaDAO) {
		ControladorVenta.aerolineaDAO = aerolineaDAO;
	}


	public static VueloDAO getVueloDAO() {
		return vueloDAO;
	}


	public static void setVueloDAO(VueloDAO vueloDAO) {
		ControladorVenta.vueloDAO = vueloDAO;
	}


	public static VentaDAO getVentaDAO() {
		return ventaDAO;
	}


	public static void setVentaDAO(VentaDAO ventaDAO) {
		ControladorVenta.ventaDAO = ventaDAO;
	}


	public static ClienteDAO getClienteDAO() {
		return clienteDAO;
	}


	public static void setClienteDAO(ClienteDAO clienteDAO) {
		ControladorVenta.clienteDAO = clienteDAO;
	}
	
	public List<Aerolinea> listarAerolineas() {
		return aerolineaDAO.listarAerolineas();
	}
	
	public List<Vuelos> listarVuelos() {
		return vueloDAO.listarVuelos();
	}
	
	public List<Cliente> listarClientes() {
		return clienteDAO.listarClientes();
	}
	
	public List<Ventas> listarVentas() {
		return ventaDAO.listarVentas();
	}
	
	public static void altaVenta(Ventas venta) throws Exception{
		// Validar que la fecha de emisión del pasaporte sea anterior a la fecha de la venta
		if(venta.getFechaVenta().before(venta.getCliente().getPasaporte().getFechaEmision())) {
			throw new Exception("La fecha de emisión del pasaporte debe ser anterior a la fecha de la venta");
		}
		
		// Validar que la fecha de vencimiento del pasaporte sea 6 meses posterior a la fecha de finalización del vuelo
		Calendar cal = Calendar.getInstance();
		cal.setTime(venta.getVuelo().getFechaLlegada());
		cal.add(Calendar.MONTH, 6);
		Date nuevaFecha = cal.getTime();
		if(venta.getCliente().getPasaporte().getFechaVencimiento().before(nuevaFecha)) {
			throw new Exception("La fecha de vencimiento del pasaporte debe ser 6 meses posterior a la finalización del vuelo");
		}
		
		// Validar que el cliente tenga más de 18 años
		Calendar fechaVuelo = Calendar.getInstance();
		fechaVuelo.setTime(venta.getVuelo().getFechaSalida());
		
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.setTime(venta.getCliente().getFechaNacimiento());
		
		int diferenciaFechas = fechaVuelo.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		if(diferenciaFechas < 18)
			throw new Exception("El cliente debe ser mayor de 18 años");
		
		// Validar si hay asientos disponibles
		if(venta.getVuelo().getCantidadAsientos() < 1) {
			throw new Exception("No hay asientos disponibles para el vuelo seleccionado");
		}
		
		// Actualizar cantidad de asientos
		venta.getVuelo().setCantidadAsientos(venta.getVuelo().getCantidadAsientos() -1);;
		vueloDAO.modificarVuelo(venta.getVuelo());
				
		ventaDAO.altaVenta(venta);
	}
	
	public static void modificarVenta(Ventas venta) throws Exception{
		// Validar que la fecha de emisión del pasaporte sea anterior a la fecha de la venta
		if(venta.getFechaVenta().before(venta.getCliente().getPasaporte().getFechaEmision())) {
			throw new Exception("La fecha de emisión del pasaporte debe ser anterior a la fecha de la venta");
		}
		
		// Validar que la fecha de vencimiento del pasaporte sea 6 meses posterior a la fecha de finalización del vuelo
		Calendar cal = Calendar.getInstance();
		cal.setTime(venta.getVuelo().getFechaLlegada());
		cal.add(Calendar.MONTH, 6);
		Date nuevaFecha = cal.getTime();
		if(venta.getCliente().getPasaporte().getFechaVencimiento().before(nuevaFecha)) {
			throw new Exception("La fecha de vencimiento del pasaporte debe ser 6 meses posterior a la finalización del vuelo");
		}
		
		// Validar que el cliente tenga más de 18 años
		Calendar fechaVuelo = Calendar.getInstance();
		fechaVuelo.setTime(venta.getVuelo().getFechaSalida());
		
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.setTime(venta.getCliente().getFechaNacimiento());
		
		int diferenciaFechas = fechaVuelo.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		if(diferenciaFechas < 18)
			throw new Exception("El cliente debe ser mayor de 18 años");
		
		ventaDAO.modificarVenta(venta);
	}
	
	public void eliminarVenta(double id){
		ventaDAO.eliminarVenta(id);
	}

}

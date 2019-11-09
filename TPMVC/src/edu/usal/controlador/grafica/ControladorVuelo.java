package edu.usal.controlador.grafica;

import java.util.List;

import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Vuelos;

public class ControladorVuelo {
	
	private static AerolineaDAO aerolineaDAO;
	private static VueloDAO vueloDAO;
	private static AeropuertoDAO aeropuertoDAO;
	
	public ControladorVuelo(AerolineaDAO aerolineaDAO, VueloDAO vueloDAO, AeropuertoDAO aeropuertoDAO) {
		this.aerolineaDAO = aerolineaDAO;
		this.vueloDAO = vueloDAO;
		this.aeropuertoDAO = aeropuertoDAO;
	}

	public static AerolineaDAO getAerolineaDAO() {
		return aerolineaDAO;
	}

	public static void setAerolineaDAO(AerolineaDAO aerolineaDAO) {
		ControladorVuelo.aerolineaDAO = aerolineaDAO;
	}

	public static VueloDAO getVueloDAO() {
		return vueloDAO;
	}

	public static void setVueloDAO(VueloDAO vueloDAO) {
		ControladorVuelo.vueloDAO = vueloDAO;
	}

	public static AeropuertoDAO getAeropuertoDAO() {
		return aeropuertoDAO;
	}

	public static void setAeropuertoDAO(AeropuertoDAO aeropuertoDAO) {
		ControladorVuelo.aeropuertoDAO = aeropuertoDAO;
	}
	
	public List<Aerolinea> listarAerolineas() {
		return aerolineaDAO.listarAerolineas();
	}
	
	public List<Aeropuerto> listarAeropuertos() {
		return aeropuertoDAO.listarAeropuertos();
	}
	
	public List<Vuelos> listarVuelos() {
		return vueloDAO.listarVuelos();
	}
	
	public static void altaVuelo(Vuelos vuelo) throws Exception{
		vueloDAO.altaVuelo(vuelo);
	}
	
	public static void modificarVuelo(Vuelos vuelo) throws Exception{
		vueloDAO.modificarVuelo(vuelo);
	}
	
	public void eliminarVuelo(String codigo){
		vueloDAO.eliminarVuelo(codigo);
	}
	

}

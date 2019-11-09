package edu.usal.controlador.grafica;

import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.AlianzaDAO;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Alianza;

public class ControladorAerolinea {
	
	private static AerolineaDAO aerolineaDAO;
	private static AlianzaDAO alianzaDAO;
	
	public ControladorAerolinea(AerolineaDAO aerolineaDAO, AlianzaDAO alianzaDAO) {
		ControladorAerolinea.aerolineaDAO = aerolineaDAO;
		ControladorAerolinea.alianzaDAO = alianzaDAO;
	}
	
	public AerolineaDAO getAerolineaDAO() {
		return aerolineaDAO;
	}

	public void setAerolineaDAO(AerolineaDAO aerolineaDAO) {
		ControladorAerolinea.aerolineaDAO = aerolineaDAO;
	}

	public AlianzaDAO getAlianzaDAO() {
		return alianzaDAO;
	}

	public void setAlianzaDAO(AlianzaDAO alianzaDAO) {
		ControladorAerolinea.alianzaDAO = alianzaDAO;
	}

	public static List<Alianza> listarAlianzas() {
		try {
			return alianzaDAO.listarAlianzas();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Aerolinea> listarAerolineas() {
		return aerolineaDAO.listarAerolineas();
	}
	
	public static void altaAerolinea(Aerolinea aerolinea) throws Exception {
		if(aerolinea.getNombre().isEmpty() || aerolinea.getNombre() == null)
			throw new Exception("El nombre de la aerolínea no debe estar vacío");
		
		aerolineaDAO.altaAerolinea(aerolinea);
	}
	
	public void modificarAerolinea(Aerolinea aerolinea) throws Exception {
		if(aerolinea.getNombre().isEmpty() || aerolinea.getNombre() == null)
			throw new Exception("El nombre de la aerolínea no debe estar vacío");
		
		aerolineaDAO.modificarAerolinea(aerolinea);
	}
	
	public void eliminarAerolinea(double id){
		aerolineaDAO.eliminarAerolinea(id);
	}
	
	

}

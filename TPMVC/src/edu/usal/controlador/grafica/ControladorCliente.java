package edu.usal.controlador.grafica;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.AlianzaDAO;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.DireccionDAO;
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dao.interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Alianza;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;

public class ControladorCliente {
	
	private static ClienteDAO clienteDAO;
	private static PasaporteDAO pasaporteDAO;
	private static TelefonoDAO telefonoDAO;
	private static PasajeroFrecuenteDAO pasajeroFrecuenteDAO;
	private static DireccionDAO direccionDAO;
	private static PaisDAO paisDAO;
	private static AerolineaDAO aerolineaDAO;
	private static ProvinciaDAO provinciaDAO;
	private static AlianzaDAO alianzaDAO;
	
	
	public ControladorCliente(ClienteDAO clienteDAO, PasaporteDAO pasaporteDAO, TelefonoDAO telefonoDAO,
			PasajeroFrecuenteDAO pasajeroFrecuenteDAO, DireccionDAO direccionDAO, PaisDAO paisDAO, AerolineaDAO aerolineaDAO,
			ProvinciaDAO provinciaDAO, AlianzaDAO alianzaDAO) {
		this.clienteDAO = clienteDAO;
		this.pasaporteDAO = pasaporteDAO;
		this.telefonoDAO = telefonoDAO;
		this.pasajeroFrecuenteDAO = pasajeroFrecuenteDAO;
		this.direccionDAO = direccionDAO;
		this.paisDAO = paisDAO;
		this.aerolineaDAO = aerolineaDAO;
		this.provinciaDAO = provinciaDAO;
		this.alianzaDAO = alianzaDAO;
	}

	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public PasaporteDAO getPasaporteDAO() {
		return pasaporteDAO;
	}

	public void setPasaporteDAO(PasaporteDAO pasaporteDAO) {
		this.pasaporteDAO = pasaporteDAO;
	}

	public TelefonoDAO getTelefonoDAO() {
		return telefonoDAO;
	}

	public void setTelefonoDAO(TelefonoDAO telefonoDAO) {
		this.telefonoDAO = telefonoDAO;
	}

	public PasajeroFrecuenteDAO getPasajeroFrecuenteDAO() {
		return pasajeroFrecuenteDAO;
	}

	public void setPasajeroFrecuenteDAO(PasajeroFrecuenteDAO pasajeroFrecuenteDAO) {
		this.pasajeroFrecuenteDAO = pasajeroFrecuenteDAO;
	}
	
	

	public static AlianzaDAO getAlianzaDAO() {
		return alianzaDAO;
	}


	public static void setAlianzaDAO(AlianzaDAO alianzaDAO) {
		ControladorCliente.alianzaDAO = alianzaDAO;
	}


	public DireccionDAO getDireccionDAO() {
		return direccionDAO;
	}

	public void setDireccionDAO(DireccionDAO direccionDAO) {
		this.direccionDAO = direccionDAO;
	}
	
	public PaisDAO getPaisDAO() {
		return paisDAO;
	}

	public void setPaisDAO(PaisDAO paisDAO) {
		this.paisDAO = paisDAO;
	}

	public AerolineaDAO getAerolineaDAO() {
		return aerolineaDAO;
	}

	public void setAerolineaDAO(AerolineaDAO aerolineaDAO) {
		this.aerolineaDAO = aerolineaDAO;
	}

	public ProvinciaDAO getProvinciaDAO() {
		return provinciaDAO;
	}

	public void setProvinciaDAO(ProvinciaDAO provinciaDAO) {
		this.provinciaDAO = provinciaDAO;
	}

	
	
	public List<Pais> obtenerPaises() {
		return paisDAO.listarPaises();
	}
	
	public List<Aerolinea> obtenerAerolineas() {
		return aerolineaDAO.listarAerolineas();
	}
	
	public List<Provincia> obtenerProvincias() {
		return provinciaDAO.listarProvincias();
		
	}
	
	public List<Cliente> listarClientes() {
		return clienteDAO.listarClientes();
		
	}
	
	public static List<Alianza> listarAlianzas() {
		try {
			return alianzaDAO.listarAlianzas();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void altaCliente(Cliente cliente, Pasaporte pasaporte, Telefono telefono, PasajeroFrecuente pasajeroFrecuente, Direccion direccion) throws Exception {
		//Validar que la categoría sea económica
		if(! (pasajeroFrecuente.getCategoria().equals("económica"))) {
			throw new Exception("La categoría debe ser siempre económica");
		}
		
		if(cliente.getNombre().isEmpty() || cliente.getNombre() == null)
			throw new Exception("El nombre del cliente no debe estar vacío");
		if(cliente.getApellido().isEmpty() || cliente.getApellido() == null)
			throw new Exception("El Apellido del cliente no debe estar vacío");
		if(cliente.getDni().isEmpty() || cliente.getDni() == null)
			throw new Exception("El DNI del cliente no debe estar vacío");
		if(cliente.getCuitCuil().isEmpty() || cliente.getCuitCuil() == null)
			throw new Exception("El cuit del cliente no debe estar vacío");
		if(cliente.getEmail().isEmpty() || cliente.getEmail() == null)
			throw new Exception("El Email del cliente no debe estar vacío");
		if(cliente.getFechaNacimiento() == null || cliente.getFechaNacimiento().equals("YYY-MM-DD"))
			throw new Exception("La fecha de nacimiento del cliente no debe estar vacía");
		if(pasaporte.getNumero().isEmpty() || pasaporte.getNumero() == null)
			throw new Exception("El número de pasaporte del cliente no debe estar vacío");
		if(pasaporte.getAutoridadEmision().isEmpty() || pasaporte.getAutoridadEmision() == null)
			throw new Exception("La autoridad de emisión del pasaporte del cliente no debe estar vacía");
		if(pasaporte.getFechaEmision() == null || pasaporte.getFechaEmision().equals("YYY-MM-DD"))
			throw new Exception("La fecha de emisión del pasaporte del cliente no debe estar vacía");
		if(pasaporte.getFechaVencimiento() == null || pasaporte.getFechaVencimiento().equals("YYY-MM-DD"))
			throw new Exception("La fecha de vencimiento del pasaporte del cliente no debe estar vacía");
		if(telefono.getNumeroCelular().isEmpty() || telefono.getNumeroCelular() == null)
			throw new Exception("El teléfono celular del cliente no debe estar vacío");
		if(telefono.getNumeroPersonal().isEmpty() || telefono.getNumeroPersonal() == null)
			throw new Exception("El teléfono personal del cliente no debe estar vacío");
		if(telefono.getNumeroLaboral().isEmpty() || telefono.getNumeroLaboral() == null)
			throw new Exception("El teléfono laboral del cliente no debe estar vacío");
		if(pasajeroFrecuente.getNumero().isEmpty() || pasajeroFrecuente.getNumero() == null)
			throw new Exception("El número de pasajero frecuente del cliente no debe estar vacío");
		if(pasajeroFrecuente.getCategoria().isEmpty() || pasajeroFrecuente.getCategoria() == null)
			throw new Exception("La categoría de pasajero frecuente del cliente no debe estar vacía");
		if(direccion.getCalle().isEmpty() || direccion.getCalle() == null)
			throw new Exception("La calle de la dirección del cliente no debe estar vacía");
		if(direccion.getAltura().isEmpty() || direccion.getAltura() == null)
			throw new Exception("La altura de la dirección del cliente no debe estar vacía");
		if(direccion.getCiudad().isEmpty() || direccion.getCiudad() == null)
			throw new Exception("La ciudad de la dirección del cliente no debe estar vacía");
		if(direccion.getCodigoPostal().isEmpty() || direccion.getCodigoPostal() == null)
			throw new Exception("El código postal de la dirección del cliente no debe estar vacío");
	
		
		Connection con = null;
		con = Connect.getConnection();
		
		try {
			con.setAutoCommit(false);
		
			double idCliente= clienteDAO.altaCliente(cliente);
			pasaporteDAO.altaPasaporte(pasaporte, idCliente);
			telefonoDAO.altaTelefono(telefono, idCliente);
			pasajeroFrecuenteDAO.altaPasajeroFrecuente(pasajeroFrecuente, idCliente);
			direccionDAO.altaDireccion(direccion, idCliente);
			
			con.commit();
		} catch(SQLException e) {
			con.rollback();
		}
	}
	
	public void eliminarCliente(Cliente cliente) throws SQLException{
		Connection con = null;
		con = Connect.getConnection();
		
		try {
			con.setAutoCommit(false);
		
			
			pasaporteDAO.eliminarPasaporte(cliente.getId());
			telefonoDAO.eliminarTelefono(cliente.getId());
			pasajeroFrecuenteDAO.eliminarPasajeroFrecuente(cliente.getId());
			direccionDAO.eliminarDireccion(cliente.getId());
			clienteDAO.eliminarCliente(cliente.getId());
			
			con.commit();
		} catch(SQLException e) {
			con.rollback();
		}
	}
	
	public static void modificarCliente(Cliente cliente, Pasaporte pasaporte, Telefono telefono, PasajeroFrecuente pasajeroFrecuente, Direccion direccion) throws Exception {
		//Validar que la categoría sea económica
		if(! (pasajeroFrecuente.getCategoria().equals("económica"))) {
			throw new Exception("La categoría debe ser siempre económica");
		}
		
		if(cliente.getNombre().isEmpty() || cliente.getNombre() == null)
			throw new Exception("El nombre del cliente no debe estar vacío");
		if(cliente.getApellido().isEmpty() || cliente.getApellido() == null)
			throw new Exception("El Apellido del cliente no debe estar vacío");
		if(cliente.getDni().isEmpty() || cliente.getDni() == null)
			throw new Exception("El DNI del cliente no debe estar vacío");
		if(cliente.getCuitCuil().isEmpty() || cliente.getCuitCuil() == null)
			throw new Exception("El cuit del cliente no debe estar vacío");
		if(cliente.getEmail().isEmpty() || cliente.getEmail() == null)
			throw new Exception("El Email del cliente no debe estar vacío");
		if(cliente.getFechaNacimiento() == null || cliente.getFechaNacimiento().equals("YYY-MM-DD"))
			throw new Exception("La fecha de nacimiento del cliente no debe estar vacía");
		if(pasaporte.getNumero().isEmpty() || pasaporte.getNumero() == null)
			throw new Exception("El número de pasaporte del cliente no debe estar vacío");
		if(pasaporte.getAutoridadEmision().isEmpty() || pasaporte.getAutoridadEmision() == null)
			throw new Exception("La autoridad de emisión del pasaporte del cliente no debe estar vacía");
		if(pasaporte.getFechaEmision() == null || pasaporte.getFechaEmision().equals("YYY-MM-DD"))
			throw new Exception("La fecha de emisión del pasaporte del cliente no debe estar vacía");
		if(pasaporte.getFechaVencimiento() == null || pasaporte.getFechaVencimiento().equals("YYY-MM-DD"))
			throw new Exception("La fecha de vencimiento del pasaporte del cliente no debe estar vacía");
		if(telefono.getNumeroCelular().isEmpty() || telefono.getNumeroCelular() == null)
			throw new Exception("El teléfono celular del cliente no debe estar vacío");
		if(telefono.getNumeroPersonal().isEmpty() || telefono.getNumeroPersonal() == null)
			throw new Exception("El teléfono personal del cliente no debe estar vacío");
		if(telefono.getNumeroLaboral().isEmpty() || telefono.getNumeroLaboral() == null)
			throw new Exception("El teléfono laboral del cliente no debe estar vacío");
		if(pasajeroFrecuente.getNumero().isEmpty() || pasajeroFrecuente.getNumero() == null)
			throw new Exception("El número de pasajero frecuente del cliente no debe estar vacío");
		if(pasajeroFrecuente.getCategoria().isEmpty() || pasajeroFrecuente.getCategoria() == null)
			throw new Exception("La categoría de pasajero frecuente del cliente no debe estar vacía");
		if(direccion.getCalle().isEmpty() || direccion.getCalle() == null)
			throw new Exception("La calle de la dirección del cliente no debe estar vacía");
		if(direccion.getAltura().isEmpty() || direccion.getAltura() == null)
			throw new Exception("La altura de la dirección del cliente no debe estar vacía");
		if(direccion.getCiudad().isEmpty() || direccion.getCiudad() == null)
			throw new Exception("La ciudad de la dirección del cliente no debe estar vacía");
		if(direccion.getCodigoPostal().isEmpty() || direccion.getCodigoPostal() == null)
			throw new Exception("El código postal de la dirección del cliente no debe estar vacío");
	
		
		Connection con = null;
		con = Connect.getConnection();
		
		try {
			con.setAutoCommit(false);
		
			pasaporteDAO.modificarPasaporte(pasaporte, cliente.getId());
			telefonoDAO.modificarTelefono(telefono, cliente.getId());
			pasajeroFrecuenteDAO.modificarPasajeroFrecuente(pasajeroFrecuente, cliente.getId());
			direccionDAO.modificarDireccion(direccion, cliente.getId());
			clienteDAO.modificarCliente(cliente);
			
			con.commit();
		} catch(SQLException e) {
			con.rollback();
		}
	}
	
	public Pais altaPais(String nombre) {
		
		return paisDAO.altaPais(nombre);
	}
	

}

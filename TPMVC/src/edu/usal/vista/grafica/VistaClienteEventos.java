package edu.usal.vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.usal.controlador.grafica.ControladorCliente;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Alianza;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;

public class VistaClienteEventos implements ActionListener{
	
	private VistaCliente vistaCliente;
	private ControladorCliente controladorCliente;
	
	
	public VistaClienteEventos(VistaCliente vistaCliente, ControladorCliente controladorCliente) {
		
		this.vistaCliente = vistaCliente;
		this.controladorCliente = controladorCliente;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(this.vistaCliente.getBtnAgregar())) {
			
			try {
				Cliente cliente = new Cliente();
				cliente.setNombre(vistaCliente.getTextFieldNombre().getText());
				cliente.setApellido(vistaCliente.getTextFieldApellido().getText());
				cliente.setDni(vistaCliente.getTextFieldDNI().getText());
				cliente.setCuitCuil(vistaCliente.getTextFieldCuitCuil().getText());
				String fechaNacimiento = vistaCliente.getTextFieldFechaNac().getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha;
				try {
					
					fecha = format.parse(fechaNacimiento);
					cliente.setFechaNacimiento(fecha);
				} catch (ParseException e2) {
					throw new Exception("Fecha de nacimiento incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				cliente.setEmail(vistaCliente.getTextFieldEmail().getText());
				
				Pasaporte pasaporte = new Pasaporte();
				pasaporte.setNumero(vistaCliente.getTextFieldNumeroPas().getText());
				pasaporte.setAutoridadEmision(vistaCliente.getTextFieldAutoridadEm().getText());
				String fechaEmision = vistaCliente.getTextFieldFechaEmision().getText();
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha2;
				try {
					fecha2 = format2.parse(fechaEmision);
					pasaporte.setFechaEmision(fecha2);
				} catch (ParseException e3) {
					throw new Exception("Fecha de emisión del pasaporte incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				String fechaVencimiento = vistaCliente.getTextFieldFechaVencimiento().getText();
				SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha3;
				try {
					fecha3 = format3.parse(fechaVencimiento);
					pasaporte.setFechaVencimiento(fecha3);
				} catch (ParseException e4) {
					throw new Exception("Fecha de vencimiento del pasaporte incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				Pais pais = new Pais();
				pais = (Pais) vistaCliente.getComboBoxPaisPasaporte().getSelectedItem();
				if(pais.getNombre().equals("Otro")) {
					pais= controladorCliente.altaPais(vistaCliente.getTextFieldNuevoPais().getText());
				}
				else {
					pais = (Pais) vistaCliente.getComboBoxPaisPasaporte().getSelectedItem();
				}
				pasaporte.setPais(pais);
				
				
				Telefono telefono = new Telefono();
				telefono.setNumeroCelular(vistaCliente.getTextFieldCelular().getText());
				telefono.setNumeroPersonal(vistaCliente.getTextFieldPersonal().getText());
				telefono.setNumeroLaboral(vistaCliente.getTextFieldLaboral().getText());
				
				
				PasajeroFrecuente pasajeroFrecuente = new PasajeroFrecuente();
				Alianza alianza = (Alianza) vistaCliente.getComboBoxAlianzaPasFrec().getSelectedItem();
				pasajeroFrecuente.setAlianza(alianza.getNombre());
				pasajeroFrecuente.setNumero(vistaCliente.getTextFieldNumeroPasajeroFrec().getText());
				pasajeroFrecuente.setCategoria(vistaCliente.getTextFieldCategoriaPasFrec().getText());
				Aerolinea aerolinea = (Aerolinea) vistaCliente.getComboBoxAerPasFrec().getSelectedItem();
				pasajeroFrecuente.setAerolinea(aerolinea);
				
				
				Direccion direccion = new Direccion();
				direccion.setCalle(vistaCliente.getTextFieldCalle().getText());
				direccion.setAltura(vistaCliente.getTextFieldAltura().getText());
				direccion.setCiudad(vistaCliente.getTextFieldCiudad().getText());
				direccion.setCodigoPostal(vistaCliente.getTextFieldCP().getText());
				Provincia provincia = (Provincia) vistaCliente.getComboBoxProvincia().getSelectedItem();
				direccion.setProvincia(provincia);
				Pais pais2 = new Pais();
				pais2 = (Pais) vistaCliente.getComboBoxPaisDirec().getSelectedItem();
				if(pais2.getNombre().equals("Otro")) {
					pais2= controladorCliente.altaPais(vistaCliente.getTextFieldNuevoPais2().getText());
				}
				else {
					pais2 = (Pais) vistaCliente.getComboBoxPaisDirec().getSelectedItem();
				}
				direccion.setPais(pais2);
								
				
				controladorCliente.altaCliente(cliente, pasaporte, telefono, pasajeroFrecuente, direccion);
				
				JOptionPane.showMessageDialog(null, "Cliente creado correctamente");
				vistaCliente.getTextFieldNombre().setText(null);
				vistaCliente.getTextFieldApellido().setText(null);
				vistaCliente.getTextFieldDNI().setText(null);
				vistaCliente.getTextFieldCuitCuil().setText(null);
				vistaCliente.getTextFieldEmail().setText(null);
				vistaCliente.getTextFieldFechaNac().setText("YYYY-MM-DD");
				vistaCliente.getTextFieldNumeroPas().setText(null);
				vistaCliente.getTextFieldAutoridadEm().setText(null);
				vistaCliente.getTextFieldFechaEmision().setText("YYYY-MM-DD");
				vistaCliente.getTextFieldFechaVencimiento().setText("YYYY-MM-DD");
				vistaCliente.getTextFieldCelular().setText(null);
				vistaCliente.getTextFieldPersonal().setText(null);
				vistaCliente.getTextFieldLaboral().setText(null);
				vistaCliente.getTextFieldNumeroPasajeroFrec().setText(null);
				vistaCliente.getTextFieldCategoriaPasFrec().setText("económica");
				vistaCliente.getTextFieldCalle().setText(null);
				vistaCliente.getTextFieldAltura().setText(null);
				vistaCliente.getTextFieldCiudad().setText(null);
				vistaCliente.getTextFieldCP().setText(null);
				vistaCliente.getComboBoxAlianzaPasFrec().setSelectedIndex(0);
				vistaCliente.getComboBoxAerPasFrec().setSelectedIndex(0);
				vistaCliente.getComboBoxProvincia().setSelectedIndex(0);
				vistaCliente.getComboBoxPaisDirec().setSelectedIndex(0);
				vistaCliente.getComboBoxPaisPasaporte().setSelectedIndex(0);
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getSource().equals(this.vistaCliente.getBtnEliminar())) {
			
			Cliente cliente = new Cliente();
			
			cliente = (Cliente) vistaCliente.getComboBoxCliente().getSelectedItem();
			
			try {
				controladorCliente.eliminarCliente(cliente);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "El cliente fue eliminado correctamente");
			vistaCliente.getComboBoxCliente().setSelectedIndex(0);
			
		}
		
		
		if(e.getSource().equals(this.vistaCliente.getBtnModificar())) {
			
			try {
				Cliente cliente = new Cliente();
				cliente = (Cliente) vistaCliente.getComboBoxCliente().getSelectedItem();
				
				cliente.setNombre(vistaCliente.getTextFieldNombre().getText());
				cliente.setApellido(vistaCliente.getTextFieldApellido().getText());
				cliente.setDni(vistaCliente.getTextFieldDNI().getText());
				cliente.setCuitCuil(vistaCliente.getTextFieldCuitCuil().getText());
				String fechaNacimiento = vistaCliente.getTextFieldFechaNac().getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha;
				try {
					fecha = format.parse(fechaNacimiento);
					cliente.setFechaNacimiento(fecha);
				} catch (ParseException e2) {
					throw new Exception("Fecha de nacimiento incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				cliente.setEmail(vistaCliente.getTextFieldEmail().getText());
				
				
				Pasaporte pasaporte = new Pasaporte();
				pasaporte.setNumero(vistaCliente.getTextFieldNumeroPas().getText());
				pasaporte.setAutoridadEmision(vistaCliente.getTextFieldAutoridadEm().getText());
				String fechaEmision = vistaCliente.getTextFieldFechaEmision().getText();
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha2;
				try {
					fecha2 = format2.parse(fechaEmision);
					pasaporte.setFechaEmision(fecha2);
				} catch (ParseException e3) {
					throw new Exception("Fecha de emisión del pasaporte incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				String fechaVencimiento = vistaCliente.getTextFieldFechaVencimiento().getText();
				SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha3;
				try {
					fecha3 = format3.parse(fechaVencimiento);
					pasaporte.setFechaVencimiento(fecha3);
				} catch (ParseException e4) {
					throw new Exception("Fecha de vencimiento del pasaporte incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				Pais pais = new Pais();
				pais = (Pais) vistaCliente.getComboBoxPaisPasaporte().getSelectedItem();
				if(pais.getNombre().equals("Otro")) {
					pais= controladorCliente.altaPais(vistaCliente.getTextFieldNuevoPais().getText());
				}
				else {
					pais = (Pais) vistaCliente.getComboBoxPaisPasaporte().getSelectedItem();
				}
				pasaporte.setPais(pais);
				cliente.setPasaporte(pasaporte);
				
				
				Telefono telefono = new Telefono();
				telefono.setNumeroCelular(vistaCliente.getTextFieldCelular().getText());
				telefono.setNumeroPersonal(vistaCliente.getTextFieldPersonal().getText());
				telefono.setNumeroLaboral(vistaCliente.getTextFieldLaboral().getText());
				cliente.setTelefono(telefono);
				
				
				PasajeroFrecuente pasajeroFrecuente = new PasajeroFrecuente();
				Alianza alianza = (Alianza) vistaCliente.getComboBoxAlianzaPasFrec().getSelectedItem();
				pasajeroFrecuente.setAlianza(alianza.getNombre());
				pasajeroFrecuente.setNumero(vistaCliente.getTextFieldNumeroPasajeroFrec().getText());
				pasajeroFrecuente.setCategoria(vistaCliente.getTextFieldCategoriaPasFrec().getText());
				Aerolinea aerolinea = (Aerolinea) vistaCliente.getComboBoxAerPasFrec().getSelectedItem();
				pasajeroFrecuente.setAerolinea(aerolinea);
				cliente.setPasajeroFrecuente(pasajeroFrecuente);
				
				
				Direccion direccion = new Direccion();
				direccion.setCalle(vistaCliente.getTextFieldCalle().getText());
				direccion.setAltura(vistaCliente.getTextFieldAltura().getText());
				direccion.setCiudad(vistaCliente.getTextFieldCiudad().getText());
				direccion.setCodigoPostal(vistaCliente.getTextFieldCP().getText());
				Provincia provincia = (Provincia) vistaCliente.getComboBoxProvincia().getSelectedItem();
				direccion.setProvincia(provincia);
				Pais pais2 = new Pais();
				pais2 = (Pais) vistaCliente.getComboBoxPaisDirec().getSelectedItem();
				if(pais2.getNombre().equals("Otro")) {
					pais2= controladorCliente.altaPais(vistaCliente.getTextFieldNuevoPais2().getText());
				}
				else {
					pais2 = (Pais) vistaCliente.getComboBoxPaisDirec().getSelectedItem();
				}
				direccion.setPais(pais2);
				cliente.setDireccion(direccion);
								
				
				controladorCliente.modificarCliente(cliente, pasaporte, telefono, pasajeroFrecuente, direccion);
				
				JOptionPane.showMessageDialog(null, "Cliente modificado correctamente");
				vistaCliente.getTextFieldNombre().setText(cliente.getNombre());
				vistaCliente.getTextFieldApellido().setText(cliente.getApellido());
				vistaCliente.getTextFieldDNI().setText(cliente.getDni());
				vistaCliente.getTextFieldCuitCuil().setText(cliente.getCuitCuil());
				vistaCliente.getTextFieldEmail().setText(cliente.getEmail());
				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				String fechaNac = df.format(cliente.getFechaNacimiento());
				vistaCliente.getTextFieldFechaNac().setText(fechaNac);
				vistaCliente.getTextFieldNumeroPas().setText(cliente.getPasaporte().getNumero());
				vistaCliente.getTextFieldAutoridadEm().setText(cliente.getPasaporte().getAutoridadEmision());
				DateFormat df1 = new SimpleDateFormat("yyyy-mm-dd");
				String fechaNac1 = df1.format(cliente.getPasaporte().getFechaEmision());
				vistaCliente.getTextFieldFechaEmision().setText(fechaNac1);
				DateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");
				String fechaNac2 = df2.format(cliente.getPasaporte().getFechaVencimiento());
				vistaCliente.getTextFieldFechaVencimiento().setText(fechaNac2);
				vistaCliente.getTextFieldCelular().setText(cliente.getTelefono().getNumeroCelular());
				vistaCliente.getTextFieldPersonal().setText(cliente.getTelefono().getNumeroPersonal());
				vistaCliente.getTextFieldLaboral().setText(cliente.getTelefono().getNumeroLaboral());
				vistaCliente.getTextFieldNumeroPasajeroFrec().setText(cliente.getPasajeroFrecuente().getNumero());
				vistaCliente.getTextFieldCategoriaPasFrec().setText(cliente.getPasajeroFrecuente().getCategoria());
				vistaCliente.getTextFieldCalle().setText(cliente.getDireccion().getCalle());
				vistaCliente.getTextFieldAltura().setText(cliente.getDireccion().getAltura());
				vistaCliente.getTextFieldCiudad().setText(cliente.getDireccion().getCiudad());
				vistaCliente.getTextFieldCP().setText(cliente.getDireccion().getCodigoPostal());
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
		
	}
	
	

}

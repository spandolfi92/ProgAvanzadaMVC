package edu.usal.vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.usal.controlador.grafica.ControladorVuelo;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Vuelos;

public class VistaVueloEventos implements ActionListener{
	
	private VistaVuelo vistaVuelo;
	private ControladorVuelo controladorVuelo;
	
	
	
	public VistaVueloEventos(VistaVuelo vistaVuelo, ControladorVuelo controladorVuelo) {
		
		this.vistaVuelo = vistaVuelo;
		this.controladorVuelo = controladorVuelo;
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(this.vistaVuelo.getBtnAgregar())) {
			
			try {
				Vuelos vuelo = new Vuelos();
				
				Aerolinea aerolinea = (Aerolinea) vistaVuelo.getComboBoxAerolinea().getSelectedItem();
				vuelo.setAerolinea(aerolinea);
				
				Aeropuerto aeropuertoSalida = (Aeropuerto) vistaVuelo.getComboBoxAeroSalida().getSelectedItem();
				vuelo.setAeropuertoSalida(aeropuertoSalida);
				
				Aeropuerto aeropuertoLlegada = (Aeropuerto) vistaVuelo.getComboBoxAeroLlegada().getSelectedItem();
				vuelo.setAeropuertoLlegada(aeropuertoLlegada);
				
				String codigo= aerolinea.getNombre();
				String codigo2= codigo.substring(0, 3);
				if(vistaVuelo.getTextFieldNumero().getText().isEmpty()) {
					throw new Exception("El número de vuelo no puede estar vacío");
				}
				vuelo.setNumeroVuelo(codigo2+"-"+vistaVuelo.getTextFieldNumero().getText());
				
				if(vistaVuelo.getTextFieldAsientos().getText().isEmpty()) {
					throw new Exception("La cantidad de asientos no puede estar vacía");
				}
				String parse = vistaVuelo.getTextFieldAsientos().getText();
				int cantidadAsientos=Integer.parseInt(parse);
				vuelo.setCantidadAsientos (cantidadAsientos);
				
				if(vistaVuelo.getTextFieldTiempo().getText().isEmpty()) {
					throw new Exception("El tiempo del vuelo no puede estar vacío");
				}
				vuelo.setTiempoVuelo(vistaVuelo.getTextFieldTiempo().getText());
				
				String fechaSalida = vistaVuelo.getTextFieldSalida().getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha;
				try {
					fecha = format.parse(fechaSalida);
					vuelo.setFechaSalida(fecha);
				} catch (ParseException e2) {
					throw new Exception("Fecha de salida incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				
				
				String fechaLlegada = vistaVuelo.getTextFieldLlegada().getText();
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha2;
				try {
					fecha2 = format2.parse(fechaLlegada);
					vuelo.setFechaLlegada(fecha2);
				} catch (ParseException e2) {
					throw new Exception("Fecha de llegada incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				
				controladorVuelo.altaVuelo(vuelo);
				
				JOptionPane.showMessageDialog(null, "Vuelo agregado correctamente");
				vistaVuelo.getTextFieldNumero().setText(null);
				vistaVuelo.getTextFieldAsientos().setText(null);
				vistaVuelo.getTextFieldSalida().setText("YYYY-MM-DD");
				vistaVuelo.getTextFieldLlegada().setText("YYYY-MM-DD");
				vistaVuelo.getTextFieldTiempo().setText(null);
				vistaVuelo.getComboBoxAerolinea().setSelectedIndex(0);
				vistaVuelo.getComboBoxAeroSalida().setSelectedIndex(0);
				vistaVuelo.getComboBoxAeroLlegada().setSelectedIndex(0);
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getSource().equals(this.vistaVuelo.getBtnEliminar())) {
			
			Vuelos vuelo = new Vuelos();
			
			vuelo = (Vuelos) vistaVuelo.getCbox_SeleccionarVuelo().getSelectedItem();
			
			controladorVuelo.eliminarVuelo(vuelo.getNumeroVuelo());
			
			JOptionPane.showMessageDialog(null, "El vuelo fue eliminado correctamente");
			vistaVuelo.getCbox_SeleccionarVuelo().setSelectedIndex(0);
			
		}
		
		if(e.getSource().equals(this.vistaVuelo.getBtnModificar())) {
			
			try {
				Vuelos vuelo = (Vuelos) vistaVuelo.getCbox_SeleccionarVuelo().getSelectedItem();
				
				Aerolinea aerolinea = (Aerolinea) vistaVuelo.getComboBoxAerolinea().getSelectedItem();
				vuelo.setAerolinea(aerolinea);
				
				Aeropuerto aeropuertoSalida = (Aeropuerto) vistaVuelo.getComboBoxAeroSalida().getSelectedItem();
				vuelo.setAeropuertoSalida(aeropuertoSalida);
				
				Aeropuerto aeropuertoLlegada = (Aeropuerto) vistaVuelo.getComboBoxAeroLlegada().getSelectedItem();
				vuelo.setAeropuertoLlegada(aeropuertoLlegada);
				
				String codigo= aerolinea.getNombre();
				
				if(vistaVuelo.getTextFieldNumero().getText().isEmpty()) {
					throw new Exception("El número de vuelo no puede estar vacío");
				}
				vuelo.setNumeroVuelo(vistaVuelo.getTextFieldNumero().getText());
				
				if(vistaVuelo.getTextFieldAsientos().getText().isEmpty()) {
					throw new Exception("La cantidad de asientos no puede estar vacía");
				}
				String parse = vistaVuelo.getTextFieldAsientos().getText();
				int cantidadAsientos=Integer.parseInt(parse);
				vuelo.setCantidadAsientos (cantidadAsientos);
				
				if(vistaVuelo.getTextFieldTiempo().getText().isEmpty()) {
					throw new Exception("El tiempo del vuelo no puede estar vacío");
				}
				vuelo.setTiempoVuelo(vistaVuelo.getTextFieldTiempo().getText());
				
				String fechaSalida = vistaVuelo.getTextFieldSalida().getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha;
				try {
					fecha = format.parse(fechaSalida);
					vuelo.setFechaSalida(fecha);
				} catch (ParseException e2) {
					throw new Exception("Fecha de salida incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				
				
				String fechaLlegada = vistaVuelo.getTextFieldLlegada().getText();
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha2;
				try {
					fecha2 = format2.parse(fechaLlegada);
					vuelo.setFechaLlegada(fecha2);
				} catch (ParseException e2) {
					throw new Exception("Fecha de llegada incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
								
				
				controladorVuelo.modificarVuelo(vuelo);
				
				JOptionPane.showMessageDialog(null, "Vuelo modificado correctamente");
				vistaVuelo.getTextFieldNumero().setText(null);
				vistaVuelo.getTextFieldAsientos().setText(null);
				vistaVuelo.getTextFieldSalida().setText("YYYY-MM-DD");
				vistaVuelo.getTextFieldLlegada().setText("YYYY-MM-DD");
				vistaVuelo.getTextFieldTiempo().setText(null);
				vistaVuelo.getComboBoxAerolinea().setSelectedIndex(0);
				vistaVuelo.getComboBoxAeroSalida().setSelectedIndex(0);
				vistaVuelo.getComboBoxAeroLlegada().setSelectedIndex(0);
				
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
		
		
	}
	
	

}

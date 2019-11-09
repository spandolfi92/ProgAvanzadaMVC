package edu.usal.vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.usal.controlador.grafica.ControladorVenta;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Ventas;
import edu.usal.negocio.dominio.Vuelos;

public class VistaVentaEventos implements ActionListener{
	
	private VistaVenta vistaVenta;
	private ControladorVenta controladorVenta;
	
	public VistaVentaEventos(VistaVenta vistaVenta, ControladorVenta controladorVenta) {
		
		this.vistaVenta = vistaVenta;
		this.controladorVenta = controladorVenta;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(this.vistaVenta.getBtnAgregar())) {
			
			try {
				Ventas venta = new Ventas();
				
				Aerolinea aerolinea = (Aerolinea) vistaVenta.getComboBoxAerolinea().getSelectedItem();
				venta.setAerolinea(aerolinea);
				
				Vuelos vuelo = (Vuelos) vistaVenta.getComboBoxVuelo().getSelectedItem();
				venta.setVuelo(vuelo);
				
				Cliente cliente = (Cliente) vistaVenta.getComboBoxCliente().getSelectedItem();
				venta.setCliente(cliente);
				
				venta.setFormaPago((String) vistaVenta.getComboBoxPago().getSelectedItem());
				
				String fechaVenta = vistaVenta.getTextFieldFecha().getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha;
				try {
					fecha = format.parse(fechaVenta);
					venta.setFechaVenta(fecha);
				} catch (ParseException e2) {
					throw new Exception("Fecha de venta incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
				
				controladorVenta.altaVenta(venta);
				
				JOptionPane.showMessageDialog(null, "Venta agregada correctamente");
				vistaVenta.getComboBoxPago().setSelectedIndex(0);
				vistaVenta.getTextFieldFecha().setText("YYYY-MM-DD");
				vistaVenta.getComboBoxAerolinea().setSelectedIndex(0);
				vistaVenta.getComboBoxVuelo().setSelectedIndex(0);
				vistaVenta.getComboBoxCliente().setSelectedIndex(0);
			
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		else if(e.getSource().equals(this.vistaVenta.getBtnEliminar())) {
			
			Ventas venta = new Ventas();
			
			venta = (Ventas) vistaVenta.getCbox_SeleccionarVenta().getSelectedItem();
			
			controladorVenta.eliminarVenta(venta.getId());
			
			JOptionPane.showMessageDialog(null, "La venta fue eliminada correctamente");
			vistaVenta.getCbox_SeleccionarVenta().setSelectedIndex(0);

			
		}
		
		if(e.getSource().equals(this.vistaVenta.getBtnModificar())) {
			
			try {
				Ventas venta = (Ventas) vistaVenta.getCbox_SeleccionarVenta().getSelectedItem();
			
				Aerolinea aerolinea = (Aerolinea) vistaVenta.getComboBoxAerolinea().getSelectedItem();
				venta.setAerolinea(aerolinea);
				
				Vuelos vuelo = (Vuelos) vistaVenta.getComboBoxVuelo().getSelectedItem();
				venta.setVuelo(vuelo);
				
				Cliente cliente = (Cliente) vistaVenta.getComboBoxCliente().getSelectedItem();
				venta.setCliente(cliente);
				
				venta.setFormaPago((String) vistaVenta.getComboBoxPago().getSelectedItem());
				
				String fechaVenta = vistaVenta.getTextFieldFecha().getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha;
				try {
					fecha = format.parse(fechaVenta);
					venta.setFechaVenta(fecha);
				} catch (ParseException e2) {
					throw new Exception("Fecha de venta incorrecta o vacía. Debe tener formato YYYY-MM-DD");
				}
								
				
				controladorVenta.modificarVenta(venta);
				
				JOptionPane.showMessageDialog(null, "Venta modificada correctamente");
				vistaVenta.getComboBoxPago().setSelectedIndex(0);
				vistaVenta.getTextFieldFecha().setText("YYYY-MM-DD");
				vistaVenta.getComboBoxAerolinea().setSelectedIndex(0);
				vistaVenta.getComboBoxVuelo().setSelectedIndex(0);
				vistaVenta.getComboBoxCliente().setSelectedIndex(0);
				
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	
	}
	
	

}

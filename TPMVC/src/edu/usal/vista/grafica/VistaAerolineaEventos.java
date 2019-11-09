package edu.usal.vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.usal.controlador.grafica.ControladorAerolinea;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Alianza;

public class VistaAerolineaEventos implements ActionListener{
	
	private VistaAerolinea vistaAerolinea;
	private ControladorAerolinea controladorAerolinea;
	
	
	public VistaAerolineaEventos(VistaAerolinea vistaAerolinea, ControladorAerolinea controladorAerolinea) {
		
		this.vistaAerolinea = vistaAerolinea;
		this.controladorAerolinea = controladorAerolinea;
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(this.vistaAerolinea.getBtnAceptar())) {
			
			try {
				Aerolinea aerolinea = new Aerolinea();
				Alianza alianza = (Alianza) vistaAerolinea.getCboxAlianza().getSelectedItem();
				aerolinea.setAlianza(alianza.getNombre());
				
				aerolinea.setNombre(vistaAerolinea.getTxt_nombreAerolinea().getText());
				
				
				controladorAerolinea.altaAerolinea(aerolinea);
				
				JOptionPane.showMessageDialog(null, "Aerolinea agregada correctamente");
				vistaAerolinea.getTxt_nombreAerolinea().setText(null);
				vistaAerolinea.getCboxAlianza().setSelectedIndex(0);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getSource().equals(this.vistaAerolinea.getBtnEliminar())) {
			
			Aerolinea aerolinea = new Aerolinea();
			
			aerolinea = (Aerolinea) vistaAerolinea.getCbox_SeleccionarAerolinea().getSelectedItem();
			
			controladorAerolinea.eliminarAerolinea(aerolinea.getId());
			
			JOptionPane.showMessageDialog(null, "La Aerolinea fue eliminada correctamente");
			vistaAerolinea.getCbox_SeleccionarAerolinea().setSelectedIndex(0);
			
		}
		
		if(e.getSource().equals(this.vistaAerolinea.getBtnModificar())) {
			
			try {
				Aerolinea aerolinea = new Aerolinea();
				aerolinea = (Aerolinea) vistaAerolinea.getCbox_SeleccionarAerolinea().getSelectedItem();
				
				aerolinea.setNombre(vistaAerolinea.getTxt_nombreAerolinea().getText());
				
				Alianza alianza = (Alianza) vistaAerolinea.getCboxAlianza().getSelectedItem();
				aerolinea.setAlianza(alianza.getNombre());
				
				controladorAerolinea.modificarAerolinea(aerolinea);
			
				JOptionPane.showMessageDialog(null, "La Aerolinea se modifico correctamente");
				vistaAerolinea.getTxt_nombreAerolinea().setText(null);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
		
		
		
		
	}
	
	

}

package edu.usal.vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import edu.usal.controlador.grafica.ControladorAerolinea;
import edu.usal.controlador.grafica.ControladorCliente;
import edu.usal.controlador.grafica.ControladorVenta;
import edu.usal.controlador.grafica.ControladorVuelo;
import edu.usal.negocio.dao.factory.AerolineaFactory;
import edu.usal.negocio.dao.factory.AeropuertoFactory;
import edu.usal.negocio.dao.factory.AlianzaFactory;
import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.DireccionFactory;
import edu.usal.negocio.dao.factory.PaisFactory;
import edu.usal.negocio.dao.factory.PasajeroFrecuenteFactory;
import edu.usal.negocio.dao.factory.PasaporteFactory;
import edu.usal.negocio.dao.factory.ProvinciaFactory;
import edu.usal.negocio.dao.factory.TelefonoFactory;
import edu.usal.negocio.dao.factory.VentaFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.negocio.dao.interfaces.AlianzaDAO;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.DireccionDAO;
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dao.interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;

public class InicialEventos implements ActionListener{
	
	private Inicial inicial;
	private JPanel contentPane;
	
	public InicialEventos (Inicial inicial, JPanel contentPane) {
		this.inicial = inicial;
		this.contentPane = contentPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(this.inicial.getItmAerolineasA())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
    		
    		ControladorAerolinea controladorAerolinea = new ControladorAerolinea(aerolineaDAO, alianzaDAO);
    		String alta= "alta";
    		VistaAerolinea vistaAerolinea = new VistaAerolinea(controladorAerolinea, contentPane, alta);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaAerolinea);
    	
    		vistaAerolinea.setVisible(true);   
    	}
		
		else if (e.getSource().equals(this.inicial.getItmAerolineasB())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
        	AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
        	
        	ControladorAerolinea controladorAerolinea = new ControladorAerolinea(aerolineaDAO, alianzaDAO);
        	String baja= "baja";
        	VistaAerolinea vistaAerolineaBaja = new VistaAerolinea(controladorAerolinea, contentPane, baja);
    		 
    		
			inicial.getContentPane().revalidate(); 
    		inicial.getContentPane().add(vistaAerolineaBaja);
    	
    		vistaAerolineaBaja.setVisible(true);

		}
		
		
		else if (e.getSource().equals(this.inicial.getItmAerolineasM())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
        	AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
        	
        	ControladorAerolinea controladorAerolinea = new ControladorAerolinea(aerolineaDAO, alianzaDAO);
        	String modificacion= "modificacion";
        	VistaAerolinea vistaAerolineaModificacion = new VistaAerolinea(controladorAerolinea, contentPane, modificacion);
    		
			inicial.getContentPane().revalidate(); 
    		inicial.getContentPane().add(vistaAerolineaModificacion);
    	
    		vistaAerolineaModificacion.setVisible(true);

		}
		
		
		else if (e.getSource().equals(this.inicial.getItmAerolineasC())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
        	AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
        	
        	ControladorAerolinea controladorAerolinea = new ControladorAerolinea(aerolineaDAO, alianzaDAO);
        	String consulta= "consulta";
        	VistaAerolinea vistaAerolineaConsulta = new VistaAerolinea(controladorAerolinea, contentPane, consulta);
    		
			inicial.getContentPane().revalidate(); 
    		inicial.getContentPane().add(vistaAerolineaConsulta);
    	
    		vistaAerolineaConsulta.setVisible(true);

		}
		
		else if (e.getSource().equals(this.inicial.getItmClienteA())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			
			ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
        	PasaporteDAO pasaporteDAO = PasaporteFactory.getImplementation("BD");
        	TelefonoDAO telefonoDAO = TelefonoFactory.getImplementation("BD");
        	PasajeroFrecuenteDAO pasajeroFrecuenteDAO = PasajeroFrecuenteFactory.getImplementation("BD");
        	DireccionDAO direccionDAO = DireccionFactory.getImplementation("BD");
        	PaisDAO paisDAO = PaisFactory.getImplementation("BD");
        	AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
        	ProvinciaDAO provinciaDAO = ProvinciaFactory.getImplementation("BD");
        	AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
        	
        	ControladorCliente controladorCliente = new ControladorCliente(clienteDAO, pasaporteDAO, telefonoDAO,
    				pasajeroFrecuenteDAO, direccionDAO, paisDAO, aerolineaDAO, provinciaDAO, alianzaDAO);
        	String alta= "alta";
        	VistaCliente vistaCliente = new VistaCliente(controladorCliente, contentPane, alta);
			
			inicial.getContentPane().revalidate(); 
    		inicial.getContentPane().add(vistaCliente);
    	
    		vistaCliente.setVisible(true);

		}
		
		else if (e.getSource().equals(this.inicial.getItmClienteB())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			
			ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
        	PasaporteDAO pasaporteDAO = PasaporteFactory.getImplementation("BD");
        	TelefonoDAO telefonoDAO = TelefonoFactory.getImplementation("BD");
        	PasajeroFrecuenteDAO pasajeroFrecuenteDAO = PasajeroFrecuenteFactory.getImplementation("BD");
        	DireccionDAO direccionDAO = DireccionFactory.getImplementation("BD");
        	PaisDAO paisDAO = PaisFactory.getImplementation("BD");
        	AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
        	ProvinciaDAO provinciaDAO = ProvinciaFactory.getImplementation("BD");
        	AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
        	
        	ControladorCliente controladorCliente = new ControladorCliente(clienteDAO, pasaporteDAO, telefonoDAO,
    				pasajeroFrecuenteDAO, direccionDAO, paisDAO, aerolineaDAO, provinciaDAO, alianzaDAO);
        	String baja= "baja";
        	VistaCliente vistaClienteBaja = new VistaCliente(controladorCliente, contentPane, baja);
			
			inicial.getContentPane().revalidate(); 
    		inicial.getContentPane().add(vistaClienteBaja);
    	
    		vistaClienteBaja.setVisible(true);

		}
		
		
		else if (e.getSource().equals(this.inicial.getItmClienteM())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			
			ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
        	PasaporteDAO pasaporteDAO = PasaporteFactory.getImplementation("BD");
        	TelefonoDAO telefonoDAO = TelefonoFactory.getImplementation("BD");
        	PasajeroFrecuenteDAO pasajeroFrecuenteDAO = PasajeroFrecuenteFactory.getImplementation("BD");
        	DireccionDAO direccionDAO = DireccionFactory.getImplementation("BD");
        	PaisDAO paisDAO = PaisFactory.getImplementation("BD");
        	AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
        	ProvinciaDAO provinciaDAO = ProvinciaFactory.getImplementation("BD");
        	AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
        	
        	ControladorCliente controladorCliente = new ControladorCliente(clienteDAO, pasaporteDAO, telefonoDAO,
    				pasajeroFrecuenteDAO, direccionDAO, paisDAO, aerolineaDAO, provinciaDAO, alianzaDAO);
        	String modificacion= "modificacion";
        	VistaCliente vistaClienteModificacion = new VistaCliente(controladorCliente, contentPane, modificacion);
			
			inicial.getContentPane().revalidate(); 
    		inicial.getContentPane().add(vistaClienteModificacion);
    	
    		vistaClienteModificacion.setVisible(true);

		}
		
		else if (e.getSource().equals(this.inicial.getItmClienteC())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			
			ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
        	PasaporteDAO pasaporteDAO = PasaporteFactory.getImplementation("BD");
        	TelefonoDAO telefonoDAO = TelefonoFactory.getImplementation("BD");
        	PasajeroFrecuenteDAO pasajeroFrecuenteDAO = PasajeroFrecuenteFactory.getImplementation("BD");
        	DireccionDAO direccionDAO = DireccionFactory.getImplementation("BD");
        	PaisDAO paisDAO = PaisFactory.getImplementation("BD");
        	AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
        	ProvinciaDAO provinciaDAO = ProvinciaFactory.getImplementation("BD");
        	AlianzaDAO alianzaDAO = AlianzaFactory.getImplementation("Archivo");
        	
        	ControladorCliente controladorCliente = new ControladorCliente(clienteDAO, pasaporteDAO, telefonoDAO,
    				pasajeroFrecuenteDAO, direccionDAO, paisDAO, aerolineaDAO, provinciaDAO, alianzaDAO);
        	String consulta= "consulta";
        	VistaCliente vistaClienteConsulta = new VistaCliente(controladorCliente, contentPane, consulta);
			
			inicial.getContentPane().revalidate(); 
    		inicial.getContentPane().add(vistaClienteConsulta);
    	
    		vistaClienteConsulta.setVisible(true);

		}
		
		if(e.getSource().equals(this.inicial.getItmVueloA())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		AeropuertoDAO aeropuertoDAO = AeropuertoFactory.getImplementation("BD");
    		
    		ControladorVuelo controladorVuelo = new ControladorVuelo(aerolineaDAO, vueloDAO, aeropuertoDAO);
    		String alta= "alta";
    		VistaVuelo vistaVueloAlta = new VistaVuelo(controladorVuelo, contentPane, alta);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVueloAlta);
    	
    		vistaVueloAlta.setVisible(true);   
    	}
		
		if(e.getSource().equals(this.inicial.getItmVueloB())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		AeropuertoDAO aeropuertoDAO = AeropuertoFactory.getImplementation("BD");
    		
    		ControladorVuelo controladorVuelo = new ControladorVuelo(aerolineaDAO, vueloDAO, aeropuertoDAO);
    		String baja= "baja";
    		VistaVuelo vistaVueloBaja = new VistaVuelo(controladorVuelo, contentPane, baja);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVueloBaja);
    	
    		vistaVueloBaja.setVisible(true);   
    	}
		
		if(e.getSource().equals(this.inicial.getItmVueloM())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		AeropuertoDAO aeropuertoDAO = AeropuertoFactory.getImplementation("BD");
    		
    		ControladorVuelo controladorVuelo = new ControladorVuelo(aerolineaDAO, vueloDAO, aeropuertoDAO);
    		String modificacion= "modificacion";
    		VistaVuelo vistaVueloModificacion = new VistaVuelo(controladorVuelo, contentPane, modificacion);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVueloModificacion);
    	
    		vistaVueloModificacion.setVisible(true);   
    	}
		
		if(e.getSource().equals(this.inicial.getItmVueloC())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		AeropuertoDAO aeropuertoDAO = AeropuertoFactory.getImplementation("BD");
    		
    		ControladorVuelo controladorVuelo = new ControladorVuelo(aerolineaDAO, vueloDAO, aeropuertoDAO);
    		String consulta= "consulta";
    		VistaVuelo vistaVueloConsulta = new VistaVuelo(controladorVuelo, contentPane, consulta);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVueloConsulta);
    	
    		vistaVueloConsulta.setVisible(true);   
    	}
		
		if(e.getSource().equals(this.inicial.getItmVentaA())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
    		VentaDAO ventaDAO = VentaFactory.getImplementation("BD");
    		
    		ControladorVenta controladorVenta = new ControladorVenta(aerolineaDAO, vueloDAO, ventaDAO, clienteDAO);
    		String alta= "alta";
    		VistaVenta vistaVentaAlta = new VistaVenta(controladorVenta, contentPane, alta);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVentaAlta);
    	
    		vistaVentaAlta.setVisible(true);   
    	}
		
		if(e.getSource().equals(this.inicial.getItmVentaB())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
    		VentaDAO ventaDAO = VentaFactory.getImplementation("BD");
    		
    		ControladorVenta controladorVenta = new ControladorVenta(aerolineaDAO, vueloDAO, ventaDAO, clienteDAO);
    		String baja= "baja";
    		VistaVenta vistaVentaBaja = new VistaVenta(controladorVenta, contentPane, baja);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVentaBaja);
    	
    		vistaVentaBaja.setVisible(true);   
    	}
		
		if(e.getSource().equals(this.inicial.getItmVentaM())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
    		VentaDAO ventaDAO = VentaFactory.getImplementation("BD");
    		
    		ControladorVenta controladorVenta = new ControladorVenta(aerolineaDAO, vueloDAO, ventaDAO, clienteDAO);
    		String modificacion= "modificacion";
    		VistaVenta vistaVentaModificacion = new VistaVenta(controladorVenta, contentPane, modificacion);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVentaModificacion);
    	
    		vistaVentaModificacion.setVisible(true);   
    	}
		
		if(e.getSource().equals(this.inicial.getItmVentaC())) {
			inicial.getContentPane().removeAll();
			inicial.getContentPane().repaint();
			AerolineaDAO aerolineaDAO = AerolineaFactory.getImplementation("BD");
    		VueloDAO vueloDAO = VueloFactory.getImplementation("BD");
    		ClienteDAO clienteDAO = ClienteFactory.getImplementation("BD");
    		VentaDAO ventaDAO = VentaFactory.getImplementation("BD");
    		
    		ControladorVenta controladorVenta = new ControladorVenta(aerolineaDAO, vueloDAO, ventaDAO, clienteDAO);
    		String consulta= "consulta";
    		VistaVenta vistaVentaConsulta = new VistaVenta(controladorVenta, contentPane, consulta);
    		
    		inicial.getContentPane().revalidate();   		
    		inicial.getContentPane().add(vistaVentaConsulta);
    	
    		vistaVentaConsulta.setVisible(true);   
    	}
		
	}

}

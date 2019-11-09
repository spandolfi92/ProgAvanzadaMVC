package edu.usal.vista.grafica;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicial extends JFrame{

	private JPanel contentPane;
    private JMenuBar barraMenu;
    private JMenu menuAerolineas,menuClientes,menuVentas,menuVuelos;
    
    private JMenuItem itmAerolineasA,itmAerolineasB,itmAerolineasM,itmAerolineasC,
    itmClienteA,itmClienteB,itmClienteM,itmClienteC,
    itmVentaA,itmVentaB,itmVentaM,itmVentaC,
    itmVueloA,itmVueloB,itmVueloM,itmVueloC;
      
    	
	public JMenuItem getItmAerolineasA() {
		return itmAerolineasA;
	}
	
	public JMenuItem getItmAerolineasB() {
		return itmAerolineasB;
	}
	
	public JMenuItem getItmAerolineasM() {
		return itmAerolineasM;
	}
	
	public JMenuItem getItmAerolineasC() {
		return itmAerolineasC;
	}
	
	public JMenuItem getItmClienteA() {
		return itmClienteA;
	}

	public JMenuItem getItmClienteB() {
		return itmClienteB;
	}

	public JMenuItem getItmClienteM() {
		return itmClienteM;
	}

	public JMenuItem getItmClienteC() {
		return itmClienteC;
	}
	
	public JMenuItem getItmVentaA() {
		return itmVentaA;
	}

	public JMenuItem getItmVentaB() {
		return itmVentaB;
	}

	public JMenuItem getItmVentaM() {
		return itmVentaM;
	}

	public JMenuItem getItmVentaC() {
		return itmVentaC;
	}

	public JMenuItem getItmVueloA() {
		return itmVueloA;
	}

	public JMenuItem getItmVueloB() {
		return itmVueloB;
	}

	public JMenuItem getItmVueloM() {
		return itmVueloM;
	}

	public JMenuItem getItmVueloC() {
		return itmVueloC;
	}

	
	public Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 762, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.barraMenu = new JMenuBar();
	         
        this.menuAerolineas = new JMenu("Aerolineas");
        this.menuClientes = new JMenu("Clientes");
        this.menuVentas = new JMenu("Ventas");
        this.menuVuelos = new JMenu("Vuelos");
         
        this.itmAerolineasA = new JMenuItem("Agregar Aerolinea");
        this.itmAerolineasB = new JMenuItem("Eliminar Aerolinea");
        this.itmAerolineasM = new JMenuItem("Modificar Aerolinea");
        this.itmAerolineasC = new JMenuItem("Consultar Aerolineas");
      
        this.itmClienteA = new JMenuItem("Agregar Cliente");
        this.itmClienteB = new JMenuItem("Eliminar Cliente");
        this.itmClienteM = new JMenuItem("Modificar Cliente");
        this.itmClienteC = new JMenuItem("Consultar Clientes");
      
        this.itmVentaA = new JMenuItem("Agregar Venta");
        this.itmVentaB = new JMenuItem("Eliminar Venta");
        this.itmVentaM = new JMenuItem("Modificar Venta");
        this.itmVentaC = new JMenuItem("Consultar Ventas");
      
        this.itmVueloA = new JMenuItem("Agregar Vuelo");
        this.itmVueloB = new JMenuItem("Eliminar Vuelo");
        this.itmVueloM = new JMenuItem("Modificar Vuelo");
        this.itmVueloC = new JMenuItem("Consultar Vuelos");
        
        this.init();
	}
	
	
	public void init() {
		
		this.barraMenu.add(this.menuAerolineas);
        this.menuAerolineas.add(this.itmAerolineasA);
        this.menuAerolineas.add(this.itmAerolineasB);
        this.menuAerolineas.add(this.itmAerolineasM);
        this.menuAerolineas.add(this.itmAerolineasC);
        
        this.barraMenu.add(this.menuClientes);
        this.menuClientes.add(this.itmClienteA);
        this.menuClientes.add(this.itmClienteB);
        this.menuClientes.add(this.itmClienteM);
        this.menuClientes.add(this.itmClienteC);
        
        this.barraMenu.add(this.menuVentas);
        this.menuVentas.add(this.itmVentaA);
        this.menuVentas.add(this.itmVentaB);
        this.menuVentas.add(this.itmVentaM);
        this.menuVentas.add(this.itmVentaC);
        
        this.barraMenu.add(this.menuVuelos);
        this.menuVuelos.add(this.itmVueloA);
        this.menuVuelos.add(this.itmVueloB);
        this.menuVuelos.add(this.itmVueloM);
        this.menuVuelos.add(this.itmVueloC);
   
        this.setJMenuBar(this.barraMenu);
        this.setLocationRelativeTo(null);
        
        itmAerolineasA.addActionListener(new InicialEventos(this, contentPane));
        itmAerolineasB.addActionListener(new InicialEventos(this, contentPane));
        itmAerolineasM.addActionListener(new InicialEventos(this, contentPane));
        itmAerolineasC.addActionListener(new InicialEventos(this, contentPane));
        
        itmClienteA.addActionListener(new InicialEventos(this, contentPane));
        itmClienteB.addActionListener(new InicialEventos(this, contentPane));
        itmClienteM.addActionListener(new InicialEventos(this, contentPane));
        itmClienteC.addActionListener(new InicialEventos(this, contentPane));
        
        itmVueloA.addActionListener(new InicialEventos(this, contentPane));
        itmVueloB.addActionListener(new InicialEventos(this, contentPane));
        itmVueloM.addActionListener(new InicialEventos(this, contentPane));
        itmVueloC.addActionListener(new InicialEventos(this, contentPane));
        
        itmVentaA.addActionListener(new InicialEventos(this, contentPane));
        itmVentaB.addActionListener(new InicialEventos(this, contentPane));
        itmVentaM.addActionListener(new InicialEventos(this, contentPane));
        itmVentaC.addActionListener(new InicialEventos(this, contentPane));
        
        this.setVisible(true);
	        
	}
}

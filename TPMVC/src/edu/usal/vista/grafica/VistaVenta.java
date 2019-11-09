package edu.usal.vista.grafica;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.usal.controlador.grafica.ControladorVenta;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Ventas;
import edu.usal.negocio.dominio.Vuelos;

public class VistaVenta extends JPanel {

	private ControladorVenta controladorVenta;
	private JPanel contentPane;
	private JLabel lblCliente;
    private JLabel lblAerolinea;
    private JLabel lblFechaVenta;
    private JTextField textFieldFecha;
    private JTextField textFieldPago;
    private JLabel lblPago;
    private JComboBox <Aerolinea> comboBoxAerolinea;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JComboBox <Cliente> comboBoxCliente;
    private JComboBox <Vuelos> comboBoxVuelo;
    public  JComboBox<Ventas> cbox_SeleccionarVenta;
    private JLabel lblSeleccionarVenta;
    private JButton btnModificar;
    Ventas venta = new Ventas();
    private JTable tabla;
	private JScrollPane pane;
	private JComboBox comboBoxPago;
	
	public VistaVenta(ControladorVenta controladorVenta, JPanel contentPane, String accion) {
		this.controladorVenta = controladorVenta;
		this.contentPane = contentPane;
		
		if (accion.equals("alta")) {
			alta();
		}
		else if (accion.equals("baja")) {
			baja();
		}
		else if (accion.equals("modificacion")) {
			modificacion();
		}
		else if (accion.equals("consulta")) {
			consulta();
		}
		

	}
	
	
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	

	public Ventas getVenta() {
		return venta;
	}



	public void setVenta(Ventas venta) {
		this.venta = venta;
	}



	public JComboBox getComboBoxPago() {
		return comboBoxPago;
	}



	public void setComboBoxPago(JComboBox comboBoxPago) {
		this.comboBoxPago = comboBoxPago;
	}



	public JButton getBtnModificar() {
		return btnModificar;
	}



	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}



	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}



	public JComboBox<Ventas> getCbox_SeleccionarVenta() {
		return cbox_SeleccionarVenta;
	}



	public void setCbox_SeleccionarVenta(JComboBox cbox_SeleccionarVenta) {
		this.cbox_SeleccionarVenta = cbox_SeleccionarVenta;
	}



	public JComboBox getComboBoxVuelo() {
		return comboBoxVuelo;
	}



	public void setComboBoxVuelo(JComboBox comboBoxVuelo) {
		this.comboBoxVuelo = comboBoxVuelo;
	}



	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	

	public JTextField getTextFieldFecha() {
		return textFieldFecha;
	}



	public void setTextFieldFecha(JTextField textFieldFecha) {
		this.textFieldFecha = textFieldFecha;
	}
	
	


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}



	public JTextField getTextFieldPago() {
		return textFieldPago;
	}



	public void setTextFieldPago(JTextField textFieldPago) {
		this.textFieldPago = textFieldPago;
	}



	public JComboBox getComboBoxCliente() {
		return comboBoxCliente;
	}



	public void setComboBoxCliente(JComboBox comboBoxCliente) {
		this.comboBoxCliente = comboBoxCliente;
	}



	public JComboBox getComboBoxAerolinea() {
		return comboBoxAerolinea;
	}



	public void setComboBoxAerolinea(JComboBox comboBoxAerolinea) {
		this.comboBoxAerolinea = comboBoxAerolinea;
	}



	public void alta() {
		contentPane.setLayout(null);
		
		lblCliente = new JLabel("Seleccionar cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCliente.setBounds(380, 32, 140, 14);
		contentPane.add(lblCliente);
		
		lblAerolinea = new JLabel("Seleccionar aerol\u00EDnea:");
		lblAerolinea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAerolinea.setBounds(10, 75, 174, 14);
		contentPane.add(lblAerolinea);
		
		lblFechaVenta = new JLabel("Fecha venta:");
		lblFechaVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaVenta.setBounds(414, 75, 130, 14);
		contentPane.add(lblFechaVenta);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setText("YYYY-MM-DD");
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(501, 75, 223, 20);
		contentPane.add(textFieldFecha);
		
		comboBoxPago = new JComboBox();
		comboBoxPago.addItem("Contado efectivo");
		comboBoxPago.addItem("Tarjeta de Crédito/Débito");
        comboBoxPago.setBounds(135, 119, 208, 20);
		contentPane.add(comboBoxPago);
		
		lblPago = new JLabel("Forma de pago:");
		lblPago.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPago.setBounds(43, 122, 109, 14);
		contentPane.add(lblPago);
		
		comboBoxAerolinea = new JComboBox();
		comboBoxAerolinea.setModel(new DefaultComboBoxModel(controladorVenta.listarAerolineas().toArray()));
		comboBoxAerolinea.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Aerolinea){
                	Aerolinea aerolinea = (Aerolinea) value;
                    setText(aerolinea.getNombre());
                   
                }
                return this;
            }
        } );
		comboBoxAerolinea.setBounds(135, 74, 208, 22);
		contentPane.add(comboBoxAerolinea);
		
		JLabel lblVuelo = new JLabel("Seleccionar vuelo:");
		lblVuelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVuelo.setBounds(24, 32, 136, 14);
		contentPane.add(lblVuelo);
		
		comboBoxVuelo = new JComboBox();
		comboBoxVuelo.setModel(new DefaultComboBoxModel(controladorVenta.listarVuelos().toArray()));
		comboBoxVuelo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Vuelos){
                	Vuelos vuelo = (Vuelos) value;
                    setText(vuelo.getNumeroVuelo());
                   
                }
                return this;
            }
        } );
		comboBoxVuelo.setBounds(135, 28, 208, 22);
		contentPane.add(comboBoxVuelo);
		
		comboBoxCliente = new JComboBox();
		comboBoxCliente.setModel(new DefaultComboBoxModel(controladorVenta.listarClientes().toArray()));
		comboBoxCliente.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Cliente){
                	Cliente cliente = (Cliente) value;
                    setText(cliente.getNombre() + " " + cliente.getApellido());
                }
                return this;
            }
        } );
		comboBoxCliente.setBounds(501, 28, 223, 22);
		contentPane.add(comboBoxCliente);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(309, 194, 89, 23);
		contentPane.add(btnAgregar);
		
		btnAgregar.addActionListener(new VistaVentaEventos(this, controladorVenta));
	}
	
	
	
	public void baja() {
		contentPane.setLayout(null);
		
		lblSeleccionarVenta = new JLabel("Seleccionar Venta:");
		lblSeleccionarVenta.setBounds(12, 13, 136, 16);
		contentPane.add(lblSeleccionarVenta);
		
		cbox_SeleccionarVenta = new JComboBox<Ventas>();
		cbox_SeleccionarVenta.setModel(new DefaultComboBoxModel(controladorVenta.listarVentas().toArray()));
		cbox_SeleccionarVenta.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Ventas){
                	Ventas venta = (Ventas) value;
                    setText("Vuelo: "  + venta.getVuelo().getNumeroVuelo() + " - Cliente: " + venta.getCliente().getNombre() + " " + venta.getCliente().getApellido() );
                }
                return this;
            }
        } );
		cbox_SeleccionarVenta.setBounds(160, 10, 550, 22);
		contentPane.add(cbox_SeleccionarVenta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(300, 50, 97, 25);
		contentPane.add(btnEliminar);
		
		btnEliminar.addActionListener(new VistaVentaEventos(this, controladorVenta));
	}
	
	public void modificacion() {
		contentPane.setLayout(null);
		
		lblCliente = new JLabel("Seleccionar cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCliente.setBounds(380, 54, 140, 14);
		contentPane.add(lblCliente);
		
		lblAerolinea = new JLabel("Seleccionar aerol\u00EDnea:");
		lblAerolinea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAerolinea.setBounds(10, 99, 174, 14);
		contentPane.add(lblAerolinea);
		
		lblFechaVenta = new JLabel("Fecha venta:");
		lblFechaVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaVenta.setBounds(414, 99, 130, 14);
		contentPane.add(lblFechaVenta);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setText("YYYY-MM-DD");
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(501, 99, 223, 20);
		contentPane.add(textFieldFecha);
		
		comboBoxPago = new JComboBox();
		comboBoxPago.addItem("Contado efectivo");
		comboBoxPago.addItem("Tarjeta de Crédito/Débito");
        comboBoxPago.setBounds(135, 148, 208, 20);
		contentPane.add(comboBoxPago);
		
		lblPago = new JLabel("Forma de pago:");
		lblPago.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPago.setBounds(43, 148, 109, 14);
		contentPane.add(lblPago);
		
		comboBoxAerolinea = new JComboBox();
		comboBoxAerolinea.setModel(new DefaultComboBoxModel(controladorVenta.listarAerolineas().toArray()));
		comboBoxAerolinea.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Aerolinea){
                	Aerolinea aerolinea = (Aerolinea) value;
                    setText(aerolinea.getNombre());
                   
                }
                return this;
            }
        } );
		comboBoxAerolinea.setBounds(135, 98, 208, 22);
		contentPane.add(comboBoxAerolinea);
		
		JLabel lblVuelo = new JLabel("Seleccionar vuelo:");
		lblVuelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVuelo.setBounds(24, 54, 136, 14);
		contentPane.add(lblVuelo);
		
		comboBoxVuelo = new JComboBox();
		comboBoxVuelo.setModel(new DefaultComboBoxModel(controladorVenta.listarVuelos().toArray()));
		comboBoxVuelo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Vuelos){
                	Vuelos vuelo = (Vuelos) value;
                    setText(vuelo.getNumeroVuelo());
                   
                }
                return this;
            }
        } );
		comboBoxVuelo.setBounds(135, 50, 208, 22);
		contentPane.add(comboBoxVuelo);
		
		comboBoxCliente = new JComboBox();
		comboBoxCliente.setModel(new DefaultComboBoxModel(controladorVenta.listarClientes().toArray()));
		comboBoxCliente.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Cliente){
                	Cliente cliente = (Cliente) value;
                    setText(cliente.getNombre() + " " + cliente.getApellido());
                }
                return this;
            }
        } );
		comboBoxCliente.setBounds(501, 50, 223, 22);
		contentPane.add(comboBoxCliente);
		
		lblSeleccionarVenta = new JLabel("Seleccionar venta:");
		lblSeleccionarVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeleccionarVenta.setBounds(24, 11, 136, 14);
		contentPane.add(lblSeleccionarVenta);
		
		cbox_SeleccionarVenta = new JComboBox();
		cbox_SeleccionarVenta.setModel(new DefaultComboBoxModel(controladorVenta.listarVentas().toArray()));
		cbox_SeleccionarVenta.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Ventas){
                	Ventas venta = (Ventas) value;
                    setText("Vuelo: "  + venta.getVuelo().getNumeroVuelo() + " - Cliente: " + venta.getCliente().getNombre() + " " + venta.getCliente().getApellido() );
                }
                return this;
            }
        } );
		cbox_SeleccionarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venta = (Ventas) cbox_SeleccionarVenta.getSelectedItem();
				
				comboBoxPago.setSelectedIndex(0);
				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				String fecha = df.format(venta.getFechaVenta());
				textFieldFecha.setText(fecha);
				comboBoxAerolinea.setSelectedIndex((int) venta.getAerolinea().getId()-1);
				comboBoxVuelo.setSelectedIndex((int) venta.getVuelo().getId()-1);
				comboBoxCliente.setSelectedIndex((int) venta.getCliente().getId()-1);
			}
		});
		cbox_SeleccionarVenta.setBounds(135, 7, 589, 22);
		contentPane.add(cbox_SeleccionarVenta);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(309, 209, 89, 23);
		contentPane.add(btnModificar);
		
		btnModificar.addActionListener(new VistaVentaEventos(this, controladorVenta));
	}
	
	public void consulta() {
		contentPane.setLayout(null);
		
		ArrayList<Ventas> ventas = (ArrayList<Ventas>) controladorVenta.listarVentas();
		DefaultTableModel tableModel = new DefaultTableModel();
		tabla = new JTable(tableModel);
		pane = new JScrollPane(tabla);
		
		tableModel.addColumn("Nombre cliente");
		tableModel.addColumn("Apellido cliente");
		tableModel.addColumn("Fecha");
		tableModel.addColumn("Vuelo");
		tableModel.addColumn("Aerolínea");
		tableModel.addColumn("Forma pago");		
			
		pane.setBounds(12, 20, 250, 20);
		contentPane.add(pane);
		
		pane.setSize(700, 500);
		pane.setVisible(true);
	
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < ventas.size(); i++) {
			fila[0] = ventas.get(i).getCliente().getNombre();
			fila[1] = ventas.get(i).getCliente().getApellido();
			fila[2] = ventas.get(i).getFechaVenta();
			fila[3] = ventas.get(i).getVuelo().getNumeroVuelo();
			fila[4] = ventas.get(i).getAerolinea().getNombre();
			fila[5] = ventas.get(i).getFormaPago();
			tableModel.addRow(fila);
		}
	
	}

}

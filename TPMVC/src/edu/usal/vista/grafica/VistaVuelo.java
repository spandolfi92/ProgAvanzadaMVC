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

import edu.usal.controlador.grafica.ControladorVuelo;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Vuelos;

public class VistaVuelo extends JPanel {
	
	private ControladorVuelo controladorVuelo;
	private JPanel contentPane;
	private JLabel lblNumero;
    private JTextField textFieldNumero;
    private JLabel lblAsientos;
    private JTextField textFieldAsientos;
    private JLabel lblFechaDeSalida;
    private JTextField textFieldSalida;
    private JLabel lblFechaDeLlegada;
    private JTextField textFieldLlegada;
    private JLabel lblTiempoDeVuelo;
    private JTextField textFieldTiempo;
    private JLabel lblAerolnea;
    private JComboBox comboBoxAerolinea;
    private JLabel lblAeropuertoSalida;
    private JComboBox comboBoxAeroSalida;
    private JLabel lblAeropuertoLlegada;
    private JComboBox comboBoxAeroLlegada;
    private JButton btnAgregar;
    public static JComboBox<Vuelos> cbox_SeleccionarVuelo;
    private JButton btnEliminar;
    private JButton btnModificar;
    Vuelos vuelo = new Vuelos();
    private JTable tabla;
	private JScrollPane pane;


	public VistaVuelo(ControladorVuelo controladorVuelo, JPanel contentPane, String accion) {
		this.controladorVuelo = controladorVuelo;
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
	
	
	
	public JButton getBtnModificar() {
		return btnModificar;
	}



	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}



	public JButton getBtnEliminar() {
		return btnEliminar;
	}



	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}



	public static JComboBox<Vuelos> getCbox_SeleccionarVuelo() {
		return cbox_SeleccionarVuelo;
	}



	public static void setCbox_SeleccionarVuelo(JComboBox<Vuelos> cbox_SeleccionarVuelo) {
		VistaVuelo.cbox_SeleccionarVuelo = cbox_SeleccionarVuelo;
	}



	public JTextField getTextFieldNumero() {
		return textFieldNumero;
	}



	public void setTextFieldNumero(JTextField textFieldNumero) {
		this.textFieldNumero = textFieldNumero;
	}



	public JTextField getTextFieldAsientos() {
		return textFieldAsientos;
	}



	public void setTextFieldAsientos(JTextField textFieldAsientos) {
		this.textFieldAsientos = textFieldAsientos;
	}



	public JTextField getTextFieldSalida() {
		return textFieldSalida;
	}



	public void setTextFieldSalida(JTextField textFieldSalida) {
		this.textFieldSalida = textFieldSalida;
	}



	public JTextField getTextFieldLlegada() {
		return textFieldLlegada;
	}



	public void setTextFieldLlegada(JTextField textFieldLlegada) {
		this.textFieldLlegada = textFieldLlegada;
	}



	public JTextField getTextFieldTiempo() {
		return textFieldTiempo;
	}



	public void setTextFieldTiempo(JTextField textFieldTiempo) {
		this.textFieldTiempo = textFieldTiempo;
	}



	public JComboBox getComboBoxAerolinea() {
		return comboBoxAerolinea;
	}



	public void setComboBoxAerolinea(JComboBox comboBoxAerolinea) {
		this.comboBoxAerolinea = comboBoxAerolinea;
	}



	public JComboBox getComboBoxAeroSalida() {
		return comboBoxAeroSalida;
	}



	public void setComboBoxAeroSalida(JComboBox comboBoxAeroSalida) {
		this.comboBoxAeroSalida = comboBoxAeroSalida;
	}



	public JComboBox getComboBoxAeroLlegada() {
		return comboBoxAeroLlegada;
	}



	public void setComboBoxAeroLlegada(JComboBox comboBoxAeroLlegada) {
		this.comboBoxAeroLlegada = comboBoxAeroLlegada;
	}



	public JButton getBtnAgregar() {
		return btnAgregar;
	}



	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}



	public void alta() {
		contentPane.setLayout(null);
		
		lblNumero = new JLabel("N\u00FAmero de vuelo:");
		lblNumero.setBounds(20, 26, 140, 14);
		contentPane.add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(135, 23, 208, 20);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		lblAsientos = new JLabel("Cantidad de asientos:");
		lblAsientos.setBounds(367, 26, 130, 14);
		contentPane.add(lblAsientos);
		
		textFieldAsientos = new JTextField();
		textFieldAsientos.setColumns(10);
		textFieldAsientos.setBounds(501, 23, 223, 20);
		contentPane.add(textFieldAsientos);
		
		lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setBounds(24, 75, 126, 14);
		contentPane.add(lblFechaDeSalida);
		
		textFieldSalida = new JTextField();
		textFieldSalida.setText("YYYY-MM-DD");
		textFieldSalida.setColumns(10);
		textFieldSalida.setBounds(135, 72, 208, 20);
		contentPane.add(textFieldSalida);
		
		lblFechaDeLlegada = new JLabel("Fecha de llegada:");
		lblFechaDeLlegada.setBounds(391, 75, 130, 14);
		contentPane.add(lblFechaDeLlegada);
		
		textFieldLlegada = new JTextField();
		textFieldLlegada.setText("YYYY-MM-DD");
		textFieldLlegada.setColumns(10);
		textFieldLlegada.setBounds(501, 75, 223, 20);
		contentPane.add(textFieldLlegada);
		
		lblTiempoDeVuelo = new JLabel("Tiempo de vuelo:");
		lblTiempoDeVuelo.setBounds(24, 259, 126, 14);
		contentPane.add(lblTiempoDeVuelo);
		
		textFieldTiempo = new JTextField();
		textFieldTiempo.setColumns(10);
		textFieldTiempo.setBounds(135, 256, 208, 20);
		contentPane.add(textFieldTiempo);
		
		lblAerolnea = new JLabel("Aerol\u00EDnea:");
		lblAerolnea.setBounds(52, 128, 98, 14);
		contentPane.add(lblAerolnea);
		
		comboBoxAerolinea = new JComboBox<Aerolinea>();
		comboBoxAerolinea.setModel(new DefaultComboBoxModel(controladorVuelo.listarAerolineas().toArray()));
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
		comboBoxAerolinea.setBounds(135, 124, 589, 22);
		contentPane.add(comboBoxAerolinea);
		
		lblAeropuertoSalida = new JLabel("Aeropuerto salida:");
		lblAeropuertoSalida.setBounds(14, 173, 126, 14);
		contentPane.add(lblAeropuertoSalida);
		
		comboBoxAeroSalida = new JComboBox<Aeropuerto>();
		comboBoxAeroSalida.setModel(new DefaultComboBoxModel(controladorVuelo.listarAeropuertos().toArray()));
		comboBoxAeroSalida.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Aeropuerto){
                	Aeropuerto aeropuerto = (Aeropuerto) value;
                    setText(aeropuerto.getIdentificacion());
                   
                }
                return this;
            }
        } );
		comboBoxAeroSalida.setBounds(135, 169, 589, 22);
		contentPane.add(comboBoxAeroSalida);
		
		lblAeropuertoLlegada = new JLabel("Aeropuerto llegada:");
		lblAeropuertoLlegada.setBounds(10, 217, 126, 14);
		contentPane.add(lblAeropuertoLlegada);
		
		comboBoxAeroLlegada = new JComboBox<Aeropuerto>();
		comboBoxAeroLlegada.setModel(new DefaultComboBoxModel(controladorVuelo.listarAeropuertos().toArray()));
		comboBoxAeroLlegada.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Aeropuerto){
                	Aeropuerto aeropuerto = (Aeropuerto) value;
                    setText(aeropuerto.getIdentificacion());
                   
                }
                return this;
            }
        } );
		comboBoxAeroLlegada.setBounds(135, 213, 589, 22);
		contentPane.add(comboBoxAeroLlegada);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(316, 341, 89, 23);
		contentPane.add(btnAgregar);
		
		btnAgregar.addActionListener(new VistaVueloEventos(this, controladorVuelo));
		
	}
	
	public void baja() {
		
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarVuelo = new JLabel("Seleccionar Vuelo:");
		lblSeleccionarVuelo.setBounds(12, 13, 136, 16);
		contentPane.add(lblSeleccionarVuelo);
		
		cbox_SeleccionarVuelo = new JComboBox<Vuelos>();
		cbox_SeleccionarVuelo.setModel(new DefaultComboBoxModel(controladorVuelo.listarVuelos().toArray()));
		cbox_SeleccionarVuelo.setRenderer(new DefaultListCellRenderer() {
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
		cbox_SeleccionarVuelo.setBounds(160, 10, 550, 22);
		contentPane.add(cbox_SeleccionarVuelo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(300, 50, 97, 25);
		contentPane.add(btnEliminar);
		
		btnEliminar.addActionListener(new VistaVueloEventos(this, controladorVuelo));
		
	}
	
	
	
	public void modificacion() {
		
		contentPane.setLayout(null);
		
		lblNumero = new JLabel("N\u00FAmero de vuelo:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumero.setBounds(401, 32, 140, 14);
		contentPane.add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(516, 29, 208, 20);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		lblAsientos = new JLabel("Cantidad de asientos:");
		lblAsientos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAsientos.setBounds(367, 259, 130, 14);
		contentPane.add(lblAsientos);
		
		textFieldAsientos = new JTextField();
		textFieldAsientos.setColumns(10);
		textFieldAsientos.setBounds(501, 256, 223, 20);
		contentPane.add(textFieldAsientos);
		
		lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDeSalida.setBounds(24, 75, 126, 14);
		contentPane.add(lblFechaDeSalida);
		
		textFieldSalida = new JTextField();
		textFieldSalida.setText("YYYY-MM-DD");
		textFieldSalida.setColumns(10);
		textFieldSalida.setBounds(135, 72, 208, 20);
		contentPane.add(textFieldSalida);
		
		lblFechaDeLlegada = new JLabel("Fecha de llegada:");
		lblFechaDeLlegada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDeLlegada.setBounds(391, 75, 130, 14);
		contentPane.add(lblFechaDeLlegada);
		
		textFieldLlegada = new JTextField();
		textFieldLlegada.setText("YYYY-MM-DD");
		textFieldLlegada.setColumns(10);
		textFieldLlegada.setBounds(501, 75, 223, 20);
		contentPane.add(textFieldLlegada);
		
		lblTiempoDeVuelo = new JLabel("Tiempo de vuelo:");
		lblTiempoDeVuelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTiempoDeVuelo.setBounds(24, 259, 126, 14);
		contentPane.add(lblTiempoDeVuelo);
		
		textFieldTiempo = new JTextField();
		textFieldTiempo.setColumns(10);
		textFieldTiempo.setBounds(135, 256, 208, 20);
		contentPane.add(textFieldTiempo);
		
		lblAerolnea = new JLabel("Aerol\u00EDnea:");
		lblAerolnea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAerolnea.setBounds(52, 128, 98, 14);
		contentPane.add(lblAerolnea);
		
		comboBoxAerolinea = new JComboBox();
		comboBoxAerolinea.setModel(new DefaultComboBoxModel(controladorVuelo.listarAerolineas().toArray()));
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
		comboBoxAerolinea.setBounds(135, 124, 589, 22);
		contentPane.add(comboBoxAerolinea);
		
		lblAeropuertoSalida = new JLabel("Aeropuerto salida:");
		lblAeropuertoSalida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAeropuertoSalida.setBounds(14, 173, 126, 14);
		contentPane.add(lblAeropuertoSalida);
		
		comboBoxAeroSalida = new JComboBox();
		comboBoxAeroSalida.setModel(new DefaultComboBoxModel(controladorVuelo.listarAeropuertos().toArray()));
		comboBoxAeroSalida.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Aeropuerto){
                	Aeropuerto aeropuerto = (Aeropuerto) value;
                    setText(aeropuerto.getIdentificacion());
                   
                }
                return this;
            }
        } );
		comboBoxAeroSalida.setBounds(135, 169, 589, 22);
		contentPane.add(comboBoxAeroSalida);
		
		lblAeropuertoLlegada = new JLabel("Aeropuerto llegada:");
		lblAeropuertoLlegada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAeropuertoLlegada.setBounds(10, 217, 126, 14);
		contentPane.add(lblAeropuertoLlegada);
		
		comboBoxAeroLlegada = new JComboBox();
		comboBoxAeroLlegada.setModel(new DefaultComboBoxModel(controladorVuelo.listarAeropuertos().toArray()));
		comboBoxAeroLlegada.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Aeropuerto){
                	Aeropuerto aeropuerto = (Aeropuerto) value;
                    setText(aeropuerto.getIdentificacion());
                   
                }
                return this;
            }
        } );
		comboBoxAeroLlegada.setBounds(135, 213, 589, 22);
		contentPane.add(comboBoxAeroLlegada);
		
		JLabel lblSeleccionar = new JLabel("Seleccionar vuelo:");
		lblSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeleccionar.setBounds(14, 32, 136, 14);
		contentPane.add(lblSeleccionar);
		
		cbox_SeleccionarVuelo = new JComboBox();
		cbox_SeleccionarVuelo.setModel(new DefaultComboBoxModel(controladorVuelo.listarVuelos().toArray()));
		cbox_SeleccionarVuelo.setRenderer(new DefaultListCellRenderer() {
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
		cbox_SeleccionarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuelo = (Vuelos) cbox_SeleccionarVuelo.getSelectedItem();
				
				textFieldNumero.setText(vuelo.getNumeroVuelo());
				textFieldTiempo.setText(vuelo.getTiempoVuelo());
				int parse = vuelo.getCantidadAsientos();
				String cantidadAsientos= Integer.toString(parse);
				textFieldAsientos.setText(cantidadAsientos);
				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				String fechaSalida = df.format(vuelo.getFechaSalida());
				textFieldSalida.setText(fechaSalida);
				DateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");
				String fechaLlegada = df2.format(vuelo.getFechaLlegada());
				textFieldLlegada.setText(fechaLlegada);
				
				comboBoxAerolinea.setSelectedIndex((int) vuelo.getAerolinea().getId()-1);
				comboBoxAeroSalida.setSelectedIndex((int) vuelo.getAeropuertoSalida().getId()-1);
				comboBoxAeroLlegada.setSelectedIndex((int) vuelo.getAeropuertoLlegada().getId()-1);
			
			}
		});
		cbox_SeleccionarVuelo.setBounds(135, 28, 208, 22);
		contentPane.add(cbox_SeleccionarVuelo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(316, 341, 89, 23);
		contentPane.add(btnModificar);
		
		btnModificar.addActionListener(new VistaVueloEventos(this, controladorVuelo));
		
	}
	
	public void consulta() {
		contentPane.setLayout(null);
		
		ArrayList<Vuelos> vuelos = (ArrayList<Vuelos>) controladorVuelo.listarVuelos();
		DefaultTableModel tableModel = new DefaultTableModel();
		tabla = new JTable(tableModel);
		pane = new JScrollPane(tabla);
		
		tableModel.addColumn("Código");
		tableModel.addColumn("Salida");
		tableModel.addColumn("Llegada");
		tableModel.addColumn("Tiempo");
		tableModel.addColumn("Aer. Salida");
		tableModel.addColumn("Aer. Llegada");
		tableModel.addColumn("Aerolínea");
		tableModel.addColumn("Asientos");
			
		pane.setBounds(12, 20, 250, 20);
		contentPane.add(pane);
		
		pane.setSize(700, 500);
		pane.setVisible(true);
	
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < vuelos.size(); i++) {
			fila[0] = vuelos.get(i).getNumeroVuelo();
			fila[1] = vuelos.get(i).getFechaSalida();
			fila[2] = vuelos.get(i).getFechaLlegada();
			fila[3] = vuelos.get(i).getTiempoVuelo();
			fila[4] = vuelos.get(i).getAeropuertoSalida().getIdentificacion();
			fila[5] = vuelos.get(i).getAeropuertoLlegada().getIdentificacion();
			fila[6] = vuelos.get(i).getAerolinea().getNombre();
			fila[7] = vuelos.get(i).getCantidadAsientos();
			tableModel.addRow(fila);
		}
		
		
	}
	

}

package edu.usal.vista.grafica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import edu.usal.controlador.grafica.ControladorAerolinea;
import edu.usal.negocio.dominio.Aerolinea;
import edu.usal.negocio.dominio.Alianza;


public class VistaAerolinea extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControladorAerolinea controladorAerolinea;
	private JPanel contentPane;
	private JTextField txt_nombreAerolinea;
	public static JComboBox<Alianza> cboxAlianza;
	private JButton btnAceptar;
	public static JComboBox<Aerolinea> cbox_SeleccionarAerolinea;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTable tabla;
	private JScrollPane pane;
	
	
	public VistaAerolinea(ControladorAerolinea controladorAerolinea, JPanel contentPane, String accion) {
		
		this.controladorAerolinea = controladorAerolinea;
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



	public static JComboBox<Aerolinea> getCbox_SeleccionarAerolinea() {
		return cbox_SeleccionarAerolinea;
	}



	public static void setCbox_SeleccionarAerolinea(JComboBox<Aerolinea> cbox_SeleccionarAerolinea) {
		VistaAerolinea.cbox_SeleccionarAerolinea = cbox_SeleccionarAerolinea;
	}



	public JButton getBtnEliminar() {
		return btnEliminar;
	}



	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}



	public JTextField getTxt_nombreAerolinea() {
		return txt_nombreAerolinea;
	}



	public void setTxt_nombreAerolinea(JTextField txt_nombreAerolinea) {
		this.txt_nombreAerolinea = txt_nombreAerolinea;
	}



	public static JComboBox<Alianza> getCboxAlianza() {
		return cboxAlianza;
	}



	public static void setCboxAlianza(JComboBox<Alianza> cboxAlianza) {
		VistaAerolinea.cboxAlianza = cboxAlianza;
	}



	public JButton getBtnAceptar() {
		return btnAceptar;
	}



	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}



	public void alta() {
		
		contentPane.setLayout(null);
		
		JLabel lblNombreDeLaAerolinea = new JLabel("Nombre de la Aerolinea: ");
		lblNombreDeLaAerolinea.setBounds(12, 13, 151, 16);
		contentPane.add(lblNombreDeLaAerolinea);
		
		txt_nombreAerolinea = new JTextField();
		txt_nombreAerolinea.setBounds(159, 10, 550, 22);
		contentPane.add(txt_nombreAerolinea);
		txt_nombreAerolinea.setColumns(10);
		
		JLabel lblSeleccioneAlianza = new JLabel("Seleccione Alianza:");
		lblSeleccioneAlianza.setBounds(12, 76, 127, 16);
		contentPane.add(lblSeleccioneAlianza);
		
		cboxAlianza = new JComboBox<Alianza>();
		cboxAlianza.setModel(new DefaultComboBoxModel(controladorAerolinea.listarAlianzas().toArray()));
		cboxAlianza.setRenderer(new DefaultListCellRenderer() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Alianza){
                	Alianza alianza = (Alianza) value;
                    setText(alianza.getNombre());
                }
                return this;
            }
        } );
		cboxAlianza.setBounds(159, 73, 550, 22);
		contentPane.add(cboxAlianza);
		
		btnAceptar = new JButton("Agregar");
		btnAceptar.setBounds(300, 169, 107, 25);
		contentPane.add(btnAceptar,BorderLayout.CENTER);
		
		btnAceptar.addActionListener(new VistaAerolineaEventos(this, controladorAerolinea));
	}
	
	
	public void baja() {
		
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarAerolinea = new JLabel("Seleccionar Aerolinea:");
		lblSeleccionarAerolinea.setBounds(12, 13, 136, 16);
		contentPane.add(lblSeleccionarAerolinea);
		
		cbox_SeleccionarAerolinea = new JComboBox<Aerolinea>();
		cbox_SeleccionarAerolinea.setModel(new DefaultComboBoxModel(controladorAerolinea.listarAerolineas().toArray()));
		cbox_SeleccionarAerolinea.setRenderer(new DefaultListCellRenderer() {
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
		cbox_SeleccionarAerolinea.setBounds(160, 10, 550, 22);
		contentPane.add(cbox_SeleccionarAerolinea);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(300, 50, 97, 25);
		contentPane.add(btnEliminar);
		
		btnEliminar.addActionListener(new VistaAerolineaEventos(this, controladorAerolinea));
		
	}
	
	
	public void modificacion() {
		
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarAerolinea = new JLabel("Seleccionar Aerolinea:");
		lblSeleccionarAerolinea.setBounds(12, 13, 187, 16);
		contentPane.add(lblSeleccionarAerolinea);
		
		cbox_SeleccionarAerolinea = new JComboBox<Aerolinea>();
		cbox_SeleccionarAerolinea.setModel(new DefaultComboBoxModel(controladorAerolinea.listarAerolineas().toArray()));
		cbox_SeleccionarAerolinea.setRenderer(new DefaultListCellRenderer() {
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
		cbox_SeleccionarAerolinea.setBounds(209, 10, 500, 22);
		contentPane.add(cbox_SeleccionarAerolinea);
		
		JLabel lblModificar = new JLabel("Ingrese el nuevo nombre:");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblModificar.setBounds(12, 60, 181, 16);
		contentPane.add(lblModificar);
		
		txt_nombreAerolinea = new JTextField();
		txt_nombreAerolinea.setBounds(209, 57, 500, 22);
		contentPane.add(txt_nombreAerolinea);
		txt_nombreAerolinea.setColumns(10);
		
		JLabel lblSeleccioneAlianza = new JLabel("Seleccione la nueva Alianza:");
		lblSeleccioneAlianza.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSeleccioneAlianza.setBounds(12, 105, 181, 16);
		contentPane.add(lblSeleccioneAlianza);
	
		cboxAlianza = new JComboBox<Alianza>();
		cboxAlianza.setModel(new DefaultComboBoxModel(controladorAerolinea.listarAlianzas().toArray()));
		cboxAlianza.setRenderer(new DefaultListCellRenderer() {
       		private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Alianza){
                	Alianza alianza = (Alianza) value;
                    setText(alianza.getNombre());
                }
                return this;
            }
        } );
		cboxAlianza.setBounds(209, 102, 500, 22);
		contentPane.add(cboxAlianza);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(300, 169, 97, 25);
		contentPane.add(btnModificar,BorderLayout.CENTER);
		
		btnModificar.addActionListener(new VistaAerolineaEventos(this, controladorAerolinea));
		
	}
	
	public void consulta() {
		
		contentPane.setLayout(null);
		
		ArrayList<Aerolinea> aerolineas = (ArrayList<Aerolinea>) controladorAerolinea.listarAerolineas();
		DefaultTableModel tableModel = new DefaultTableModel();
		tabla = new JTable(tableModel);
		pane = new JScrollPane(tabla);
		
		tableModel.addColumn("Id");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Alianza");
		pane.setBounds(12, 20, 250, 20);
		contentPane.add(pane);
		
		pane.setSize(700, 500);
		pane.setVisible(true);
	
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < aerolineas.size(); i++) {
			fila[0] = aerolineas.get(i).getId();
			fila[1] = aerolineas.get(i).getNombre();
			fila[2] = aerolineas.get(i).getAlianza();
			tableModel.addRow(fila);
		}

		
	}


}

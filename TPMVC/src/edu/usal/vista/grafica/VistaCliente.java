package edu.usal.vista.grafica;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.usal.controlador.grafica.ControladorAerolinea;
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

public class VistaCliente extends JPanel {

	private ControladorCliente controladorCliente;
	private ControladorAerolinea controladorAerolinea;
	private JPanel contentPane;
	private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldDNI;
    private JLabel lblCuitcuil;
    private JTextField textFieldCuitCuil;
    private JLabel lblDatosBsicosDel;
    private JLabel lblFechaDeNacimiento;
    private JTextField textFieldFechaNac;
    private JLabel lblEmail;
    private JTextField textFieldEmail;
    private JLabel lblIngreseLosDatos;
    private JLabel lblNumero;
    private JTextField textFieldNumeroPas;
    private JTextField textFieldAutoridadEm;
    private JLabel lblAutoridadEm;
    private JLabel lblFechaDeEmisin;
    private JTextField textFieldFechaEmision;
    private JTextField textFieldFechaVencimiento;
    private JLabel lblFechaVto;
    private JLabel lblPais;
    private JTextField textFieldCelular;
    private JTextField textFieldPersonal;
    private JTextField textFieldLaboral;
    private JSeparator separator_1;
    private JSeparator separator_2;
    private JLabel lblNmero;
    private JTextField textFieldNumeroPasajeroFrec;
    private JLabel lblCategoria;
    private JTextField textFieldCategoriaPasFrec;
    private JLabel lblAlianza;
    private JComboBox<Alianza> comboBoxAlianzaPasFrec;
    private JLabel lblAerolnea;
    private JComboBox<Aerolinea> comboBoxAerPasFrec;
    private JSeparator separator_3;
    private JLabel lblIngreseLosDatos_3;
    private JLabel lblCalle;
    private JTextField textFieldCalle;
    private JLabel lblAltura;
    private JTextField textFieldAltura;
    private JLabel lblCiudad;
    private JTextField textFieldCiudad;
    private JLabel lblCp;
    private JTextField textFieldCP;
    private JLabel lblProvincia;
    private JComboBox<Provincia> comboBoxProvincia;
    private JLabel lblPaisDirec;
    private JComboBox comboBoxPaisDirec;
    private JComboBox comboBoxPaisPasaporte;
    private JButton btnAgregar;
    public static JComboBox<Cliente> comboBoxCliente;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTable tabla;
	private JScrollPane pane;
	JLabel lblNuevoPais = new JLabel("Pais:");
	JTextField textFieldNuevoPais = new JTextField();
	JLabel lblNuevoPais2 = new JLabel("Pais:");
	JTextField textFieldNuevoPais2 = new JTextField();
	
	public VistaCliente(ControladorCliente controladorCliente, JPanel contentPane, String accion) {
		this.controladorCliente = controladorCliente;
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
	
	
	
	public JTextField getTextFieldNuevoPais() {
		return textFieldNuevoPais;
	}



	public void setTextFieldNuevoPais(JTextField textFieldNuevoPais) {
		this.textFieldNuevoPais = textFieldNuevoPais;
	}



	public JButton getBtnModificar() {
		return btnModificar;
	}



	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}



	public static JComboBox<Cliente> getComboBoxCliente() {
		return comboBoxCliente;
	}



	public static void setComboBoxCliente(JComboBox<Cliente> comboBoxCliente) {
		VistaCliente.comboBoxCliente = comboBoxCliente;
	}



	public JTextField getTextFieldNuevoPais2() {
		return textFieldNuevoPais2;
	}



	public void setTextFieldNuevoPais2(JTextField textFieldNuevoPais2) {
		this.textFieldNuevoPais2 = textFieldNuevoPais2;
	}



	public JButton getBtnEliminar() {
		return btnEliminar;
	}



	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}



	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}



	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}



	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}



	public void setTextFieldApellido(JTextField textFieldApellido) {
		this.textFieldApellido = textFieldApellido;
	}



	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}



	public void setTextFieldDNI(JTextField textFieldDNI) {
		this.textFieldDNI = textFieldDNI;
	}



	public JTextField getTextFieldCuitCuil() {
		return textFieldCuitCuil;
	}



	public void setTextFieldCuitCuil(JTextField textFieldCuitCuil) {
		this.textFieldCuitCuil = textFieldCuitCuil;
	}



	public JTextField getTextFieldFechaNac() {
		return textFieldFechaNac;
	}



	public void setTextFieldFechaNac(JTextField textFieldFechaNac) {
		this.textFieldFechaNac = textFieldFechaNac;
	}



	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}



	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}



	public JTextField getTextFieldNumeroPas() {
		return textFieldNumeroPas;
	}



	public void setTextFieldNumeroPas(JTextField textFieldNumeroPas) {
		this.textFieldNumeroPas = textFieldNumeroPas;
	}



	public JTextField getTextFieldAutoridadEm() {
		return textFieldAutoridadEm;
	}



	public void setTextFieldAutoridadEm(JTextField textFieldAutoridadEm) {
		this.textFieldAutoridadEm = textFieldAutoridadEm;
	}



	public JTextField getTextFieldFechaEmision() {
		return textFieldFechaEmision;
	}



	public void setTextFieldFechaEmision(JTextField textFieldFechaEmision) {
		this.textFieldFechaEmision = textFieldFechaEmision;
	}



	public JTextField getTextFieldFechaVencimiento() {
		return textFieldFechaVencimiento;
	}



	public void setTextFieldFechaVencimiento(JTextField textFieldFechaVencimiento) {
		this.textFieldFechaVencimiento = textFieldFechaVencimiento;
	}



	public JTextField getTextFieldCelular() {
		return textFieldCelular;
	}



	public void setTextFieldCelular(JTextField textFieldCelular) {
		this.textFieldCelular = textFieldCelular;
	}



	public JTextField getTextFieldPersonal() {
		return textFieldPersonal;
	}



	public void setTextFieldPersonal(JTextField textFieldPersonal) {
		this.textFieldPersonal = textFieldPersonal;
	}



	public JTextField getTextFieldLaboral() {
		return textFieldLaboral;
	}



	public void setTextFieldLaboral(JTextField textFieldLaboral) {
		this.textFieldLaboral = textFieldLaboral;
	}



	public JTextField getTextFieldNumeroPasajeroFrec() {
		return textFieldNumeroPasajeroFrec;
	}



	public void setTextFieldNumeroPasajeroFrec(JTextField textFieldNumeroPasajeroFrec) {
		this.textFieldNumeroPasajeroFrec = textFieldNumeroPasajeroFrec;
	}



	public JTextField getTextFieldCategoriaPasFrec() {
		return textFieldCategoriaPasFrec;
	}



	public void setTextFieldCategoriaPasFrec(JTextField textFieldCategoriaPasFrec) {
		this.textFieldCategoriaPasFrec = textFieldCategoriaPasFrec;
	}



	public JComboBox<Alianza> getComboBoxAlianzaPasFrec() {
		return comboBoxAlianzaPasFrec;
	}



	public void setComboBoxAlianzaPasFrec(JComboBox<Alianza> comboBoxAlianzaPasFrec) {
		this.comboBoxAlianzaPasFrec = comboBoxAlianzaPasFrec;
	}



	public JComboBox<Aerolinea> getComboBoxAerPasFrec() {
		return comboBoxAerPasFrec;
	}



	public void setComboBoxAerPasFrec(JComboBox<Aerolinea> comboBoxAerPasFrec) {
		this.comboBoxAerPasFrec = comboBoxAerPasFrec;
	}



	public JTextField getTextFieldCalle() {
		return textFieldCalle;
	}



	public void setTextFieldCalle(JTextField textFieldCalle) {
		this.textFieldCalle = textFieldCalle;
	}



	public JTextField getTextFieldAltura() {
		return textFieldAltura;
	}



	public void setTextFieldAltura(JTextField textFieldAltura) {
		this.textFieldAltura = textFieldAltura;
	}



	public JTextField getTextFieldCiudad() {
		return textFieldCiudad;
	}



	public void setTextFieldCiudad(JTextField textFieldCiudad) {
		this.textFieldCiudad = textFieldCiudad;
	}



	public JTextField getTextFieldCP() {
		return textFieldCP;
	}



	public void setTextFieldCP(JTextField textFieldCP) {
		this.textFieldCP = textFieldCP;
	}



	public JComboBox<Provincia> getComboBoxProvincia() {
		return comboBoxProvincia;
	}



	public void setComboBoxProvincia(JComboBox<Provincia> comboBoxProvincia) {
		this.comboBoxProvincia = comboBoxProvincia;
	}



	public JComboBox getComboBoxPaisDirec() {
		return comboBoxPaisDirec;
	}



	public void setComboBoxPaisDirec(JComboBox comboBoxPaisDirec) {
		this.comboBoxPaisDirec = comboBoxPaisDirec;
	}



	public JComboBox getComboBoxPaisPasaporte() {
		return comboBoxPaisPasaporte;
	}



	public void setComboBoxPaisPasaporte(JComboBox comboBoxPaisPasaporte) {
		this.comboBoxPaisPasaporte = comboBoxPaisPasaporte;
	}



	public JButton getBtnAgregar() {
		return btnAgregar;
	}



	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}



	public void alta() {
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(10, 29, 108, 24);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(61, 31, 145, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(247, 29, 108, 24);
		contentPane.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(297, 31, 145, 20);
		contentPane.add(textFieldApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDni.setBounds(548, 29, 108, 24);
		contentPane.add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(579, 31, 145, 20);
		contentPane.add(textFieldDNI);
		
		lblCuitcuil = new JLabel("Cuit/Cuil:");
		lblCuitcuil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCuitcuil.setBounds(10, 60, 108, 24);
		contentPane.add(lblCuitcuil);
		
		textFieldCuitCuil = new JTextField();
		textFieldCuitCuil.setColumns(10);
		textFieldCuitCuil.setBounds(61, 62, 145, 20);
		contentPane.add(textFieldCuitCuil);
		
		lblDatosBsicosDel = new JLabel("Ingrese los datos b\u00E1sicos del cliente:");
		lblDatosBsicosDel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosBsicosDel.setBounds(10, 0, 247, 24);
		contentPane.add(lblDatosBsicosDel);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDeNacimiento.setBounds(468, 64, 136, 24);
		contentPane.add(lblFechaDeNacimiento);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setText("YYYY-MM-DD");
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(579, 64, 145, 20);
		contentPane.add(textFieldFechaNac);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(246, 62, 108, 24);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(297, 64, 145, 20);
		contentPane.add(textFieldEmail);
		
		lblIngreseLosDatos = new JLabel("Ingrese los datos del Pasaporte:");
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos.setBounds(10, 95, 247, 24);
		contentPane.add(lblIngreseLosDatos);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumero.setBounds(10, 124, 108, 24);
		contentPane.add(lblNumero);
		
		textFieldNumeroPas = new JTextField();
		textFieldNumeroPas.setColumns(10);
		textFieldNumeroPas.setBounds(61, 126, 145, 20);
		contentPane.add(textFieldNumeroPas);
		
		textFieldAutoridadEm = new JTextField();
		textFieldAutoridadEm.setColumns(10);
		textFieldAutoridadEm.setBounds(297, 126, 145, 20);
		contentPane.add(textFieldAutoridadEm);
		
		lblAutoridadEm = new JLabel("Autoridad:");
		lblAutoridadEm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAutoridadEm.setBounds(246, 124, 108, 24);
		contentPane.add(lblAutoridadEm);
		
		lblFechaDeEmisin = new JLabel("Fecha de emisi\u00F3n:");
		lblFechaDeEmisin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDeEmisin.setBounds(486, 124, 136, 24);
		contentPane.add(lblFechaDeEmisin);
		
		textFieldFechaEmision = new JTextField();
		textFieldFechaEmision.setText("YYYY-MM-DD");
		textFieldFechaEmision.setColumns(10);
		textFieldFechaEmision.setBounds(579, 124, 145, 20);
		contentPane.add(textFieldFechaEmision);
		
		textFieldFechaVencimiento = new JTextField();
		textFieldFechaVencimiento.setText("YYYY-MM-DD");
		textFieldFechaVencimiento.setColumns(10);
		textFieldFechaVencimiento.setBounds(579, 159, 145, 20);
		contentPane.add(textFieldFechaVencimiento);
		
		lblFechaVto = new JLabel("Fecha de vencimiento:");
		lblFechaVto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaVto.setBounds(464, 157, 123, 24);
		contentPane.add(lblFechaVto);
		
		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPais.setBounds(10, 159, 108, 24);
		contentPane.add(lblPais);
		
		
		
		comboBoxPaisPasaporte = new JComboBox<Pais>();
		comboBoxPaisPasaporte.setModel(new DefaultComboBoxModel(controladorCliente.obtenerPaises().toArray()));
		comboBoxPaisPasaporte.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Pais){
                	Pais pais = (Pais) value;
                    setText(pais.getNombre());
                }
                return this;
            }
        } );
		comboBoxPaisPasaporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais();
				pais = (Pais) comboBoxPaisPasaporte.getSelectedItem();
				
				
				if(pais.getNombre().equals("Otro")) {
										
					lblNuevoPais.setVisible(true);
					textFieldNuevoPais.setVisible(true);
					
					lblNuevoPais.setFont(new Font("Tahoma", Font.PLAIN, 11));
					lblNuevoPais.setBounds(246, 157, 108, 24);
					contentPane.add(lblNuevoPais);
					
					textFieldNuevoPais.setColumns(10);
					textFieldNuevoPais.setBounds(297, 159, 145, 20);
					contentPane.add(textFieldNuevoPais);
										
					contentPane.repaint();
				}
				
				else {
					lblNuevoPais.setVisible(false);
					textFieldNuevoPais.setVisible(false);
				}
				
			
			}
		});
		comboBoxPaisPasaporte.setBounds(61, 159, 145, 22);
		contentPane.add(comboBoxPaisPasaporte);
		
		JLabel lblIngreseLosDatos_1 = new JLabel("Ingrese los datos del Tel\u00E9fono:");
		lblIngreseLosDatos_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos_1.setBounds(10, 194, 247, 24);
		contentPane.add(lblIngreseLosDatos_1);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCelular.setBounds(10, 225, 108, 24);
		contentPane.add(lblCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setColumns(10);
		textFieldCelular.setBounds(61, 227, 145, 20);
		contentPane.add(textFieldCelular);
		
		JLabel lblPersonal = new JLabel("Personal:");
		lblPersonal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPersonal.setBounds(246, 225, 108, 24);
		contentPane.add(lblPersonal);
		
		textFieldPersonal = new JTextField();
		textFieldPersonal.setColumns(10);
		textFieldPersonal.setBounds(297, 227, 145, 20);
		contentPane.add(textFieldPersonal);
		
		JLabel lblLaboral = new JLabel("Laboral:");
		lblLaboral.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLaboral.setBounds(528, 225, 108, 24);
		contentPane.add(lblLaboral);
		
		textFieldLaboral = new JTextField();
		textFieldLaboral.setColumns(10);
		textFieldLaboral.setBounds(579, 227, 145, 20);
		contentPane.add(textFieldLaboral);
		
		JLabel lblIngreseLosDatos_2 = new JLabel("Ingrese los datos del Pasajero Frecuente:");
		lblIngreseLosDatos_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos_2.setBounds(10, 260, 345, 24);
		contentPane.add(lblIngreseLosDatos_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 95, 714, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 190, 714, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 258, 714, 2);
		contentPane.add(separator_2);
		
		lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNmero.setBounds(10, 287, 108, 24);
		contentPane.add(lblNmero);
		
		textFieldNumeroPasajeroFrec = new JTextField();
		textFieldNumeroPasajeroFrec.setColumns(10);
		textFieldNumeroPasajeroFrec.setBounds(61, 289, 145, 20);
		contentPane.add(textFieldNumeroPasajeroFrec);
		
		lblCategoria = new JLabel("Categor\u00EDa:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCategoria.setBounds(246, 287, 108, 24);
		contentPane.add(lblCategoria);
		
		textFieldCategoriaPasFrec = new JTextField();
		textFieldCategoriaPasFrec.setColumns(10);
		textFieldCategoriaPasFrec.setBounds(297, 289, 145, 20);
		textFieldCategoriaPasFrec.setText("económica");
		contentPane.add(textFieldCategoriaPasFrec);
		
		lblAlianza = new JLabel("Alianza:");
		lblAlianza.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAlianza.setBounds(528, 287, 108, 24);
		contentPane.add(lblAlianza);
		
		comboBoxAlianzaPasFrec = new JComboBox<Alianza>();
		comboBoxAlianzaPasFrec.setModel(new DefaultComboBoxModel(controladorCliente.listarAlianzas().toArray()));
		comboBoxAlianzaPasFrec.setRenderer(new DefaultListCellRenderer() {
            
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
		comboBoxAlianzaPasFrec.setBounds(579, 288, 145, 22);
		contentPane.add(comboBoxAlianzaPasFrec);
		
		lblAerolnea = new JLabel("Aerol\u00EDnea:");
		lblAerolnea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAerolnea.setBounds(10, 322, 108, 24);
		contentPane.add(lblAerolnea);
		
		comboBoxAerPasFrec = new JComboBox<Aerolinea>();
		comboBoxAerPasFrec.setModel(new DefaultComboBoxModel(controladorCliente.obtenerAerolineas().toArray()));
		comboBoxAerPasFrec.setRenderer(new DefaultListCellRenderer() {
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
		comboBoxAerPasFrec.setBounds(61, 322, 663, 22); 
		contentPane.add(comboBoxAerPasFrec);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 357, 714, 2);
		contentPane.add(separator_3);
		
		lblIngreseLosDatos_3 = new JLabel("Ingrese los datos de la Direcci\u00F3n:");
		lblIngreseLosDatos_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos_3.setBounds(10, 370, 345, 24);
		contentPane.add(lblIngreseLosDatos_3);
		
		lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCalle.setBounds(10, 400, 108, 24);
		contentPane.add(lblCalle);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setColumns(10);
		textFieldCalle.setBounds(61, 402, 145, 20);
		contentPane.add(textFieldCalle);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura.setBounds(247, 400, 108, 24);
		contentPane.add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(298, 402, 145, 20);
		contentPane.add(textFieldAltura);
		
		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCiudad.setBounds(528, 400, 108, 24);
		contentPane.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(579, 402, 145, 20);
		contentPane.add(textFieldCiudad);
		
		lblCp = new JLabel("CP:");
		lblCp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCp.setBounds(10, 433, 108, 24);
		contentPane.add(lblCp);
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		textFieldCP.setBounds(61, 435, 145, 20);
		contentPane.add(textFieldCP);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(247, 435, 108, 24);
		contentPane.add(lblProvincia);
		
		comboBoxProvincia = new JComboBox<Provincia>();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(controladorCliente.obtenerProvincias().toArray()));
		comboBoxProvincia.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Provincia){
                	Provincia provincia = (Provincia) value;
                    setText(provincia.getNombre());
                }
                return this;
            }
        } );
		comboBoxProvincia.setBounds(297, 435, 427, 22);
		contentPane.add(comboBoxProvincia);
		
		lblPaisDirec = new JLabel("Pais:");
		lblPaisDirec.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPaisDirec.setBounds(10, 468, 108, 24);
		contentPane.add(lblPaisDirec);
		
		comboBoxPaisDirec = new JComboBox<Pais>();
		comboBoxPaisDirec.setModel(new DefaultComboBoxModel(controladorCliente.obtenerPaises().toArray()));
		comboBoxPaisDirec.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Pais){
                	Pais pais = (Pais) value;
                    setText(pais.getNombre());
                }
                return this;
            }
        } );
		comboBoxPaisDirec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais();
				pais = (Pais) comboBoxPaisDirec.getSelectedItem();
				
				
				if(pais.getNombre().equals("Otro")) {
										
					lblNuevoPais2.setVisible(true);
					textFieldNuevoPais2.setVisible(true);
					
					lblNuevoPais2.setFont(new Font("Tahoma", Font.PLAIN, 11));
					lblNuevoPais2.setBounds(246, 466, 108, 24);
					contentPane.add(lblNuevoPais2);
					
					textFieldNuevoPais2.setColumns(10);
					textFieldNuevoPais2.setBounds(297, 468, 145, 20);
					contentPane.add(textFieldNuevoPais2);
										
					contentPane.repaint();
				}
				
				else {
					lblNuevoPais2.setVisible(false);
					textFieldNuevoPais2.setVisible(false);
				}
				
			
			}
		});
		comboBoxPaisDirec.setBounds(61, 468, 143, 22);
		contentPane.add(comboBoxPaisDirec);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(332, 505, 89, 23);
		contentPane.add(btnAgregar);
		
		btnAgregar.addActionListener(new VistaClienteEventos(this, controladorCliente));
	}
	
	
	
	public void baja() {
		
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Seleccionar Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCliente.setBounds(10, 13, 108, 24);
		contentPane.add(lblCliente);
		
		comboBoxCliente = new JComboBox<Cliente>();
		comboBoxCliente.setModel(new DefaultComboBoxModel(controladorCliente.listarClientes().toArray()));
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
		comboBoxCliente.setBounds(148, 13, 560, 22);
		contentPane.add(comboBoxCliente);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(300, 50, 97, 25);
		contentPane.add(btnEliminar);
		
		btnEliminar.addActionListener(new VistaClienteEventos(this, controladorCliente));
		
	}
	
	
	public void modificacion() {
		
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Seleccionar Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCliente.setBounds(10, 02, 108, 24);
		contentPane.add(lblCliente);
		
		comboBoxCliente = new JComboBox<Cliente>();
		comboBoxCliente.setModel(new DefaultComboBoxModel(controladorCliente.listarClientes().toArray()));
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
		comboBoxCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente = (Cliente) comboBoxCliente.getSelectedItem();
				
				textFieldNombre.setText(cliente.getNombre());
				textFieldApellido.setText(cliente.getApellido());
				textFieldDNI.setText(cliente.getDni());
				textFieldCuitCuil.setText(cliente.getCuitCuil());
				textFieldEmail.setText(cliente.getEmail());
				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				String fechaNac = df.format(cliente.getFechaNacimiento());
				textFieldFechaNac.setText(fechaNac);
				textFieldNumeroPas.setText(cliente.getPasaporte().getNumero());
				textFieldAutoridadEm.setText(cliente.getPasaporte().getAutoridadEmision());
				DateFormat df1 = new SimpleDateFormat("yyyy-mm-dd");
				String fechaNac1 = df1.format(cliente.getPasaporte().getFechaEmision());
				textFieldFechaEmision.setText(fechaNac1);
				DateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");
				String fechaNac2 = df2.format(cliente.getPasaporte().getFechaVencimiento());
				textFieldFechaVencimiento.setText(fechaNac2);
				textFieldCelular.setText(cliente.getTelefono().getNumeroCelular());
				textFieldPersonal.setText(cliente.getTelefono().getNumeroPersonal());
				textFieldLaboral.setText(cliente.getTelefono().getNumeroLaboral());
				textFieldNumeroPasajeroFrec.setText(cliente.getPasajeroFrecuente().getNumero());
				textFieldCategoriaPasFrec.setText(cliente.getPasajeroFrecuente().getCategoria());
				textFieldCalle.setText(cliente.getDireccion().getCalle());
				textFieldAltura.setText(cliente.getDireccion().getAltura());
				textFieldCiudad.setText(cliente.getDireccion().getCiudad());
				textFieldCP.setText(cliente.getDireccion().getCodigoPostal());
				comboBoxPaisDirec.setSelectedIndex((int) cliente.getDireccion().getPais().getId()-1);
				comboBoxProvincia.setSelectedIndex((int) cliente.getDireccion().getProvincia().getId()-1);
				comboBoxAerPasFrec.setSelectedIndex((int) cliente.getPasajeroFrecuente().getAerolinea().getId()-1);
				comboBoxAlianzaPasFrec.setSelectedItem( cliente.getPasajeroFrecuente().getAlianza());
				comboBoxPaisPasaporte.setSelectedIndex((int) cliente.getPasaporte().getPais().getId()-1);
				
			}
		});
		comboBoxCliente.setBounds(148, 02, 560, 22);
		contentPane.add(comboBoxCliente);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(10, 29, 108, 24);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(61, 31, 145, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(247, 29, 108, 24);
		contentPane.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(297, 31, 145, 20);
		contentPane.add(textFieldApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDni.setBounds(548, 29, 108, 24);
		contentPane.add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(579, 31, 145, 20);
		contentPane.add(textFieldDNI);
		
		lblCuitcuil = new JLabel("Cuit/Cuil:");
		lblCuitcuil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCuitcuil.setBounds(10, 60, 108, 24);
		contentPane.add(lblCuitcuil);
		
		textFieldCuitCuil = new JTextField();
		textFieldCuitCuil.setColumns(10);
		textFieldCuitCuil.setBounds(61, 62, 145, 20);
		contentPane.add(textFieldCuitCuil);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDeNacimiento.setBounds(468, 64, 136, 24);
		contentPane.add(lblFechaDeNacimiento);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setText("YYYY-MM-DD");
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(579, 64, 145, 20);
		contentPane.add(textFieldFechaNac);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(246, 62, 108, 24);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(297, 64, 145, 20);
		contentPane.add(textFieldEmail);
		
		lblIngreseLosDatos = new JLabel("Ingrese los datos del Pasaporte:");
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos.setBounds(10, 95, 247, 24);
		contentPane.add(lblIngreseLosDatos);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumero.setBounds(10, 124, 108, 24);
		contentPane.add(lblNumero);
		
		textFieldNumeroPas = new JTextField();
		textFieldNumeroPas.setColumns(10);
		textFieldNumeroPas.setBounds(61, 126, 145, 20);
		contentPane.add(textFieldNumeroPas);
		
		textFieldAutoridadEm = new JTextField();
		textFieldAutoridadEm.setColumns(10);
		textFieldAutoridadEm.setBounds(297, 126, 145, 20);
		contentPane.add(textFieldAutoridadEm);
		
		lblAutoridadEm = new JLabel("Autoridad:");
		lblAutoridadEm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAutoridadEm.setBounds(246, 124, 108, 24);
		contentPane.add(lblAutoridadEm);
		
		lblFechaDeEmisin = new JLabel("Fecha de emisi\u00F3n:");
		lblFechaDeEmisin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaDeEmisin.setBounds(486, 124, 136, 24);
		contentPane.add(lblFechaDeEmisin);
		
		textFieldFechaEmision = new JTextField();
		textFieldFechaEmision.setText("YYYY-MM-DD");
		textFieldFechaEmision.setColumns(10);
		textFieldFechaEmision.setBounds(579, 124, 145, 20);
		contentPane.add(textFieldFechaEmision);
		
		textFieldFechaVencimiento = new JTextField();
		textFieldFechaVencimiento.setText("YYYY-MM-DD");
		textFieldFechaVencimiento.setColumns(10);
		textFieldFechaVencimiento.setBounds(579, 159, 145, 20);
		contentPane.add(textFieldFechaVencimiento);
		
		lblFechaVto = new JLabel("Fecha de vencimiento:");
		lblFechaVto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFechaVto.setBounds(464, 157, 123, 24);
		contentPane.add(lblFechaVto);
		
		lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPais.setBounds(10, 159, 108, 24);
		contentPane.add(lblPais);
		
		comboBoxPaisPasaporte = new JComboBox<Pais>();
		comboBoxPaisPasaporte.setModel(new DefaultComboBoxModel(controladorCliente.obtenerPaises().toArray()));
		comboBoxPaisPasaporte.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Pais){
                	Pais pais = (Pais) value;
                    setText(pais.getNombre());
                }
                return this;
            }
        } );
		comboBoxPaisPasaporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais();
				pais = (Pais) comboBoxPaisPasaporte.getSelectedItem();
				
				
				if(pais.getNombre().equals("Otro")) {
										
					lblNuevoPais.setVisible(true);
					textFieldNuevoPais.setVisible(true);
					
					lblNuevoPais.setFont(new Font("Tahoma", Font.PLAIN, 11));
					lblNuevoPais.setBounds(246, 157, 108, 24);
					contentPane.add(lblNuevoPais);
					
					textFieldNuevoPais.setColumns(10);
					textFieldNuevoPais.setBounds(297, 159, 145, 20);
					contentPane.add(textFieldNuevoPais);
										
					contentPane.repaint();
				}
				
				else {
					lblNuevoPais.setVisible(false);
					textFieldNuevoPais.setVisible(false);
				}
				
			
			}
		});
		comboBoxPaisPasaporte.setBounds(61, 159, 145, 22);
		contentPane.add(comboBoxPaisPasaporte);
		
		JLabel lblIngreseLosDatos_1 = new JLabel("Ingrese los datos del Tel\u00E9fono:");
		lblIngreseLosDatos_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos_1.setBounds(10, 194, 247, 24);
		contentPane.add(lblIngreseLosDatos_1);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCelular.setBounds(10, 225, 108, 24);
		contentPane.add(lblCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setColumns(10);
		textFieldCelular.setBounds(61, 227, 145, 20);
		contentPane.add(textFieldCelular);
		
		JLabel lblPersonal = new JLabel("Personal:");
		lblPersonal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPersonal.setBounds(246, 225, 108, 24);
		contentPane.add(lblPersonal);
		
		textFieldPersonal = new JTextField();
		textFieldPersonal.setColumns(10);
		textFieldPersonal.setBounds(297, 227, 145, 20);
		contentPane.add(textFieldPersonal);
		
		JLabel lblLaboral = new JLabel("Laboral:");
		lblLaboral.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLaboral.setBounds(528, 225, 108, 24);
		contentPane.add(lblLaboral);
		
		textFieldLaboral = new JTextField();
		textFieldLaboral.setColumns(10);
		textFieldLaboral.setBounds(579, 227, 145, 20);
		contentPane.add(textFieldLaboral);
		
		JLabel lblIngreseLosDatos_2 = new JLabel("Ingrese los datos del Pasajero Frecuente:");
		lblIngreseLosDatos_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos_2.setBounds(10, 260, 345, 24);
		contentPane.add(lblIngreseLosDatos_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 95, 714, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 190, 714, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 258, 714, 2);
		contentPane.add(separator_2);
		
		lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNmero.setBounds(10, 287, 108, 24);
		contentPane.add(lblNmero);
		
		textFieldNumeroPasajeroFrec = new JTextField();
		textFieldNumeroPasajeroFrec.setColumns(10);
		textFieldNumeroPasajeroFrec.setBounds(61, 289, 145, 20);
		contentPane.add(textFieldNumeroPasajeroFrec);
		
		lblCategoria = new JLabel("Categor\u00EDa:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCategoria.setBounds(246, 287, 108, 24);
		contentPane.add(lblCategoria);
		
		textFieldCategoriaPasFrec = new JTextField();
		textFieldCategoriaPasFrec.setColumns(10);
		textFieldCategoriaPasFrec.setBounds(297, 289, 145, 20);
		contentPane.add(textFieldCategoriaPasFrec);
		
		lblAlianza = new JLabel("Alianza:");
		lblAlianza.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAlianza.setBounds(528, 287, 108, 24);
		contentPane.add(lblAlianza);
		
		comboBoxAlianzaPasFrec = new JComboBox<Alianza>();
		comboBoxAlianzaPasFrec.setModel(new DefaultComboBoxModel(controladorCliente.listarAlianzas().toArray()));
		comboBoxAlianzaPasFrec.setRenderer(new DefaultListCellRenderer() {
            
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
		comboBoxAlianzaPasFrec.setBounds(579, 288, 145, 22);
		contentPane.add(comboBoxAlianzaPasFrec);
		
		lblAerolnea = new JLabel("Aerol\u00EDnea:");
		lblAerolnea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAerolnea.setBounds(10, 322, 108, 24);
		contentPane.add(lblAerolnea);
		
		comboBoxAerPasFrec = new JComboBox<Aerolinea>();
		comboBoxAerPasFrec.setModel(new DefaultComboBoxModel(controladorCliente.obtenerAerolineas().toArray()));
		comboBoxAerPasFrec.setRenderer(new DefaultListCellRenderer() {
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
		comboBoxAerPasFrec.setBounds(61, 322, 663, 22); 
		contentPane.add(comboBoxAerPasFrec);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 357, 714, 2);
		contentPane.add(separator_3);
		
		lblIngreseLosDatos_3 = new JLabel("Ingrese los datos de la Direcci\u00F3n:");
		lblIngreseLosDatos_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLosDatos_3.setBounds(10, 370, 345, 24);
		contentPane.add(lblIngreseLosDatos_3);
		
		lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCalle.setBounds(10, 400, 108, 24);
		contentPane.add(lblCalle);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setColumns(10);
		textFieldCalle.setBounds(61, 402, 145, 20);
		contentPane.add(textFieldCalle);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura.setBounds(247, 400, 108, 24);
		contentPane.add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(298, 402, 145, 20);
		contentPane.add(textFieldAltura);
		
		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCiudad.setBounds(528, 400, 108, 24);
		contentPane.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(579, 402, 145, 20);
		contentPane.add(textFieldCiudad);
		
		lblCp = new JLabel("CP:");
		lblCp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCp.setBounds(10, 433, 108, 24);
		contentPane.add(lblCp);
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		textFieldCP.setBounds(61, 435, 145, 20);
		contentPane.add(textFieldCP);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(247, 435, 108, 24);
		contentPane.add(lblProvincia);
		
		comboBoxProvincia = new JComboBox<Provincia>();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(controladorCliente.obtenerProvincias().toArray()));
		comboBoxProvincia.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Provincia){
                	Provincia provincia = (Provincia) value;
                    setText(provincia.getNombre());
                }
                return this;
            }
        } );
		comboBoxProvincia.setBounds(297, 435, 427, 22);
		contentPane.add(comboBoxProvincia);
		
		lblPaisDirec = new JLabel("Pais:");
		lblPaisDirec.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPaisDirec.setBounds(10, 468, 108, 24);
		contentPane.add(lblPaisDirec);
		
		comboBoxPaisDirec = new JComboBox<Pais>();
		comboBoxPaisDirec.setModel(new DefaultComboBoxModel(controladorCliente.obtenerPaises().toArray()));
		comboBoxPaisDirec.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Pais){
                	Pais pais = (Pais) value;
                    setText(pais.getNombre());
                }
                return this;
            }
        } );
		comboBoxPaisDirec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais();
				pais = (Pais) comboBoxPaisDirec.getSelectedItem();
				
				
				if(pais.getNombre().equals("Otro")) {
										
					lblNuevoPais2.setVisible(true);
					textFieldNuevoPais2.setVisible(true);
					
					lblNuevoPais2.setFont(new Font("Tahoma", Font.PLAIN, 11));
					lblNuevoPais2.setBounds(246, 466, 108, 24);
					contentPane.add(lblNuevoPais2);
					
					textFieldNuevoPais2.setColumns(10);
					textFieldNuevoPais2.setBounds(297, 468, 145, 20);
					contentPane.add(textFieldNuevoPais2);
										
					contentPane.repaint();
				}
				
				else {
					lblNuevoPais2.setVisible(false);
					textFieldNuevoPais2.setVisible(false);
				}
				
			
			}
		});
		comboBoxPaisDirec.setBounds(61, 468, 143, 22);
		contentPane.add(comboBoxPaisDirec);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(332, 505, 89, 23);
		contentPane.add(btnModificar);
		
		btnModificar.addActionListener(new VistaClienteEventos(this, controladorCliente));
		
	}
	
	public void consulta() {
		
		contentPane.setLayout(null);
		
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) controladorCliente.listarClientes();
		DefaultTableModel tableModel = new DefaultTableModel();
		tabla = new JTable(tableModel);
		pane = new JScrollPane(tabla);
		
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Apellido");
		tableModel.addColumn("Dni");
		tableModel.addColumn("Fecha nac.");
		tableModel.addColumn("Email");
		tableModel.addColumn("Pasaporte");
		tableModel.addColumn("Telefono");
		tableModel.addColumn("Dirección");
		tableModel.addColumn("Altura");
		tableModel.addColumn("Pais");
		
		pane.setBounds(12, 20, 250, 20);
		contentPane.add(pane);
		
		pane.setSize(700, 500);
		pane.setVisible(true);
	
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < clientes.size(); i++) {
			fila[0] = clientes.get(i).getNombre();
			fila[1] = clientes.get(i).getApellido();
			fila[2] = clientes.get(i).getDni();
			fila[3] = clientes.get(i).getFechaNacimiento();
			fila[4] = clientes.get(i).getEmail();
			fila[5] = clientes.get(i).getPasaporte().getNumero();
			fila[6] = clientes.get(i).getTelefono().getNumeroPersonal();
			fila[7] = clientes.get(i).getDireccion().getCalle();
			fila[8] = clientes.get(i).getDireccion().getAltura();
			fila[9] = clientes.get(i).getDireccion().getPais().getNombre();
			tableModel.addRow(fila);
		}
		
	}
	
	
	

}

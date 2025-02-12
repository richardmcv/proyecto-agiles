/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Usuario;
import gestor.Conexion;
import gestor.Gestor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class IntCrearProceso extends javax.swing.JFrame {

	DefaultTableModel modeloTablaRegistrados;
	Conexion conexion;
	Gestor gestor;

	/**
	 * Creates new form Validacion
	 */
	public IntCrearProceso() {
		initComponents();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.conexion = new Conexion();
		this.setTitle("Creacion de Proceso");
		this.setLocationRelativeTo(null);
		this.tablaUsuariosRegistrados.cargarTabla();
		this.tablaUsuariosProcesar.cargarTablaSinDatos();
		this.tablaUsuariosRegistrados.cambioTablas(tablaUsuariosProcesar,
				this.jTxtCantidadUsuarios, this.jTxtCantidadActivos);
		this.gestor = Gestor._getGestor();
		//this.cargarTablaUsuariosProcesar();
		//this.cargarTablaUsuariosRegistrados();

	}

	private String[] getCedulasTabla() {
		DefaultTableModel modeloTablaProceso = (DefaultTableModel) tablaUsuariosProcesar.getModel();
		String[] cedulas = new String[modeloTablaProceso.getRowCount()];
		for (int i = 0; i < cedulas.length; i++) {
			cedulas[i] = modeloTablaProceso.getValueAt(i, 0).toString();
		}
		return cedulas;
	}

	private void crearProceso() {
		if (this.tablaUsuariosProcesar.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "¡Debe seleccionar al menos a un usuario para procesar!");
		} else if (jTxtNombreProceso.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "¡Debe ingresar un nombre al proceso!");
			jTxtNombreProceso.requestFocus();
		} else {
			int idProceso = this.gestor.crearProceso(jTxtNombreProceso.getText(), getCedulasTabla());
			if (idProceso != -1) {
				int opcion = JOptionPane.showConfirmDialog(null, "El proceso ha sido creado exitosamente \n "
						+ "¿Desea ver el detalle del proceso creado?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					IntDetalleProceso intDetalle = IntDetalleProceso._getVentana();
					intDetalle.agregarDetalle(idProceso);
					this.dispose();
				}
			}
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNombreProceso = new javax.swing.JTextField();
        jBtnCrear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtCantidadUsuarios = new javax.swing.JTextField();
        jTxtCantidadActivos = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaUsuariosRegistrados = new componentes.TablaUsuarios();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuariosProcesar = new componentes.TablaUsuarios();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del proceso:");

        jTxtNombreProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNombreProcesoActionPerformed(evt);
            }
        });

        jBtnCrear.setText("Crear");
        jBtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCrearActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuarios Registrados");

        jLabel3.setText("Usuarios a Procesar");

        jLabel4.setText("Cantidad de Usuarios a Procesar:");

        jLabel5.setText("Cantidad de Activos a Procesar:");

        jTxtCantidadUsuarios.setEditable(false);

        jTxtCantidadActivos.setEditable(false);

        tablaUsuariosRegistrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaUsuariosRegistrados);

        tablaUsuariosProcesar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaUsuariosProcesar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(273, 273, 273)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtNombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtCantidadActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnCrear))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTxtCantidadActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCrear))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNombreProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNombreProcesoActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jTxtNombreProcesoActionPerformed

    private void jBtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCrearActionPerformed
		// TODO add your handling code here:
		crearProceso();
    }//GEN-LAST:event_jBtnCrearActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(IntCrearProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IntCrearProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IntCrearProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IntCrearProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IntCrearProceso().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTxtCantidadActivos;
    private javax.swing.JTextField jTxtCantidadUsuarios;
    private javax.swing.JTextField jTxtNombreProceso;
    private componentes.TablaUsuarios tablaUsuariosProcesar;
    private componentes.TablaUsuarios tablaUsuariosRegistrados;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Activo;
import entidades.Proceso;
import entidades.Usuario;
import gestor.Conexion;
import gestor.GeneradorPDF;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carri
 */
public class IntDetalleProceso extends javax.swing.JFrame {

	Conexion conexion;
	DefaultTableModel modeloTablaActivos, modeloTablaUsuarios;
	Proceso proceso;

	/**
	 * Creates new form IntDetalleProceso
	 */
	public IntDetalleProceso(String idProceso) {
		initComponents();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.conexion = new Conexion();
		try {
			this.proceso = conexion.getProceso(idProceso);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		jLblIdProceso.setText(idProceso);
		jLblNombreProceso.setText(proceso.getNombre());
		jLblFechaProceso.setText(proceso.getFecha());
		jLblEstado.setText(proceso.getEstado());
		cargarTablaActivos();
		cargarTablaUsuario();
	}

	private void cargarTablaUsuario() {
		jTblUsuarios.setDefaultRenderer(Object.class, new Render());
		String[] titulos = {"CEDULA USUARIO", "NOMBRE USUARIO", "APELLIDO USUARIO", ""};
		this.modeloTablaUsuarios = new DefaultTableModel(null, titulos) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnEliminar.setBackground(Color.red);
			btnEliminar.setForeground(Color.white);
			for (Usuario usuario : proceso.getUsuarios()) {
				Object[] datos = {usuario.getCedula(), usuario.getNombre(), usuario.getApellido(), btnEliminar};
				modeloTablaUsuarios.addRow(datos);
			}
			jTblUsuarios.setModel(modeloTablaUsuarios);
			jTblUsuarios.setRowHeight(20);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: No se ha podido comunicar con el servidor");
		}

	}

	private void cargarTablaActivos() {
		String[] titulos = {"ID ACTIVO", "ID OBJETO", "NOMBRE", "DESCRIPCION", "CEDULA USUARIO",
			"NOMBRE USUARIO", "APELLIDO USUARIO", "REVISADO", "ESTADO REVISION", "OBSERVACION REVISION"};
		this.modeloTablaActivos = new DefaultTableModel(null, titulos) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			for (Activo activo : this.proceso.getActivos()) {
				String revision = "";
				System.out.println(activo.toString());
				if (activo.getRevisionActivo() == 1) {
					revision = "REVISADO";
				}
				String[] datos = {activo.getIdPertinencia(),
					activo.getIdActivo(), activo.getNombreActivo(),
					activo.getDescripcionActivo(),
					activo.getUsuario().getCedula(),
					activo.getUsuario().getNombre(),
					activo.getUsuario().getApellido(),
					revision,
					activo.getEstadoRevisionActivo(),
					activo.getObservacionRevision()
				};
				modeloTablaActivos.addRow(datos);
			}
			jTblActivosProceso.setModel(modeloTablaActivos);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: No se ha podido comunicar con el servidor");
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTblUsuarios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblActivosProceso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLblIdProceso = new javax.swing.JLabel();
        jLblNombreProceso = new javax.swing.JLabel();
        jLblFechaProceso = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTblUsuarios.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTblUsuariosMouseMoved(evt);
            }
        });
        jTblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTblUsuariosMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTblUsuarios);

        jTblActivosProceso.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTblActivosProceso);

        jLabel1.setText("ID PROCESO:");

        jLabel2.setText("NOMBRE PROCESO:");

        jLabel3.setText("FECHA DE CREACION DEL PROCESO: ");

        jLblIdProceso.setText("ID");

        jLblNombreProceso.setText("NOMBRE");

        jLblFechaProceso.setText("FECHA");

        jLabel4.setText("USUARIOS REGISTRADOS EN EL PROCESO");

        jLabel5.setText("ACTIVOS DEL PROCESO");

        jButton1.setText("PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("ESTADO:");

        jLblEstado.setText("CREADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblNombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblFechaProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLblIdProceso)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLblEstado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLblIdProceso)
                    .addComponent(jLabel6)
                    .addComponent(jLblEstado)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLblNombreProceso))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLblFechaProceso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void generarPdf() {
		// TODO add your handling code here:
		GeneradorPDF gpdf = new GeneradorPDF();
		try {
			gpdf.generarPdf(jTblActivosProceso, proceso.getNombre());
		} catch (Exception ex) {
			Logger.getLogger(IntDetalleProceso.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		generarPdf();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblUsuariosMouseClicked
		// TODO add your handling code here:
		eliminarUsuario(evt);
    }//GEN-LAST:event_jTblUsuariosMouseClicked

    private void jTblUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblUsuariosMouseEntered
		// TODO add your handling code here:
    }//GEN-LAST:event_jTblUsuariosMouseEntered

    private void jTblUsuariosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblUsuariosMouseMoved
        // TODO add your handling code here:
		if (jTblUsuarios.columnAtPoint(evt.getPoint()) == 3){
			jTblUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}else{
			jTblUsuarios.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		//System.out.println(evt.getPoint().toString());
    }//GEN-LAST:event_jTblUsuariosMouseMoved


	private void eliminarUsuario(java.awt.event.MouseEvent evt) {
		int column = jTblUsuarios.getColumnModel().getColumnIndexAtX(evt.getX());
		int row = evt.getY() / jTblUsuarios.getRowHeight();
		if (row < jTblUsuarios.getRowCount() && row >= 0 && column < jTblUsuarios.getColumnCount() && column >= 0) {
			Object value = jTblUsuarios.getValueAt(row, column);
			String cedula = (String) jTblUsuarios.getValueAt(row, 0);
			if (value instanceof JButton) {
				((JButton) value).doClick();
				JButton btn = (JButton) value;
				try {
					this.conexion.eliminarUsuarioDeProceso(this.proceso.getIdProceso(), cedula);
					JOptionPane.showConfirmDialog(null, "Se elimino el usuario correctamente");
					IntDetalleProceso intDetalleRecarga = new IntDetalleProceso(this.proceso.getIdProceso()); 
					this.dispose();
					intDetalleRecarga.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(null, "Ocurrio un error");
				}
			}
		}
	}

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
			java.util.logging.Logger.getLogger(IntDetalleProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IntDetalleProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IntDetalleProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IntDetalleProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				String id = "1";
				new IntDetalleProceso(id).setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLblEstado;
    private javax.swing.JLabel jLblFechaProceso;
    private javax.swing.JLabel jLblIdProceso;
    private javax.swing.JLabel jLblNombreProceso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblActivosProceso;
    private javax.swing.JTable jTblUsuarios;
    // End of variables declaration//GEN-END:variables
}

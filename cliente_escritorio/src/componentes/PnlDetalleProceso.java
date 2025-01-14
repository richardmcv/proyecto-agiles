/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import entidades.Proceso;
import gestor.GeneradorPDF;
import gestor.Gestor;
import interfaces.IntUsuariosFaltantes;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author carri
 */
public class PnlDetalleProceso extends javax.swing.JPanel {

	Proceso proceso;
	int idProceso;
	JTabbedPane tabbedPane;

	/**
	 * Creates new form PnlDetalleProceso
	 */
	public PnlDetalleProceso(int idProceso) {
		initComponents();
		this.idProceso = idProceso;
		this.proceso = Gestor._getGestor().getProceso(idProceso);
		this.tablaUsuariosProceso1.cargarTabla(idProceso);
		this.tablaUsuariosProceso1.setTablaActivos(tablaActivosProceso1);
		this.tablaActivosProceso1.cargarTabla(idProceso);
		this.tablaActivosProceso1.setPanel(this);
		cargarDatos();
	}

	private void cargarUsuariosFaltantes(){ 
		IntUsuariosFaltantes usuariosFaltantes = new IntUsuariosFaltantes(this.proceso.id(),this); 
		usuariosFaltantes.setVisible(true); 
	}

	public Proceso getProceso(){
		return proceso; 
	}

	public void actualizarTablas(int idProceso){ 
		this.proceso = Gestor._getGestor().getProceso(idProceso);
		this.tablaActivosProceso1.cargarTabla(idProceso);
		this.tablaUsuariosProceso1.cargarTabla(idProceso);
		cargarDatos();
	}

	public void actualizarTablas(){ 
		this.proceso = Gestor._getGestor().getProceso(idProceso);
		this.tablaActivosProceso1.cargarTabla(idProceso);
		this.tablaUsuariosProceso1.cargarTabla(idProceso);
		cargarDatos();
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
		cargarDatos();
	}

	public void cargarDatos() {
		if (proceso != null) {
			jLblIdProceso.setText(String.valueOf(idProceso));
			jLblNombreProceso.setText(proceso.nombre());
			jLblFechaProceso.setText(proceso.fecha());
			jLblEstado.setText(proceso.estado());
			jLblCreador.setText(proceso.getCedulaCreador());
		}
	}

	public String getNombreProceso() {
		return this.proceso.nombre();
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	
	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLblEstado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaUsuariosProceso1 = new componentes.TablaUsuariosProceso();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaActivosProceso1 = new componentes.TablaActivosProceso();
        jLblIdProceso = new javax.swing.JLabel();
        jLblNombreProceso = new javax.swing.JLabel();
        jBtnLimpiar = new javax.swing.JButton();
        jLblFechaProceso = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBtnAgregarUsuarios = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLblCreador = new javax.swing.JLabel();

        jLabel6.setText("ESTADO:");

        jLblEstado.setText("CREADO");

        jLabel1.setText("ID PROCESO:");

        tablaUsuariosProceso1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaUsuariosProceso1);

        jLabel2.setText("NOMBRE PROCESO:");

        jLabel3.setText("FECHA DE CREACION: ");

        tablaActivosProceso1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaActivosProceso1);

        jLblIdProceso.setText("ID");

        jLblNombreProceso.setText("NOMBRE");

        jBtnLimpiar.setText("Limpiar Selección");
        jBtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarActionPerformed(evt);
            }
        });

        jLblFechaProceso.setText("FECHA");

        jLabel4.setText("USUARIOS REGISTRADOS EN EL PROCESO");

        jLabel5.setText("ACTIVOS DEL PROCESO");

        jBtnAgregarUsuarios.setText("Agregar Usuarios");
        jBtnAgregarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarUsuariosActionPerformed(evt);
            }
        });

        jLabel7.setText("CREADO POR:");

        jLblCreador.setText("CEDULA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblNombreProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnAgregarUsuarios)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLblFechaProceso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLblIdProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLblEstado)))
                                    .addComponent(jLblCreador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnLimpiar))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLblIdProceso)
                            .addComponent(jLabel6)
                            .addComponent(jLblEstado)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLblNombreProceso)
                            .addComponent(jBtnAgregarUsuarios))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLblFechaProceso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLblCreador))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarActionPerformed
		// TODO add your handling code here:
		this.tablaActivosProceso1.getSelectionModel().clearSelection();
		this.tablaUsuariosProceso1.getSelectionModel().clearSelection();
    }//GEN-LAST:event_jBtnLimpiarActionPerformed

    private void jBtnAgregarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarUsuariosActionPerformed
        // TODO add your handling code here:
		cargarUsuariosFaltantes();
    }//GEN-LAST:event_jBtnAgregarUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregarUsuarios;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLblCreador;
    private javax.swing.JLabel jLblEstado;
    private javax.swing.JLabel jLblFechaProceso;
    private javax.swing.JLabel jLblIdProceso;
    private javax.swing.JLabel jLblNombreProceso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private componentes.TablaActivosProceso tablaActivosProceso1;
    private componentes.TablaUsuariosProceso tablaUsuariosProceso1;
    // End of variables declaration//GEN-END:variables
}

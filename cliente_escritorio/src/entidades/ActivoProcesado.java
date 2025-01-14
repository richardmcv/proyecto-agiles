/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author carri
 */
public class ActivoProcesado extends Activo {

	private String estadoRevision, obsRevision, adminRevisor, nombreRevisor, apellidoRevisor;
	private int estaRevisado;

	public ActivoProcesado() {
	}

	public ActivoProcesado(String idPertinencia, String idItem, String nomItem, String desItem,
			int estaRevisado, String estadoRevision, String obsRevision, String adminRevisor) {
		super(idPertinencia, idItem, nomItem, desItem);
		this.estaRevisado = estaRevisado;
		this.estadoRevision = estadoRevision;
		this.obsRevision = obsRevision;
		this.adminRevisor = adminRevisor; 
	}

	public String getAdminRevisor() {
		return adminRevisor;
	}

	public static ActivoProcesado fromJson(JSONObject json) {
		ActivoProcesado a = new ActivoProcesado();
		Usuario u = new Usuario(); 
		JSONObject jsonUsuario = json.getJSONObject("usuario");
		JSONObject jsonRevisor = json.getJSONObject("revisor");
		try {
			a.id = json.getString("id_activo");
			a.idItem = "0";
			a.nomItem = json.getString("nombre_activo");
			a.desItem = json.getString("descripcion_activo");
			u.setCedula(jsonUsuario.getString("cedula_usuario"));
			u.setNombre(jsonUsuario.getString("nombre_usuario"));
			u.setApellido(jsonUsuario.getString("apellido_usuario"));
			a.estaRevisado = json.getInt("revision_activo");
			a.estadoRevision = json.getString("estado_revision_activo");
			a.obsRevision = json.getString("observacion_revision");
			a.adminRevisor = jsonRevisor.getString("cedula_admin");
			a.nombreRevisor = jsonRevisor.getString("nombre_admin"); 
			a.apellidoRevisor = jsonRevisor.getString("apellido_admin");
		} catch (JSONException e) {
		}
		a.setUsuario(u);
		return a;
	}

	public String getNombreRevisor() {
		return nombreRevisor;
	}

	public String getApellidoRevisor() {
		return apellidoRevisor;
	}

	public static ArrayList<Activo> fromJson(JSONArray jsonArray) {

		ArrayList<Activo> activos = new ArrayList<>(jsonArray.length());
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = null;
			try {
				jsonObject = jsonArray.getJSONObject(i);
				ActivoProcesado activo = ActivoProcesado.fromJson(jsonObject);
				if (activo != null) {
					activos.add(activo);
				}
			} catch (JSONException e) {
			}
		}

		return activos;
	}

	public String[] toStringVector(ActivoProcesado activo) {
		String texto = ""; 
		if(activo.estaRevisado == 1){ 
			texto = "REVISADO"; 	
		}
		return new String[]{activo.id, activo.idItem, activo.nomItem, activo.desItem, texto, activo.estadoRevision, activo.obsRevision}; 
	}

	public String estadoRevision() {
		return estadoRevision;
	}

	public String obsRevision() {
		return obsRevision;
	}

	public int estaRevisado() {
		return estaRevisado;
	}

}
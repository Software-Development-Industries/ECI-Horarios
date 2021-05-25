package edu.eci.ecihorarios.persistence.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Grupo;
import edu.eci.ecihorarios.model.bean.Horario;
import edu.eci.ecihorarios.model.bean.Inscripcion;
import edu.eci.ecihorarios.model.bean.Materia;

public class InscripcionDAO {

	public List<Inscripcion> getPlans(String username) throws PersistenceException {
		try (ResultSet rs = PersistenceManagerDAO.getConnection().createStatement().executeQuery(String.format("select ins.*, hor.semestre, hor.creditos as \"creditos totales\" "
				+ "from public.inscripcion as ins join public.horario as hor on hor.estudiante_id = ins.estudiante_id and hor.inscripcion_id = ins.id "
				+ "join public.usuario as est on est.id = ins.estudiante_id "
				+ "where est.login = '%s'", username))){
			
			List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
			while (rs.next()) {
				Inscripcion ins = new Inscripcion();
				ins.setTipo(rs.getString("tipo").charAt(0));
				ins.setMAX_CREDITOS(rs.getInt("max_creditos"));
				
				Horario hor = new Horario();
				List<Materia> materias = new ArrayList<Materia>();
				hor.setCreditos(rs.getInt("creditos totales"));
				hor.setMaterias(materias);
				
				ResultSet rt = PersistenceManagerDAO.getConnection().createStatement().executeQuery(String.format("select gr.numero_id, gr.cupo, gr.profesor, mat.* "
													+ "from public.horario_materia as horMat join public.materia as mat on horMat.materia_id = mat.sigla "
													+ "join public.grupo as gr on gr.materia_id = mat.sigla "
													+ "join public.inscritos as insc on insc.grupo_materia_id = gr.materia_id and insc.grupo_numero_id = gr.numero_id "
													+ "where horMat.horario_inscripcion_id = %s", rs.getInt("id")));
				
				while (rt.next()) {
					Materia mat = new Materia();
					mat.setCreditos(rt.getInt("creditos"));
					mat.setDescripcion(rt.getString("descripcion"));
					mat.setNombre(rt.getString("nombre"));
					mat.setSigla(rt.getString("sigla"));
					
					Grupo gr = new Grupo();
					gr.setNumero(rt.getInt("numero_id"));
					
					ResultSet rx = PersistenceManagerDAO.getConnection().createStatement().executeQuery(String.format("select f.dia, f.hora_inicio as \"inicio\", f.hora_fin as \"fin\"\n"
							+ "from public.fecha as f join public.grupo as gr on f.grupo_materia_id = gr.materia_id and f.grupo_numero_id = gr.numero_id\n"
							+ "where gr.materia_id = '%s' and gr.numero_id = %d", mat.getSigla(), gr.getNumero()));
					
					Map<String, Pair<LocalTime, LocalTime>> fechas = new HashMap<String, Pair<LocalTime, LocalTime>>();
					while (rx.next()) {
						fechas.put(rx.getString(1), new MutablePair<LocalTime, LocalTime>(LocalTime.parse(rx.getString(2)), LocalTime.parse(rx.getString(3))));
					}
					
					gr.setFechas(fechas);
					mat.setGrupo(gr);
					materias.add(mat);
					
					rx.close();
				}
				
				ins.setHorario(hor);				
				inscripciones.add(ins);
				
				rt.close();
			}
			
			return inscripciones;
			
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}
	
	
}

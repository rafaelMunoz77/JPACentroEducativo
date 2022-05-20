package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipologiasexo database table.
 * 
 */
@Entity
@NamedQuery(name="TipologiaSexo.findAll", query="SELECT t FROM TipologiaSexo t")
public class TipologiaSexo extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="tipologiaSexo")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="tipologiaSexo")
	private List<Profesor> profesores;

	public TipologiaSexo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setTipologiaSexo(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setTipologiaSexo(null);

		return estudiante;
	}

	public List<Profesor> getProfesores() {
		return this.profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Profesor addProfesore(Profesor profesore) {
		getProfesores().add(profesore);
		profesore.setTipologiaSexo(this);

		return profesore;
	}

	public Profesor removeProfesore(Profesor profesore) {
		getProfesores().remove(profesore);
		profesore.setTipologiaSexo(null);

		return profesore;
	}

}
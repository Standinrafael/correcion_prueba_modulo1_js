package ec.edu.uce.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Propietario;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.modelo.VehiculoPesado;

@Repository
@Qualifier("pesado")
public class MatriculaPesadoRepositoryImpl implements IMatriculaRepository {

	//variables de instancia
	private Propietario propietario;
	private VehiculoPesado vehiculo;
	
	
	private static final Logger LOG= LoggerFactory.getLogger(MatriculaPesadoRepositoryImpl.class);
	
	@Override
	public void crearMatricula(Vehiculo vehiculo, Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietario=propietario;
		this.vehiculo=(VehiculoPesado)vehiculo;
		LOG.info("Matriculando Vehiculo Pesado");
	}

	@Override
	public void buscarMatricula(String matricula) {
		// TODO Auto-generated method stub
		LOG.info("Buscando Vehiculo con matricula : "+matricula);
	}

	@Override
	public void actualizarMatricula(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculo=(VehiculoPesado)vehiculo;
		LOG.info("Actualizando vehiculo: "+vehiculo);
	}

	@Override
	public void eliminarMatricula(String matricula) {
		// TODO Auto-generated method stub
		LOG.info("Eliminando vehiculo con matricula: "+matricula);
	}

	//Metodos Get y SET
	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public VehiculoPesado getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoPesado vehiculo) {
		this.vehiculo = vehiculo;
	}

	
}

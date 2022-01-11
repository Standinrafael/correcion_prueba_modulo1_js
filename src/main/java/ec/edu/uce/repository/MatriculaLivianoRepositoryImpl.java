package ec.edu.uce.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Propietario;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.modelo.VehiculoLiviano;

@Repository
@Qualifier("liviano")
public class MatriculaLivianoRepositoryImpl implements IMatriculaRepository {

	//variables instancia
	private VehiculoLiviano vehiculo;
	private Propietario propietario;
	
	
	private static final Logger LOG = LoggerFactory.getLogger(MatriculaLivianoRepositoryImpl.class);
	
	@Override
	public void crearMatricula(Vehiculo vehiculo, Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietario=propietario;
		this.vehiculo=(VehiculoLiviano)vehiculo;
		LOG.info("Matriculando vehiculo Liviano ");
	}

	@Override
	public void buscarMatricula(String matricula) {
		// TODO Auto-generated method stub
		LOG.info("Buscando vehiculo con matricula : "+matricula);
	}

	@Override
	public void actualizarMatricula(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculo=(VehiculoLiviano)vehiculo;
		LOG.info("Actualizando vehiculo: "+vehiculo);
	}

	@Override
	public void eliminarMatricula(String matricula) {
		// TODO Auto-generated method stub
		LOG.info("Eliminando vehiculo con matricula: "+matricula);
	}

	//Metodos Get y SET
	public VehiculoLiviano getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoLiviano vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	

	
}

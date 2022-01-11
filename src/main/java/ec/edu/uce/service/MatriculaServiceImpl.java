package ec.edu.uce.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Propietario;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.modelo.VehiculoLiviano;
import ec.edu.uce.modelo.VehiculoPesado;
import ec.edu.uce.repository.IMatriculaRepository;

@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MatriculaServiceImpl implements IMatriculaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MatriculaServiceImpl.class);
	
	//variables de instancia
	private VehiculoLiviano vehiculo1;
	private VehiculoPesado vehiculo2;
	private Propietario propietario;
	
	
	//varibales primitivas para calculos
	private BigDecimal valor;
	private BigDecimal valorLiviano=new BigDecimal("0.10");
	private BigDecimal valorPesado=new BigDecimal("0.15");
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaRepository matricula1;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaRepository matricula2;
	

	@Override
	public void ImprimirCarro(Vehiculo vehiculo, int tipo) {
		// TODO Auto-generated method stub
		if(tipo==1) {
			this.vehiculo1=(VehiculoLiviano)vehiculo;
			LOG.info("Informacion Vehiculo: "+vehiculo1);
			LOG.info("Informacion Propietario: "+propietario);
		}else {
			this.vehiculo2=(VehiculoPesado)vehiculo;
			LOG.info("Informacion Vehiculo"+vehiculo2);
			LOG.info("Informacion Propietario: "+propietario);
		}
	}

	@Override
	public void MatricularCarro(Vehiculo vehiculo, Propietario propietario, int tipo) {
		// TODO Auto-generated method stub
		this.propietario=propietario;
		if(tipo==1) {
			this.matricula1.crearMatricula(vehiculo,propietario);
			vehiculo1=(VehiculoLiviano)vehiculo;
			valor=valorPesado.multiply(vehiculo1.getPrecio());
			vehiculo1.setValorMatricula(valor);
			
		}else {
			
			
			this.matricula2.crearMatricula(vehiculo,propietario);
			vehiculo2=(VehiculoPesado) vehiculo;
			valor=valorPesado.multiply(vehiculo2.getPrecio());
			vehiculo2.setValorMatricula(valor);
			
		}
	}

	@Override
	public void crearNuevaMatricula(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		LOG.info("creacion de nueva matricual"+vehiculo);
	}

	@Override
	public void encontrarMatricula(String matricula) {
		// TODO Auto-generated method stub
		LOG.info("Encontrando matirucla"+matricula);
	}

	@Override
	public void modificarMatricula(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		LOG.info("Modificanod matricula"+vehiculo);
	}

	@Override
	public void borrarMatricula(String matricula) {
		// TODO Auto-generated method stub
		LOG.info("Borrando matricula"+matricula);
	}

	
	//Metodos GET y SET
	public VehiculoLiviano getVehiculo1() {
		return vehiculo1;
	}

	public void setVehiculo1(VehiculoLiviano vehiculo1) {
		this.vehiculo1 = vehiculo1;
	}

	public VehiculoPesado getVehiculo2() {
		return vehiculo2;
	}

	public void setVehiculo2(VehiculoPesado vehiculo2) {
		this.vehiculo2 = vehiculo2;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorLiviano() {
		return valorLiviano;
	}

	public void setValorLiviano(BigDecimal valorLiviano) {
		this.valorLiviano = valorLiviano;
	}

	public BigDecimal getValorPesado() {
		return valorPesado;
	}

	public void setValorPesado(BigDecimal valorPesado) {
		this.valorPesado = valorPesado;
	}

	public IMatriculaRepository getMatricula1() {
		return matricula1;
	}

	public void setMatricula1(IMatriculaRepository matricula1) {
		this.matricula1 = matricula1;
	}

	public IMatriculaRepository getMatricula2() {
		return matricula2;
	}

	public void setMatricula2(IMatriculaRepository matricula2) {
		this.matricula2 = matricula2;
	}

	
}

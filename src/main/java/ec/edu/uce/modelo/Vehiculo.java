package ec.edu.uce.modelo;

import java.math.BigDecimal;

public class Vehiculo {
	protected String marca;
	protected String modelo;
	protected String placa;
	protected String Tipo;
	protected Propietario propietario;
	protected BigDecimal precio;
	protected BigDecimal valorMatricula;
	
	
		
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", Tipo=" + Tipo
				+ ", propietario=" + propietario + ", precio=" + precio + ", valorMatricula=" + valorMatricula + "]";
	}
	
	
	//Metodos GET y SET
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}
	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}
	
	

}

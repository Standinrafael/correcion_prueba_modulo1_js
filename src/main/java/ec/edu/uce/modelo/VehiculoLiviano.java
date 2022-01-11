package ec.edu.uce.modelo;

public class VehiculoLiviano extends Vehiculo {
	
	private String cilindraje;
	
	

	
    @Override
	public String toString() {
		return "VehiculoLiviano [cilindraje=" + cilindraje + ", marca=" + marca + ", modelo=" + modelo + ", placa="
				+ placa + ", Tipo=" + Tipo +  ", precio vehiculo=" + precio + ", valorMatricula="
				+ valorMatricula + "]";
	}

	//Metodos GET y SET
	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	

}

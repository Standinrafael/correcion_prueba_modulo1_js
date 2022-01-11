package ec.edu.uce.modelo;

public class VehiculoPesado extends Vehiculo {
	
	private String pesoToneladas;
	
	
	
	@Override
	public String toString() {
		return "VehiculoPesado [pesoToneladas=" + pesoToneladas + ", marca=" + marca + ", modelo=" + modelo + ", placa="
				+ placa + ", Tipo=" + Tipo +  ", precio vehiculo=" + precio + ", valorMatricula="
				+ valorMatricula + "]";
	}

	//Metodos GET y SET
	public String getPesoToneladas() {
		return pesoToneladas;
	}

	public void setPesoToneladas(String pesoToneladas) {
		this.pesoToneladas = pesoToneladas;
	}
	

}

package ec.edu.uce.service;

import ec.edu.uce.modelo.Propietario;
import ec.edu.uce.modelo.Vehiculo;

public interface IMatriculaService {
	    //Metodos de Logica de Negocio
		void ImprimirCarro(Vehiculo vehiculo,int tipo);
		void MatricularCarro(Vehiculo vehiculo, Propietario propietario, int tipo);
		
		//Metodos CRUD
		void crearNuevaMatricula(Vehiculo vehiculo); //C
		void encontrarMatricula(String matricula); //R
		void modificarMatricula(Vehiculo vehiculo); //U
		void borrarMatricula(String matricula); //D

}

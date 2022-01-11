package ec.edu.uce;

import java.math.BigDecimal;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Propietario;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.modelo.VehiculoLiviano;
import ec.edu.uce.modelo.VehiculoPesado;
import ec.edu.uce.service.IMatriculaService;

@SpringBootApplication
public class CorrecionPruebaModulo1JsApplication implements CommandLineRunner {
	
	private static final Logger LOG= LoggerFactory.getLogger(CorrecionPruebaModulo1JsApplication.class);

	
	//Tiene Scope Singleton porque mi programa mantiene los datos del propietario y solo cambia los del vehiculo
	//entonces seria como modificar solo al mismo usuario a cada rato, ya que para usar el Scope Protoype
	// tendria que modificar el programa para que cada vez me pida los datos del propietario y necesitaria
	//referencias individuales a cada uno de los usuarios.
	
	
	
	@Autowired
	private IMatriculaService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CorrecionPruebaModulo1JsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//Variables de Instancia
		Propietario propietario1;
		VehiculoLiviano vehiculo1=new VehiculoLiviano();
		VehiculoPesado vehiculo2= new VehiculoPesado();
				
		//Variables de Scanner para ingreso por teclado
		Scanner datos= new Scanner(System.in);
		Scanner scanner= new Scanner(System.in);
		Scanner scannerVehiculoLiviano= new Scanner(System.in);
		Scanner scannerVehiculoPesado= new Scanner(System.in);
		Scanner precioVehiculoLiviano=new Scanner(System.in);
		Scanner precioVehiculoPesado=new Scanner(System.in);
		
		//Variables primitivas
		int tipo;
		BigDecimal elePrecio,elePrecio2;
		
		
		//Informacion del usuario
		LOG.info("BIENVENIDO AL SISTEMA DE MATRICULACION DEL ECUADOR");
		LOG.info("Ingrese primero los datos del propietario del vehiculo");
		LOG.info("Ingrese el nombre del propietario");
		String nombrePropietario=datos.next();
		LOG.info("Ingrese el apellido del propietario");
		String apellidoPropietario=datos.next();
		LOG.info("Ingrese la edad del propietario");
		String edadPropietario=datos.next();
		
		//Asignacion de la informacion del usuario
		propietario1=new Propietario();
		propietario1.setNombre(nombrePropietario);
		propietario1.setApellido(apellidoPropietario);
		propietario1.setEdad(edadPropietario);
		
		
		//Menu de Opciones
		do {			
			
			LOG.info("Escoja la opcion que desee");
			LOG.info("1. Matricular Vehiculo Liviano");
			LOG.info("2. Matriuclar Vehiculo Pesado");
			LOG.info("3. Salir");
			
			tipo=scanner.nextInt();
			
			switch(tipo) {
			
			//Opcion Matriculacion Vehiculo Liviano
			case 1:
				LOG.info("--------------Matriculacion de Vehiculo Liviano------------");
			
				LOG.info("");
				LOG.info("Los datos del Porpietario seran tomados de los ingresados inicialmente");
				
				
				//Informacion del vehiculo
				LOG.info("Ingrese la marca del vehiculo");
				String marcaLiviano=scannerVehiculoLiviano.nextLine();
				vehiculo1.setMarca(marcaLiviano);
				
				LOG.info("Ingrese el modelo del vehiculo");
				String modeloLiviano=scannerVehiculoLiviano.nextLine();
				vehiculo1.setModelo(modeloLiviano);
				
				LOG.info("Ingrese la placa del vehiculo");
				String placaLiviano=scannerVehiculoLiviano.nextLine();
				vehiculo1.setPlaca(placaLiviano);
				
				LOG.info("Ingrese el tipo de vehiculo");			
				String tipoLiviano=scannerVehiculoLiviano.nextLine();
				vehiculo1.setTipo(tipoLiviano);
				
				LOG.info("Ingrese el cilindraje del vehiculo");
				String cilindrajeLiviano=scannerVehiculoLiviano.nextLine();
				vehiculo1.setCilindraje(cilindrajeLiviano);
				
				LOG.info("Ingrese el precio del vehiculo");
				double eleccionPrecio=precioVehiculoLiviano.nextDouble();
				
				
				//Casos segun el precio del vehiculo
				if(eleccionPrecio <=0.00) {
					LOG.info("");
					LOG.error("-----PRECIO INCORRECTO-------------");
					LOG.error("No se puede realizar la matriculacion");
					LOG.info("");
				}
				else if( eleccionPrecio >0.00 && eleccionPrecio <=1000.00) {
					LOG.info("");
					LOG.warn("-------PRECIO MUY BAJO -------------");
										
					LOG.warn("Se realizara la matriculacion");
					elePrecio=new BigDecimal(eleccionPrecio);
					vehiculo1.setPrecio(elePrecio);
					
					//Metodo Matricular
					service.MatricularCarro(vehiculo1, propietario1, tipo);
					LOG.info("");
					LOG.info("");
					LOG.info("***IMPRIMIENDO INFORMACION DE LA MATRICULA**");
					
					//Metodo Imprimir
					service.ImprimirCarro(vehiculo1, tipo);
					LOG.info("");
					LOG.info("---------------------------------------------------------");
					
					
				} else {
					LOG.info("");
					LOG.info("------PRECIO ADECUADO--------------");
					LOG.info("Se realizara la matriculacion");
					elePrecio=new BigDecimal(eleccionPrecio);
					vehiculo1.setPrecio(elePrecio);
					
					//Metodo Matricular
					service.MatricularCarro(vehiculo1, propietario1, tipo);
					LOG.info("");
					
					LOG.info("***IMPRIMIENDO INFORMACION DE LA MATRICULA**");
					
					//Metodo Imprimir
					service.ImprimirCarro(vehiculo1, tipo);
					LOG.info("");
					LOG.info("---------------------------------------------------------");
					
				}			
							
								
				break;
				
			case 2:
				
				//Opcion Matriculacion Vehiculo Pesado
				LOG.info("--------------Matriculacion de Vehiculo Pesado------------");
				
				LOG.info("");
				LOG.info("Los datos del Porpietario seran tomados de los ingresados inicialmente");
				
				//Informacion del vehiculo
				LOG.info("Ingrese la marca del vehiculo");
				String marcaPesado=scannerVehiculoPesado.nextLine();
				vehiculo2.setMarca(marcaPesado);
				
				LOG.info("Ingrese el modelo del vehiculo");
				String modeloPesado=scannerVehiculoPesado.nextLine();
				vehiculo2.setModelo(modeloPesado);
				
				LOG.info("Ingrese la placa del vehiculo");
				String placaPesado=scannerVehiculoPesado.nextLine();
				vehiculo2.setPlaca(placaPesado);
				
				LOG.info("Ingrese el tipo de vehiculo");			
				String tipoPesado=scannerVehiculoPesado.nextLine();
				vehiculo2.setTipo(tipoPesado);
				
				LOG.info("Ingrese el peso en toneladas del vehiculo");
				String pesoToneladasPesado=scannerVehiculoPesado.nextLine();
				vehiculo2.setPesoToneladas(pesoToneladasPesado);
				
				LOG.info("Ingrese el precio del vehiculo");
				double eleccionPrecio1=precioVehiculoPesado.nextDouble();
				
				
				//Casos segun el precio del vehiculo
				if(eleccionPrecio1 <=0.00) {
					LOG.info("");
					LOG.error("-----PRECIO INCORRECTO-------");
					LOG.error("No se puede realizar la matriculacion");
					vehiculo2.setMarca(null);
					vehiculo2.setModelo(null);
					vehiculo2.setPlaca(null);
					vehiculo2.setTipo(null);
					vehiculo2.setPesoToneladas(null);
					vehiculo2.setPrecio(null);
					vehiculo2.setPropietario(null);
					LOG.info("");
				}
				else if( eleccionPrecio1 >0.00 && eleccionPrecio1 <=1000.00) {
					LOG.info("");
					LOG.warn("---PRECIO MUY BAJO---------");
					LOG.warn("Se realizara la matriculacion");
					elePrecio2=new BigDecimal(eleccionPrecio1);
					vehiculo2.setPrecio(elePrecio2);
					
					//Metodo Matricular
					service.MatricularCarro(vehiculo2, propietario1, tipo);
					LOG.info("");
					LOG.info("***IMPRIMIENDO INFORMACION DE LA MATRICULA**");
					
					//Metodo Imprimir
					service.ImprimirCarro(vehiculo2, tipo);
					LOG.info("");
					LOG.info("---------------------------------------------------------");
					
					
				} else {
					LOG.info("");
					LOG.info("----PRECIO ADECUADO------");
					LOG.info("Se realizara la matriculacion");
					elePrecio2=new BigDecimal(eleccionPrecio1);
					vehiculo2.setPrecio(elePrecio2);
					
					//Metodo Matricular
					service.MatricularCarro(vehiculo2, propietario1, tipo);
					LOG.info("");
					LOG.info("");
					LOG.info("***IMPRIMIENDO INFORMACION DE LA MATRICULA**");
					
					//Metodo Imprimir
					service.ImprimirCarro(vehiculo2, tipo);
					LOG.info("");
					LOG.info("---------------------------------------------------------");
					
				}
				
				
				
				break;
			default:
				LOG.info("");
				LOG.info(" Gracias por su visita");
				LOG.info("");
				
				break;
			}
			
		}while(tipo!=3);
		
		
		
		//Programa con datos quemados
		/*
		Propietario propietario1= new Propietario();
		propietario1.setNombre("Jorge");
		propietario1.setApellido("Sanchez");
		propietario1.setEdad("20");
		
		VehiculoLiviano vehiculoLiviano= new VehiculoLiviano();
		vehiculoLiviano.setMarca("Chevrolet");
		vehiculoLiviano.setModelo("2021");
		vehiculoLiviano.setPlaca("LQD-1020");
		vehiculoLiviano.setTipo("Liviano");
		vehiculoLiviano.setPropietario(propietario);
		vehiculoLiviano.setCilindraje("130 hp");
		vehiculoLiviano.setPrecio(new BigDecimal("0.0"));
		
		
		if(vehiculoLiviano.getPrecio().intValue() <=0) {
			LOG.error("Precio es incorrecto");
		}
		else if( vehiculoLiviano.getPrecio().intValue() >0 && vehiculoLiviano.getPrecio().intValue() <=1000) {
			LOG.warn("Precio es muy bajo");
		} else {
			LOG.info("Precio Adecuado");
		}
		service.MatricularCarro(vehiculoLiviano, propietario, 1);
		service.ImprimirCarro(vehiculoLiviano, 1);
		
		VehiculoPesado vehiculoPesado= new VehiculoPesado();
		vehiculoPesado.setMarca("Chevrolet");
		vehiculoPesado.setModelo("2021");
		vehiculoPesado.setPlaca("LQD-1020");
		vehiculoPesado.setTipo("Pesado");
		vehiculoPesado.setPropietario(propietario);
		vehiculoPesado.setPesoToneladas("15 toneladas");
		vehiculoPesado.setPrecio(new BigDecimal("50.00"));
		
		
		if(vehiculoPesado.getPrecio().intValue() <=0) {
			LOG.error("Precio es incorrecto");
		}
		else if( vehiculoPesado.getPrecio().intValue() >0 && vehiculoPesado.getPrecio().intValue()<=1000) {
			LOG.warn("Precio es muy bajo");
		} else {
			LOG.info("Precio Adecuado");
		}
		
		service.MatricularCarro(vehiculoPesado, propietario, 2);
		service.ImprimirCarro(vehiculoPesado, 2);
		
		
		*/
		
		
		
	}

}

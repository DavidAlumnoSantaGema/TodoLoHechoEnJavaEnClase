package ProcesosEj8Parte1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8Parte1
{
	// Actualizar la ruta a la ruta donde hayas puesto el archivo Ejercicio8Parte1_Prueba.java
	private static final String RUTAARCHIVO = "C:\\Users\\Tarde\\eclipse-workspace\\ServiciosYProcesos\\src\\ProcesosEj8Parte1\\Ejercicio8Parte1_Prueba.java";
	// Actualizar la ruta al javac dentro de la carpeta de instalación de eclipse.
	private static final String JAVAC = "C:\\eclipse\\plugins\\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.8.v20230831-1047\\jre\\bin\\javac.exe";
	private static final String ARGS = "-verbose";
	// Esto lo ponemos para ver todo el proceso que hace el compilador, ya que si todos los datos son correctos compila sin escribir nada.
	
	
	public static void main(String[] args)
	{
		// Indicamos que lo que queremos ejecutar es el javac.exe,
		// pasándole como argumento la ruta del archivo java que queremos compilar
		ProcessBuilder pb = new ProcessBuilder(JAVAC, RUTAARCHIVO, ARGS);
		pb.redirectErrorStream(true);

		try
		{
			Process p = pb.start();
			
			
			BufferedReader brOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = brOutput.readLine()) != null)
			{
				System.out.println(line);
			}
			
			
			// Hacemos que se ejecute el proceso.
			// El proceso ejecuta javac.exe, que compila el archivo .java que se le mande y se crea un archivo .class en el mismo directorio.
			// Para comprobar que funciona, podemos ejecutar en la consola java.exe con el archivo .java, y debería ejecutarse sin problemas
			try
			{
				int codigoSalida = p.waitFor();
				// Comprueba si el proceso ha acabado satisfactoriamente o ha sido interrumpido.
				
				if (codigoSalida == 0)
				{
					System.out.println("Proceso funciona");
				}
				else
				{
					System.out.println("Proceso interrumpido");
				}
				System.out.println("Codigo de salida: " + codigoSalida);
			}
			catch (InterruptedException e)
			{
				System.out.println("El proceso ha sido interrumpido de forma inesperada:");
				e.printStackTrace();
			}
		}
		catch (IOException e)
		{
			System.out.println("No se ha podido encontrar el programa:");
			e.printStackTrace();
		}
		
	}
}

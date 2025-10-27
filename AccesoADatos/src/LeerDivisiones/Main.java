package LeerDivisiones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
	private static float[] resultados = new float[5];
	
	public static void main(String[] args)
	{
		try
		{
			LeerArchivo();
			MostrarResultados();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	private static void MostrarResultados()
	{
		for (int i = 0; i < resultados.length; i++)
		{
			String res = String.valueOf(resultados[i]);
			String numEntero = res.substring(0, res.indexOf('.'));
			if (numEntero.length() <= 1)
			{
				throw new StringIndexOutOfBoundsException("El resultado tiene menos de 2 cifras");
			}
			else
			{
				System.out.println(res.charAt(1));
			}
		}
	}
	
	
	private static void LeerArchivo() throws Exception
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tarde\\eclipse-workspace\\AccesoADatos\\src\\LeerDivisiones\\divisiones.txt"));
			String leido = "";
			int numeroLineas = 0;
			
			while ((leido = br.readLine()) != null)
			{
				if ((numeroLineas + 1) > resultados.length)
				{
					br.close();
					throw new ArrayIndexOutOfBoundsException("Hay más lineas en el fichero que espacio en el array");
				}
				else
				{
					ConvertirTextoADivision(leido, numeroLineas);
				}
				numeroLineas++;
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("No se pudo encontrar el archivo: " + e.getMessage());
		}
		catch (IOException e)
		{
			throw new Exception("No se pudo encontrar el archivo: " + e.getMessage());
		}
	}
	
	
	private static void ConvertirTextoADivision(String texto, int numeroLineas) throws Exception
	{
		int divPos = texto.indexOf('/');
		if (divPos == -1)
		{
			throw new Exception("Falta el signo de división");
		}
		String dividendoTexto = texto.substring(0, divPos);
		if (dividendoTexto.isEmpty())
		{
			throw new Exception("El dividendo está vacío.");
		}
		String divisorTexto = texto.substring(divPos + 1, texto.length());
		if (divisorTexto.isEmpty())
		{
			throw new Exception("El divisor está vacío.");
		}
		
		int divisor = Integer.valueOf(divisorTexto);
		int dividendo = Integer.valueOf(dividendoTexto);
		if (divisor == 0)
		{
			throw new ArithmeticException("No se puede dividir entre cero");
		}
		resultados[numeroLineas] = dividendo / divisor;
	}
}

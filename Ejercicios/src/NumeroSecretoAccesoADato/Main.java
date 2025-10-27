package NumeroSecretoAccesoADato;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
	private static final String ruta = "C:\\Users\\Tarde\\eclipse-workspace\\Ejercicios\\src\\NumeroSecretoAccesoADato\\";
	private static final String nombreFichero = "record.txt";
	private static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args)
	{
		boolean keepPlaying = true;
		String input = "";
		do
		{
			OneRound();
			do
			{
				input = LeerCaracter("Quieres jugar otra vez? Y/N").toLowerCase();
			}
			while (!(input.equals("n") || input.equals("y")));
			if (input.equals("n")) keepPlaying = false;
		}
		while (keepPlaying);
	}
	
	
	private static void OneRound()
	{
		 System.out.println("Bienvenido al juego del número secreto");
		 String highscore = LeerDeFichero();
		 if (highscore != null)
		 {
			 System.out.println("El record es de " + highscore + " intentos.");
		 }
		 int num = GenerarNumeroAleatorio(0, 100);
		 System.out.println("Intenta adivinar el número. Va del 0 al 100");
		 int inNum = 0;
		 int tryNum = 0;
		 do
		 {
			 inNum = LeerNumero(null);
			 if (inNum != num)
			 {
				 System.out.println("Ese número no es, intenta otro!");
			 }
			 tryNum++;
		 }
		 while (inNum != num);
		 System.out.println("¡Has encontrado el número oculto " + num + "!");
		 System.out.println("Te ha costado " + tryNum + " intentos.");
		 if (highscore == null || tryNum < Integer.valueOf(highscore))
		 {
			 System.out.println("¡Nuevo record!");
			 EscribirAFichero(String.valueOf(tryNum));
		 }
	}
	
	
	private static int GenerarNumeroAleatorio(int min, int max)
	{
		return (int)(Math.random() * (max + 1 - min)) + min;
	}
	
	
	private static int LeerNumero(String mensaje)
	{
		if (mensaje != null)
		{
			System.out.println(mensaje);
		}
		return sc.nextInt();
	}
	
	
	private static String LeerCaracter(String mensaje)
	{
		if (mensaje != null)
		{
			System.out.println(mensaje);
		}
		return sc.next();
	}
	
	
	private static String LeerDeFichero()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(ruta+nombreFichero));
			String linea = "";
			String leido = "";
			while ((leido = br.readLine()) != null)
			{
				System.out.println(linea);
				linea += leido; 
			}
			br.close();
			return linea;
		}
		catch (FileNotFoundException e)
		{

		}
		catch (IOException e)
		{
			System.out.println("No se ha podido abrir el fichero de records");
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static void EscribirAFichero(String texto)
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta+nombreFichero));
			bw.write(texto);
			bw.close();
		}
		catch (IOException e)
		{
			System.out.println("No se ha podido escribir en el fichero de records");
			e.printStackTrace();
		}
	}
}

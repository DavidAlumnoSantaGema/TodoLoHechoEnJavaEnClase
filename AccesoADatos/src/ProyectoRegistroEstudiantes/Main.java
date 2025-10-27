package ProyectoRegistroEstudiantes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main
{
	private static final int MAXCHARACTERSTEXTO = 20;	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		boolean salir = false;
		do
		{
			System.out.println("Opciones:");
			System.out.println("1 - Escribir registro");
			System.out.println("2 - Leer registro.");
			System.out.println("3 - Salir.");
			System.out.println("Introduce una opción");
			String input = sc.nextLine();
			System.out.println();
			char opcion = input.charAt(0);
			
			switch (opcion)
			{
			case '1':
				try
				{
					Escribir();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				break;
			case '2':
				System.out.println("Leer seleccionado");
				break;
			case '3':
				salir = true;
				break;
			default:
				break;
			}
		}
		while (!salir);
		sc.close();
	}
	
	
	private static void Escribir() throws IOException
	{
		System.out.println("Introduce la ruta del archivo.");
		String ruta = sc.nextLine();
		
		try
		{
			RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
			System.out.println("Introduce el id del registro.");
			int id = Integer.valueOf(sc.nextLine());
			
			System.out.println("Introduce el nombre.");
			String nombre = sc.nextLine();
			
			StringBuilder sb = new StringBuilder(nombre);
			if (sb.length() > MAXCHARACTERSTEXTO)
			{
				sb.setLength(20);
			}
			else
			{
				while (sb.length() < MAXCHARACTERSTEXTO)
				{
					sb.append(" ");
				}
			}
			nombre = sb.toString();

			System.out.println("Introduce la nota.");
			float nota = Float.valueOf(sc.nextLine());
			
			raf.seek(raf.length());
			raf.writeInt(id);
			raf.writeUTF(nombre);
			raf.writeFloat(nota);

			System.out.println(raf.length());
			/*
			long pos = raf.length() / BYTESTEXTO;
			raf.seek(BYTESTEXTO * pos);
			raf.writeInt(id);
			raf.writeUTF(nombre);
			raf.writeFloat(nota);
			*/
			
			raf.seek(0);
			System.out.println(String.valueOf(raf.readInt()));
			System.out.println(raf.readUTF());
			System.out.println(raf.readFloat());
			raf.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package PruebasAccesoADatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class DemoFile
{
	public static void main(String[] args) throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Tarde\\Desktop\\registros.dat", "rw");

		// Escribir tres registros
		raf.writeUTF("Alumno1");
		raf.writeUTF("Alumno2");
		raf.writeUTF("Alumno3");

		// Ir al segundo registro
		raf.seek(raf.getFilePointer() - 14); // Estimación de salto
		String nombre = raf.readUTF();
		System.out.println("Registro leído: " + nombre);

		raf.close();
	}
}

package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Administrador;
import model.Persona;

public class ControladorFicheros {
	
	public static void guardarArrayList(ArrayList<Persona> estudiantes, String fichero) {
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroSalida.writeObject(estudiantes);
		
			ficheroSalida.close();
			System.out.println("Personas guardadas correctamente...");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
	}
	
	public static void guardarArrayListAdmin(ArrayList<Administrador> administradores, String fichero) {
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroSalida.writeObject(administradores);
		
			ficheroSalida.close();
			System.out.println("Administradores guardadas correctamente...");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
	}

	public static ArrayList<Persona> leerFichero(String fichero) {
		ArrayList<Persona> lista = null;
		try {
			ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Persona>) ficheroEntrada.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static ArrayList<Administrador> leerFicheroAdmin(String fichero) {
		ArrayList<Administrador> lista = null;
		try {
			ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Administrador>) ficheroEntrada.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static void main(String args[]) {
		String fichero = "D:\\estudiantes.dat";
		String ficheroAdmin = "D:\\estudiantesAdmin.dat";
		Persona estudiante1 = new Persona("1","Francisco", "García", "23", "Informática", "primero", "paco@paco.com", "111");
		Persona estudiante2 = new Persona("2","Ana", "Fernández", "56", "Estadística", "primero", "pepe@pepe.com", "222");
		Persona estudiante3 = new Persona("3","Arturo", "Carmona", "36", "Streamer", "primero", "jose@jose.com", "333");
		Administrador admi1 = new Administrador("admin", "admin");
		ArrayList<Persona> estudiantes = new ArrayList<Persona>();
		ArrayList<Administrador> administradores = new ArrayList<Administrador>();
		estudiantes.add(estudiante1);
		estudiantes.add(estudiante2);
		estudiantes.add(estudiante3);
		administradores.add(admi1);
		guardarArrayList(estudiantes, fichero);
		guardarArrayListAdmin(administradores, ficheroAdmin);
	}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * leer archivos de texto
 *
 * @author HP
 */
public class Archivos {

    public static void leerArchivo(String name) {
        File archivo = null;//apunta a un archivo fisico del dd
        FileReader fr = null;//para leer el archivo
        BufferedReader bufer = null;
        try {
            //cramos un apuntador al archivo fisico
            archivo = new File("C:\\Users\\HP\\Documents" + name);
            //abrimos el archivo para lectura
            fr = new FileReader(archivo);
            //configurar bufer para hacer la lectura
            bufer = new BufferedReader(fr);

            //Lectura del contenido del archivo
            String linea;
            //mientras haya informacion en el archivo
            while ((linea = bufer.readLine()) != null) {
                System.out.println("Linea del archivo: " + linea);
            }

        } catch (Exception e) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        } finally {
            //Esta clausula se ejecuta siempre 
            //Se cierra el archivo 
            try {
                //si se logro abrir el archivo, debe cerrarlo.
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo");
                e2.printStackTrace();
            }
        }
    }

    public static void escribirArchivo(String name) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        BufferedReader bufer2 = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        try {
            archivo = new FileWriter("C:\\Users\\HP\\Documents" + name + ".txt");
            pw = new PrintWriter(archivo);
            do {
                System.out.println("Escribe informacion a guardar en el archivo");
                entrada = bufer2.readLine();
                //agrega lo leido en teclado al archivo en disco
                pw.println(entrada);
                System.out.println("Escribe s para continuar, n para parar");
                entrada = bufer2.readLine();
                respuesta = entrada.charAt(0);
            } while (respuesta != 'n');
        } catch (Exception e) {
            System.out.println("Error al escribir archivo: " + name);
            e.printStackTrace();
        } finally {
            try {
                //Cerrar el archivo si es que pudo abrir la escritura
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo " + name);
                e2.printStackTrace();
            }
        }
    }

    public static void eliminarArchivo(String name) {
        File archivo = null;//apunta a un archivo fisico del dd
        FileReader fr = null;//para leer el archivo
        BufferedReader bufer = null;
        try {
            archivo = new File("C:\\Users\\HP\\Documents" + name);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe");
            } else {
                archivo.delete();
                System.out.println("El archivo fue eliminado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader buferTeclado = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String fileName;
        int opcion;

        System.out.println("Pograma que lee un archivo de texto");
        System.out.println("---------------------------------------");
        System.out.println("1-Leer un archivo de texto existente");
        System.out.println("2-Crear un archivo de texto");
        System.out.println("3-Eliminar un archivo de texto");
        System.out.println("¿Que quieres hacer?");
        entrada = buferTeclado.readLine();
        opcion = Integer.parseInt(entrada);
        System.out.println("Escribe el nombre del archivo");
        entrada = buferTeclado.readLine();
        fileName = entrada;
        switch (opcion) {
            case 1: {
                //Lectura de un archivo de texto
                System.out.println("Lectura de un archivo existente");
                System.out.println("Contenido del archivo");
                leerArchivo(entrada);
            }
            break;
            case 2: {
                System.out.println("Creacion de un archivo de texto");
                escribirArchivo(fileName);
            }
            break;
            default:
                System.out.println("Opcion no valida");
        }

        System.out.println("Escribe el nombre del archivo a abrir");
        entrada = buferTeclado.readLine();
        System.out.println("Contenido del archivo");
        leerArchivo(entrada);
    }

}

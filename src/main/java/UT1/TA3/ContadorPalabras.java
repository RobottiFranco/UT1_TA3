package UT1.TA3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class ContadorPalabras {
    /*
     * Lenguaje natural del metodo:
     *
     * A traves de una de un metodo llamado contarPalabras de la clase
     * ContadorPalabras que toma
     * como parametro de entrada un string, cuanta todas las palabaras
     * separadas por espacios, devolviendo un entero positivo
     *
     */
    public static int contarPalabras(String frase) {
        int contador = 0;
        char caracterAnterior = ' ';
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ' && Character.isLetter(caracterAnterior)) {
                contador++;
            }
            caracterAnterior = frase.charAt(i);
        }

        if (frase.charAt(frase.length() - 1) == ' ' && Character.isLetter(caracterAnterior)) {
            contador--;
        }
        return contador + 1;
    }

    /*
     * A traves de una de un metodo llamado ContarPalabrasPorLargo de la clase
     * ContadorPalabras que toma
     * como parametro de entrada un string "frase" y un numero de largo de palabra
     * "largoDeLaPalabra", cuenta todas las palabaras
     * separadas por el caracter " " del largo "largoDeLaPalabra", devolviendo el
     * contador de palabras como entero positivo.
     */
    public static int contarPalabrasPorLargo(String frase, int largoDeLaPalabra) {
        int contadorPalabras = 0;
        int contadorLetras = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLetter(frase.charAt(i))) {
                contadorLetras++;
            } else {
                if (contadorLetras > largoDeLaPalabra) {
                    contadorPalabras++;
                }
                contadorLetras = 0;

            }
        }
        if (contadorLetras > largoDeLaPalabra) {
            contadorPalabras++;
        }
        return contadorPalabras;
    }

    /*  */
    static int[] contarVocalesYconsonantes(String texto) {
        int[] result = new int[2];
        texto = texto.toLowerCase();
        int contVoc = 0;
        int contCons = 0;
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);
            if (Character.isLetter(caracter))
                if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                    contVoc++;
                } else {
                    contCons++;
                }
        }
        result[0] = contCons;
        result[1] = contVoc;
        return result;

    }

    /*
     *
     * ln : se crea una funcion, primero lee el archivo con file reader y despues
     * con buffer reader lo separa en lineas, posteriormente contamos cada linea con
     * un contador usando readline
     * y guardamos el resultado en la variable lineas leidas que es un array de strings.
     *
     */
    public static String[] obtenerLineas(String rutaArchivo) {
        try {
            File archivoEntrada = new File(rutaArchivo);
            BufferedReader lector = new BufferedReader(new FileReader(
                    archivoEntrada));
            String lineaActual = lector.readLine();
            int contLineas = 0;
            while (lineaActual != null) {
                lineaActual = lector.readLine();
                contLineas++;
            }
            String[] lineasLeidas = new String[contLineas];
            lector = new BufferedReader(new FileReader(
                    archivoEntrada));
            for (int i = 0; i < contLineas; i++) {
                lineasLeidas[i] = lector.readLine();
            }

            return lineasLeidas;

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + rutaArchivo);
        }
        return null;
    }
}

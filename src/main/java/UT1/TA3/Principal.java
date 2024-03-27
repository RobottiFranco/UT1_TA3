package UT1.TA3;

public class Principal {
    public static void main(String[] args) {

        String frase = "      Si piensas que  tu profesor es exigente,... espera a conocer a tu jefe !";
        int prueba = ContadorPalabras.contarPalabras(frase);
        System.out.println(prueba);

        int prueba2 = ContadorPalabras.contarPalabrasPorLargo(frase, 7);
        int prueba3 = ContadorPalabras.contarPalabrasPorLargo("Hola Juancho", 4);
        int[] prueba4 = ContadorPalabras.contarVocalesYconsonantes("Aejjj");

        /* System.out.println(prueba2); */
        System.out.println(prueba3);
        /* System.out.println(prueba4[0] + " " + prueba4[1]); */

        // formateamos la salida asi se puede mostrar en la consola el nuemro de
        // palabras y la longitud del array
        String[] prueba5 = ContadorPalabras.obtenerLineas("src\\main\\java\\UT1\\TA3\\UT1_TA3_ARCHIVO_EJEMPLO.txt");
        int contadorPalabras = 0;
        for (int i = 0; i < prueba5.length; i++) {
            contadorPalabras += ContadorPalabras.contarPalabras(prueba5[i]);
        }
        System.out.println(contadorPalabras);
        System.out.println(prueba5.length);

    }

}

package Ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    private static final String ALGORITMO_HASH = "MD5";
    public static Scanner tecla =  new Scanner(System.in);

    public static void main(String[] args) {
    imprimirHash(getHash(pedirCadenaBytes()));
    }

    private static byte[] getHash(byte[]informacion){
        MessageDigest messageDigest = null;
        try{
            messageDigest = MessageDigest.getInstance(ALGORITMO_HASH);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(informacion);
        return  messageDigest.digest();
    }
    // pide cadena y la convierte en bytes
    private static byte [] pedirCadenaBytes(){
        String cadena = "";
        System.out.println("Introduce lo que quieras");
        cadena = tecla.nextLine();
        return  cadena.getBytes();
    }

    private static void imprimirHash(byte[] cadena) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte hash:
                cadena) {
            stringBuilder.append(String.format("%x",hash));
        }
        System.out.printf("El codigo hash es : %s%n", stringBuilder);
    }

    private static byte[] leerFichero(String nombreFichero){
        byte[] bytes= null;
        try {
            bytes = Files.readAllBytes(Path.of(nombreFichero));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    // metodo que recibe un nombre de fichero y lee todos los bytes que hay
    // con file input stream

    // crear metodo que reciba un array de bytes y despues con un stringbuilder vaya
    // concatenandolo en formato hex
}

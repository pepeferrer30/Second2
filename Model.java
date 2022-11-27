/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ae_02_t1_2_streams_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.imageio.stream.FileImageInputStream;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Joan_2k2
 */
public class Model {

    public static String leerArchivo(File f) throws IOException {

        String contenido = "";
        try {
            FileInputStream leer = new FileInputStream(f);
            int caracter = leer.read();
            while (caracter != -1) {
                contenido += (char) caracter;
                caracter = leer.read();

            }

        } catch (IOException e) {
            e.getStackTrace();

        }
        return contenido;
    }

    public static int BuscarPalabra(String palabra)  {
        int cantVeces = 0;

        try {
            File archivo = new File("Texto.txt");
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea ;
            while ((linea = br.readLine()) != null) {
                String[] almaLinea = linea.split(" ");
                for (int i = 0; i < almaLinea.length; i++) {
                    if (almaLinea[i].equalsIgnoreCase(palabra)) {
                        cantVeces++;

                    }

                }

            }

        } catch (IOException e) {

        }
        return cantVeces;
    }

    public static String RemplazarPalabra(String inicial, String remplazar, File f) throws IOException {
        String resultado = Model.leerArchivo(f).replaceAll(inicial, remplazar);
        File archivo = new File("Texto.txt");
        if (archivo.exists()) {
            archivo.delete();
            archivo = new File("Texto.txt");
        }
        FileWriter fr = new FileWriter(archivo, true);
        fr.write(remplazar);
        fr.close();

        return resultado;
    }

}

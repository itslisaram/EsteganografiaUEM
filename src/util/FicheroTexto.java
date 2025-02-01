package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FicheroTexto {
    private File archivo;

    public FicheroTexto(File archivo) {
        this.archivo = archivo;
    }

    public String leerArchivo() {
        if (archivo == null || !archivo.exists()) {
            System.out.println("El archivo no existe o no es válido.");
            return "El archivo no existe o no es válido.";
        }

        StringBuilder mssg = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                mssg.append(linea);
                mssg.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mssg.toString();
    }
}

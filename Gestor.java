import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gestor {
    public List<Cuenta> leerCSV(String rutaArchivo) throws IOException {
        List<Cuenta> cuentas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                Cuenta cuenta = new Cuenta(datos[0], datos[1], datos[2]);

                cuentas.add(cuenta);
            }
        }
        return cuentas;
    }
    
    public List<Objeto> leerCSV2(String rutaArchivo) throws IOException {
        List<Objeto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                Objeto producto = new Objeto(datos[0], Integer.parseInt(datos[1]), datos[2]);

                productos.add(producto);
            }
        }
        return productos;
    }

    public void imprimirProd(List<Objeto> productos) {
        System.out.println("Productos disponibles:");
        for (Objeto producto : productos) {
            System.out.println(producto);
        }
    }

    public void guardarCSV(List<Cuenta> cuentas, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Cuenta cuenta : cuentas) {
                String linea = cuenta.getUsuario() + "," + cuenta.getUsuario() + "," + cuenta.getSus();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package TrabaoFinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;



public class texto {
    texto() {
        guardarTextoConInfo("Informacion_de_Programa.txt");

    }


        public static void guardarTextoConInfo(String nombreArchivo) {
            try {

                String directorioActual = System.getProperty("user.dir");

                //direccion+nombrearchivo
                String rutaArchivo = directorioActual + File.separator + nombreArchivo;



                //System.out.println("RUTA" + rutaArchivo);
                File archivo = new File(rutaArchivo);
                if (!archivo.exists()) {
                    archivo.createNewFile();
                }

                FileWriter fileWriter = new FileWriter(archivo, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Obtiene la fecha  y datos sistema
                Date fechaActual = new Date();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String osName = System.getProperty("os.name");
                String osVersion = System.getProperty("os.version");
                String processor = System.getProperty("os.arch");

                // Escribe la fecha actual y los datos sistema y guarda el texto en el archivo
                bufferedWriter.write(formatoFecha.format(fechaActual) + ": " + "se modificó por última vez");
                bufferedWriter.newLine();
                bufferedWriter.write("Fecha y hora: " + new Date() + "\n");
                bufferedWriter.write("Sistema operativo: " + osName + "\n");
                bufferedWriter.write("Versión del sistema operativo: " + osVersion + "\n");
                bufferedWriter.write("Procesador: " + processor + "\n");

                // Cierra el objeto BufferedWriter
                bufferedWriter.close();


            } catch (IOException e) {
                System.out.println("Error al guardar el archivo.");
                e.printStackTrace();
            }
        }

    }


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.femr.dbrestaure.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author netsaj
 */
public class LogFile {

    public static String read(String file) throws IOException {
        File archivo = new File(file);
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        br.close();
        fr.close();
        return linea;
    }
    
    
    public static void write(String file,String line){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            File archivo = new File(file);
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.flush();
            pw.print(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}

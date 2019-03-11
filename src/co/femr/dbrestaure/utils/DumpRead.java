/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.femr.dbrestaure.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author netsaj
 */
public class DumpRead {

    HashMap map;
    private File dump;
    private String sql;
    Scanner sc = null;
    long currentSize = 0;

    public long totalSize() {
        return dump.length();
    }

    public long currentSize() {
        return currentSize;
    }

    public DumpRead(String file) throws IOException {
        //absolute 
        dump = new File(file);
        if (!dump.exists()) {
            throw new IOException();
        } else {
            System.out.println("Open file:");
            System.out.println(dump.getAbsolutePath());
        }

        FileInputStream inputStream = null;
        inputStream = new FileInputStream(dump);
        sc = new Scanner(inputStream, "UTF-8");

    }
    
    public String line(){
        return this.line(true);
    }
    public String line(boolean single) {
        String line = "";
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            currentSize += s.getBytes().length;
            if (s.isEmpty() || s.startsWith("#") || s.startsWith("--")) {
                return "";
            } else {
                line += s+"\n";
            }
            if (s.endsWith(";")) {
                break;
            }
        }
        return sc.hasNextLine() ? line : null;
    }

    public void close() {
        sc.close();
    }

}

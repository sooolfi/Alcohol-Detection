/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.*;


/**
 *
 * @author guido
 */
public class LeerTxt {
    
    private double[] file;
    private String filePath;
    private int tamanio;
    
   public LeerTxt(String filepath){
       filePath = filepath;
       tamanio = 0;

        try {
            File myFile = new File(filepath);
            FileReader fileReader = new FileReader(myFile);
            BufferedReader lineReader = new BufferedReader(fileReader);

         String linea;
         while((linea=lineReader.readLine())!=null)
            tamanio+=1;
             
            lineReader.close();
            fileReader.close();
            
            cargarArchivo();

        } catch (IOException ioe) {
            System.out.println("No se encuentra el archivo... ");
        }

    }

    private void cargarArchivo() {
        try {
            File myFile = new File(filePath);
            FileReader fileReader = new FileReader(myFile);
            BufferedReader lineReader = new BufferedReader(fileReader);

            String linea;
            file = new double[tamanio];
            
            for (int i=0;i<tamanio;i++){
            linea=lineReader.readLine();
            file[i]=Double.parseDouble(linea);
            }
            lineReader.close();
            fileReader.close();

        } catch (IOException ioe) {
            System.out.println("No se encuentra el archivo... ");
        }
        
    }
    
    public double[] getFile(){
        return file;
    }
    
    public int getTamanio(){
     return tamanio;
}
    
    public void printFile(){
        for(int i=0;i<tamanio;i++)
            System.out.print(file[i]);
    }
       

}

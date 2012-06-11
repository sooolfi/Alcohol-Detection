/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.util.FuncionesOctave;
import com.util.LeerTxt;
import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guido
 */
public class TPTest {
    
    public TPTest(){
              
          //Ahora probamos con 4 frases 2 sobrias y 2 ebrias (gabi y mati)
         
          System.out.print("Iniciando etapa de Testeo:..\n");
          String path1S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x22.txt";
          String path1E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y22.txt";
          String path2S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x23.txt";
          String path2E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y23.txt";
          
          //Calculo la F0 de la senial de entrada y calculo la distancia con FDTW
          LeerTxt file1 = new LeerTxt(path1S);
          LeerTxt file2 = new LeerTxt(path1E);
          LeerTxt file3 = new LeerTxt(path2S);
          LeerTxt file4 = new LeerTxt(path2E);
         
          //calculo F0 en octave
         OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
         OctaveDouble a1 = new OctaveDouble(file1.getFile(),1,file1.getTamanio());
         OctaveDouble a2 = new OctaveDouble(file2.getFile(),1,file2.getTamanio());
         OctaveDouble a3 = new OctaveDouble(file3.getFile(),1,file3.getTamanio());
         OctaveDouble a4 = new OctaveDouble(file4.getFile(),1,file4.getTamanio());
         octave.put("a1", a1); octave.put("a2", a2);
         octave.put("a3", a3); octave.put("a4", a4);
         FuncionesOctave function= new FuncionesOctave(2);
         octave.eval(function.getString());
         octave.eval("[test1] =  spCepstrum(a1);");
         octave.eval("[test2] =  spCepstrum(a2);");
         octave.eval("[test3] =  spCepstrum(a3);");
         octave.eval("[test4] =  spCepstrum(a4);"); 
         
         OctaveDouble test1 = octave.get(OctaveDouble.class, "test1");
         OctaveDouble test2 = octave.get(OctaveDouble.class, "test2");
         OctaveDouble test3 = octave.get(OctaveDouble.class, "test3");
         OctaveDouble test4 = octave.get(OctaveDouble.class, "test4");
         
         
         double[] test1d = test1.getData(); //sobrio1
         double[] test2d = test2.getData(); //ebrio1
         double[] test3d = test3.getData(); //sobrio2
         double[] test4d = test4.getData();//ebrio2
         
         //Cargo funcion 2 //calculo LTAS         
         FuncionesOctave function2= new FuncionesOctave(1);
         octave.eval(function2.getString());
         octave.eval("[Dist1,LTASS1,LTASE1] =  ltas(a1,a1);");
         octave.eval("[Dist2,LTASS2,LTASE2] =  ltas(a2,a2);");
         octave.eval("[Dist3,LTASS3,LTASE3] =  ltas(a3,a3);");
         octave.eval("[Dist4,LTASS4,LTASE4] =  ltas(a4,a4);");
         
         OctaveDouble LTASS1 = octave.get(OctaveDouble.class, "LTASS1");
         OctaveDouble LTASS2 = octave.get(OctaveDouble.class, "LTASS2");
         OctaveDouble LTASS3 = octave.get(OctaveDouble.class, "LTASS3");
         OctaveDouble LTASS4 = octave.get(OctaveDouble.class, "LTASS4");
         
         OctaveDouble test5 = octave.get(OctaveDouble.class, "LTASS1"); //sobrio1
         OctaveDouble test6 = octave.get(OctaveDouble.class, "LTASS2"); //ebrio1
         OctaveDouble test7 = octave.get(OctaveDouble.class, "LTASS3"); //sobrio2
         OctaveDouble test8 = octave.get(OctaveDouble.class, "LTASS4"); //ebrio2
         
         double[] test5d = test5.getData(); //sobrio1
         double[] test6d = test6.getData(); //ebrio1
         double[] test7d = test7.getData(); //sobrio2
         double[] test8d = test8.getData();//ebrio2
         octave.close();
         
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio1.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test1d.length;i++){
            writer.write(Double.toString(test1d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura sobrio1.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio1.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test2d.length;i++){
            writer.write(Double.toString(test2d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura ebrio1.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio2.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test3d.length;i++){
            writer.write(Double.toString(test3d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura sobrio2.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio2.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test4d.length;i++){
            writer.write(Double.toString(test4d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura ebrio2.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }

         //Archivos para LTAS
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio1L.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test5d.length;i++){
            writer.write(Double.toString(test5d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura sobrio1L.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio1L.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test6d.length;i++){
            writer.write(Double.toString(test6d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura ebrio1L.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio2L.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test7d.length;i++){
            writer.write(Double.toString(test7d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura sobrio2L.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio2L.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         
         for (int i=0;i<test8d.length;i++){
            writer.write(Double.toString(test8d[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura ebrio2L.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         
    }

    

}

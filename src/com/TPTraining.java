/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import com.util.FuncionesOctave;
import com.util.LeerTxt;
import com.util.PromVect;
import dk.ange.octave.*;
import dk.ange.octave.OctaveEngine.*;
import dk.ange.octave.OctaveEngineFactory.*;
import dk.ange.octave.type.OctaveDouble.*;
import dk.ange.octave.exception.*;
import dk.ange.octave.exec.*;
import dk.ange.octave.type.Octave;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveString;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guido
 * Se implementara para  la frase 2, habria que hacer lo mismo para todas las frases
 */
public class TPTraining {
   
    
    private double[] plantillaF0E;
    private double[] plantillaF0S;
    private double[] plantillaLTASE;
    private double[] plantillaLTASS;
//    private double[] plantillaF1E;
//    private double[] plantillaF1S;
//    private double[] plantillaF2E;
//    private double[] plantillaF2S;
    
    public TPTraining(String Frase){
        //en este caso leeremos la frase 2
        //usamos 6 muestras para generar la plantilla y las otras 2 para prueba
        //gabi y mati para probar -> x22 y x23
        System.out.print("Fase Entrenamiento para generacion de platillas...\n");
        
        //Sobrio
        String filepath1S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x21.txt";
        String filepath2S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x24.txt";
        String filepath3S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x25.txt";
        String filepath4S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x26.txt";
        String filepath5S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x27.txt";
        String filepath6S = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x28.txt";
        
        //Ebrio
        String filepath1E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y21.txt";
        String filepath2E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y24.txt";
        String filepath3E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y25.txt";
        String filepath4E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y26.txt";
        String filepath5E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y27.txt";
        String filepath6E = "/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y28.txt";
        
        //cargo archivos en double[]
        LeerTxt file1 = new LeerTxt(filepath1S);
        LeerTxt file2 = new LeerTxt(filepath2S);
        LeerTxt file3 = new LeerTxt(filepath3S);
        LeerTxt file4 = new LeerTxt(filepath4S);
        LeerTxt file5 = new LeerTxt(filepath5S);
        LeerTxt file6 = new LeerTxt(filepath6S);
        LeerTxt file7 = new LeerTxt(filepath1E);
        LeerTxt file8 = new LeerTxt(filepath2E);
        LeerTxt file9 = new LeerTxt(filepath3E);
        LeerTxt file10 = new LeerTxt(filepath4E);
        LeerTxt file11 = new LeerTxt(filepath5E);
        LeerTxt file12 = new LeerTxt(filepath6E);
        
        //Calculo F0 para cada sonido       
         OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
         OctaveDouble a1 = new OctaveDouble(file1.getFile(),1,file1.getTamanio());
         OctaveDouble a2 = new OctaveDouble(file2.getFile(),1,file2.getTamanio());
         OctaveDouble a3 = new OctaveDouble(file3.getFile(),1,file3.getTamanio());
         OctaveDouble a4 = new OctaveDouble(file4.getFile(),1,file4.getTamanio());
         OctaveDouble a5 = new OctaveDouble(file5.getFile(),1,file5.getTamanio());
         OctaveDouble a6 = new OctaveDouble(file6.getFile(),1,file6.getTamanio());
         OctaveDouble b1 = new OctaveDouble(file7.getFile(),1,file7.getTamanio());
         OctaveDouble b2 = new OctaveDouble(file8.getFile(),1,file8.getTamanio());
         OctaveDouble b3 = new OctaveDouble(file9.getFile(),1,file9.getTamanio());
         OctaveDouble b4 = new OctaveDouble(file10.getFile(),1,file10.getTamanio());
         OctaveDouble b5 = new OctaveDouble(file11.getFile(),1,file11.getTamanio());
         OctaveDouble b6 = new OctaveDouble(file12.getFile(),1,file12.getTamanio());
         //cargo variables en octave
         octave.put("a1", a1);octave.put("b1", b1);
         octave.put("a2", a2);octave.put("b2", b2);
         octave.put("a3", a3);octave.put("b3", b3);
         octave.put("a4", a4);octave.put("b4", b4);
         octave.put("a5", a5);octave.put("b5", b5);
         octave.put("a6", a6);octave.put("b6", b6);
         
         //Cargo funcion 2 //calculo F0
         FuncionesOctave function= new FuncionesOctave(2);
         octave.eval(function.getString());
         octave.eval("[f0S1] =  spCepstrum(a1);");
         octave.eval("[f0S2] =  spCepstrum(a2);");
         octave.eval("[f0S3] =  spCepstrum(a3);");
         octave.eval("[f0S4] =  spCepstrum(a4);");
         octave.eval("[f0S5] =  spCepstrum(a5);");
         octave.eval("[f0S6] =  spCepstrum(a6);");
         octave.eval("[f0E1] =  spCepstrum(b1);");
         octave.eval("[f0E2] =  spCepstrum(b2);");
         octave.eval("[f0E3] =  spCepstrum(b3);");
         octave.eval("[f0E4] =  spCepstrum(b4);");
         octave.eval("[f0E5] =  spCepstrum(b5);");
         octave.eval("[f0E6] =  spCepstrum(b6);");
         
         OctaveDouble f0S1 = octave.get(OctaveDouble.class, "f0S1");
         OctaveDouble f0S2 = octave.get(OctaveDouble.class, "f0S2");
         OctaveDouble f0S3 = octave.get(OctaveDouble.class, "f0S3");
         OctaveDouble f0S4 = octave.get(OctaveDouble.class, "f0S4");
         OctaveDouble f0S5 = octave.get(OctaveDouble.class, "f0S5");
         OctaveDouble f0S6 = octave.get(OctaveDouble.class, "f0S6");
         
         OctaveDouble f0E1 = octave.get(OctaveDouble.class, "f0E1");
         OctaveDouble f0E2 = octave.get(OctaveDouble.class, "f0E2");
         OctaveDouble f0E3 = octave.get(OctaveDouble.class, "f0E3");
         OctaveDouble f0E4 = octave.get(OctaveDouble.class, "f0E4");
         OctaveDouble f0E5 = octave.get(OctaveDouble.class, "f0E5");
         OctaveDouble f0E6 = octave.get(OctaveDouble.class, "f0E6");
         
         System.out.print("Realizando plantilla F0 Estado EBRIO...\n");
         PromVect F0E = new PromVect(f0E1.getData(),f0E2.getData(),f0E3.getData(),f0E4.getData(),f0E5.getData(),f0E6.getData());
         plantillaF0E = new double[F0E.tamaniod()];
         plantillaF0E = F0E.getvectorDouble();
         System.out.print("Realizando plantilla F0 Estado SOBRIO...\n");
         PromVect F0S = new PromVect(f0S1.getData(),f0S2.getData(),f0S3.getData(),f0S4.getData(),f0S5.getData(),f0S6.getData());
         plantillaF0S = new double[F0S.tamaniod()];
         plantillaF0S = F0S.getvectorDouble();
         
         OctaveDouble p = new OctaveDouble(plantillaF0S,plantillaF0S.length,1);
         octave.put("prueba",p);
         octave.eval("figure(1)");
         octave.eval("plot(prueba)");
         octave.eval("drawnow()");
         OctaveDouble p2 = new OctaveDouble(plantillaF0E,plantillaF0E.length,1);
         octave.put("prueba2",p2);
         octave.eval("figure(2)");
         octave.eval("plot(prueba2)");
         octave.eval("drawnow()");

         //Cargo funcion 2 //calculo LTAS         
         FuncionesOctave function2= new FuncionesOctave(1);
         octave.eval(function2.getString());
         octave.eval("[Dist1,LTASS1,LTASE1] =  ltas(a1,b1);");
         octave.eval("[Dist2,LTASS2,LTASE2] =  ltas(a2,b2);");
         octave.eval("[Dist3,LTASS3,LTASE3] =  ltas(a3,b3);");
         octave.eval("[Dist4,LTASS4,LTASE4] =  ltas(a4,b4);");
         octave.eval("[Dist5,LTASS5,LTASE5] =  ltas(a5,b5);");
         octave.eval("[Dist6,LTASS6,LTASE6] =  ltas(a6,b6);");
         OctaveDouble LTASS1 = octave.get(OctaveDouble.class, "LTASS1");
         OctaveDouble LTASS2 = octave.get(OctaveDouble.class, "LTASS2");
         OctaveDouble LTASS3 = octave.get(OctaveDouble.class, "LTASS3");
         OctaveDouble LTASS4 = octave.get(OctaveDouble.class, "LTASS4");
         OctaveDouble LTASS5 = octave.get(OctaveDouble.class, "LTASS5");
         OctaveDouble LTASS6 = octave.get(OctaveDouble.class, "LTASS6");
         OctaveDouble LTASE1 = octave.get(OctaveDouble.class, "LTASE1");
         OctaveDouble LTASE2 = octave.get(OctaveDouble.class, "LTASE2");
         OctaveDouble LTASE3 = octave.get(OctaveDouble.class, "LTASE3");
         OctaveDouble LTASE4 = octave.get(OctaveDouble.class, "LTASE4");
         OctaveDouble LTASE5 = octave.get(OctaveDouble.class, "LTASE5");
         OctaveDouble LTASE6 = octave.get(OctaveDouble.class, "LTASE6");

         System.out.print("Realizando plantilla LTAS Estado EBRIO...\n");
         PromVect LTASE = new PromVect(LTASE1.getData(),LTASE2.getData(),LTASE3.getData(),LTASE4.getData(),LTASE5.getData(),LTASE6.getData());
         plantillaLTASE = new double[LTASE.tamaniod()];
         plantillaLTASE = LTASE.getvectorDouble();
         System.out.print("Realizando plantilla LTAS Estado SOBRIO...\n");
         PromVect LTASS = new PromVect(LTASS1.getData(),LTASS2.getData(),LTASS3.getData(),LTASS4.getData(),LTASS5.getData(),LTASS6.getData());
         plantillaLTASS = new double[LTASS.tamaniod()];
         plantillaLTASS = LTASS.getvectorDouble() ;        
         
                 
         OctaveDouble p3 = new OctaveDouble(plantillaLTASS,plantillaLTASS.length,1);
         octave.put("prueba3",p3);
         octave.eval("figure(3)");
         octave.eval("plot(prueba3)");
         octave.eval("drawnow()");
         OctaveDouble p4 = new OctaveDouble(plantillaLTASE,1,plantillaLTASE.length);
         octave.put("prueba4",p4);
         octave.eval("figure(4)");
         octave.eval("plot(prueba4)");
         octave.eval("drawnow()");   
         
         
         octave.close();

         
         
         //Guardamos las plantillas en los archivos
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/F0Sobrio.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         for (int i=0;i<plantillaF0S.length;i++){
            writer.write(Double.toString(plantillaF0S[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura F0Sobrio.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/F0Ebrio.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         for (int i=0;i<plantillaF0E.length;i++){
            writer.write(Double.toString(plantillaF0E[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura F0Ebrio.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/LTASSobrio.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         for (int i=0;i<plantillaLTASS.length;i++){
            writer.write(Double.toString(plantillaLTASS[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura LTASSobrio.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         try {
         File outFile = new File("/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/LTASEbrio.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
         for (int i=0;i<plantillaLTASE.length;i++){
            writer.write(Double.toString(plantillaLTASE[i]));
            writer.write("\n");
           
         }
         System.out.print("Escritura LTASEbrio.txt realizada con exito...\n");
         writer.close();
        } catch (IOException ioe) {
            System.out.println("No se pudo crear el archivo... ");
        }
         
         

         
         
         
        
    }
    
    
    
    
    
    
    
    
    
}

package com;



import com.util.FuncionesOctave;
import com.util.LeerTxt;
import dk.ange.octave.*;
import dk.ange.octave.OctaveEngine.*;
import dk.ange.octave.OctaveEngineFactory.*;
import dk.ange.octave.type.OctaveDouble.*;
import dk.ange.octave.exception.*;
import dk.ange.octave.exec.*;
import dk.ange.octave.type.Octave;
import dk.ange.octave.type.OctaveDouble;
import dk.ange.octave.type.OctaveString;
import java.util.Vector;
import com.util.PromVect;
import dk.ange.octave.type.OctaveComplex;


public class TPF
{
      public static void main(String[] args)
    		  
      {
          //Pasos del algoritmo

          
          //  EL orden es GUIDO-GABI-MATI-JULIO-MAXI-OSVA-MGUE-PABLO
          //Lo hacemos con una frase, si funciona dsps la idea es comparar con todas
          

          System.out.print("BIENVENIDOS AL DETECTOR DE ALCOHOLEMIA..." + "\n");
          //Entremaos para realizar las plantillas
          
          //TPTraining prueba = new TPTraining("frase2");
         //Cargamos los testeos
          
       //   TPTest test = new TPTest();
          String F0Ebrio = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/F0Ebrio.txt";
          String F0Sobrio = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/F0Sobrio.txt";
          String LTASEbrio = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/LTASEbrio.txt";
          String LTASSobrio = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/LTASSobrio.txt";
          String radio = "10"; //radio de busqueda
          
          String pathF0S1 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio1.txt";
          String pathF0E1 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio1.txt";
          String pathF0S2 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio2.txt";
          String pathF0E2 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio1.txt";
          
          String pathLS1 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio1L.txt";
          String pathLE1 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio1L.txt";
          String pathLS2 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/sobrio2L.txt";
          String pathLE2 = "/home/guido/NetBeansProjects/TPFINAL/src/txt/Plantillas/ebrio1L.txt";
          
          FastDtwTest Prueba1SF = new FastDtwTest(pathF0S1,F0Sobrio,radio);
          FastDtwTest Prueba1EF = new FastDtwTest(pathF0E1,F0Ebrio,radio); 
          FastDtwTest Prueba2SF = new FastDtwTest(pathF0S2,F0Sobrio,radio);
          FastDtwTest Prueba2EF = new FastDtwTest(pathF0E2,F0Ebrio,radio);
          
          System.out.print("\n");
          System.out.print("Distancia entre F0\n");
          System.out.print(Prueba1SF.getDistance());
          System.out.print("\n");
          System.out.print(Prueba1EF.getDistance());
          System.out.print("\n");
          System.out.print("-----------------------\n");
          System.out.print(Prueba2SF.getDistance());
          System.out.print("\n");
          System.out.print(Prueba2EF.getDistance());
          System.out.print("\n");
          
          FastDtwTest Prueba1S = new FastDtwTest(pathLS1,LTASSobrio,radio);
          FastDtwTest Prueba1E = new FastDtwTest(pathLE1,LTASEbrio,radio); 
          FastDtwTest Prueba2S = new FastDtwTest(pathLS2,LTASSobrio,radio);
          FastDtwTest Prueba2E = new FastDtwTest(pathLE2,LTASEbrio,radio);
          
          System.out.print("\n");
          System.out.print("Distancia entre LTAS\n");
          System.out.print(Prueba1S.getDistance());
          System.out.print("\n");
          System.out.print(Prueba1E.getDistance());
          System.out.print("\n");
          System.out.print("-----------------------\n");
          System.out.print(Prueba2S.getDistance());
          System.out.print("\n");
          System.out.print(Prueba2E.getDistance());
          System.out.print("\n");
          System.exit(0);
          
      }  // end main()


}  // end class TPF

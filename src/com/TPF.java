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
          TPTraining prueba = new TPTraining("frase2");
          //Cargamos los testeos   
          TPTest test = new TPTest();
          
          //cargamos los path para leer plantillas y pruebas
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
          
          System.out.print("Normalizando y calculando distancias con FDTW...\n");
          
          //Comparamos.. 
          //sujeto N -ESTADO-plant-comp  
          //1SF0S significa sujeto 1 sobrio comparando f0 con plantilla sonbria
          //sujeto 1 path terminados con 1
          FastDtwTest sujeto1SF0S = new FastDtwTest(pathF0S1,F0Sobrio,radio);
          FastDtwTest sujeto1SF0E = new FastDtwTest(pathF0S1,F0Ebrio,radio);
          
          FastDtwTest sujeto1EF0S = new FastDtwTest(pathF0E1,F0Sobrio,radio);
          FastDtwTest sujeto1EF0E = new FastDtwTest(pathF0E1,F0Ebrio,radio);
          
          FastDtwTest sujeto1SLTASS = new FastDtwTest(pathLS1,LTASSobrio,radio);
          FastDtwTest sujeto1SLTASE = new FastDtwTest(pathLS1,LTASEbrio,radio);
          
          FastDtwTest sujeto1ELTASS = new FastDtwTest(pathLE1,LTASSobrio,radio);
          FastDtwTest sujeto1ELTASE = new FastDtwTest(pathLE1,LTASEbrio,radio);
          
         
          System.out.print("Primera prueba Sujeto 1\n");
          System.out.print("Distancia entre F0\n");
          System.out.print("Real: Sobrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto1SF0S.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto1SF0E.getDistance());
          System.out.print("\n");
          System.out.print("Real: Ebrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto1EF0S.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto1EF0E.getDistance());
          System.out.print("\n");
          
          System.out.print("Distancia LTAS.\n");
          System.out.print("Real: Sobrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto1SLTASS.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto1SLTASE.getDistance());
          System.out.print("\n");
          System.out.print("Real: Ebrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto1ELTASS.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto1ELTASE.getDistance());
          System.out.print("\n");
          
          //sujeto 2 path terminados con 2
          
          //sujeto 1 path terminados con 1
          FastDtwTest sujeto2SF0S = new FastDtwTest(pathF0S2,F0Sobrio,radio);
          FastDtwTest sujeto2SF0E = new FastDtwTest(pathF0S2,F0Ebrio,radio);
          
          FastDtwTest sujeto2EF0S = new FastDtwTest(pathF0E2,F0Sobrio,radio);
          FastDtwTest sujeto2EF0E = new FastDtwTest(pathF0E2,F0Ebrio,radio);
          
          FastDtwTest sujeto2SLTASS = new FastDtwTest(pathLS2,LTASSobrio,radio);
          FastDtwTest sujeto2SLTASE = new FastDtwTest(pathLS2,LTASEbrio,radio);
          
          FastDtwTest sujeto2ELTASS = new FastDtwTest(pathLE2,LTASSobrio,radio);
          FastDtwTest sujeto2ELTASE = new FastDtwTest(pathLE2,LTASEbrio,radio);
          
          System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
          System.out.print("Primera prueba Sujeto 2\n");
          System.out.print("Distancia entre F0\n");
          System.out.print("Real: Sobrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto2SF0S.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto2SF0E.getDistance());
          System.out.print("\n");
          System.out.print("Real: Ebrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto2EF0S.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto2EF0E.getDistance());
          System.out.print("\n");
          
          System.out.print("Distancia LTAS.\n");
          System.out.print("Real: Sobrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto2SLTASS.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto2SLTASE.getDistance());
          System.out.print("\n");
          System.out.print("Real: Ebrio...\n");
          System.out.print("Distancia a plantilla sobrio...: ");
          System.out.print(sujeto2ELTASS.getDistance());
          System.out.print("\n");
          System.out.print("Distancia a plantilla ebrio...: ");
          System.out.print(sujeto2ELTASE.getDistance());
          System.out.print("\n");
          
          
          
      }  // end main()


}  // end class TPF

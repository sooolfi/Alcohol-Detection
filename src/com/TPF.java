package com;



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


public class TPF
{
      public static void main(String[] args)
    		  
      {
          //Pasos del algoritmo
          
          //1-Leer archivos txt y Aplicar las funciones LTAS, F0 y f1f2
          //2- extraer las caracteristicas para luego normalizar utilizando FDTW
          //3-Obtener distancia de una nueva frase
          
          //Normalizacion para las distintas Frases
          
          //  EL orden es GUIDO-GABI-MATI-JULIO-MAXI-OSVA-MGUE-PABLO
          //Lo hacemos con una frase, si funciona dsps la idea es comparar con todas
          
         //Emparejo los sobrios con la primera frase
          System.out.print("Leyendo datos y normalizando con FDTW..." + "\n");
          
          FastDtwTest S1 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x21.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x22.txt","10" );
    	  FastDtwTest S2 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x23.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x24.txt","10" );
          FastDtwTest S3 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x25.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x26.txt","10" );
          FastDtwTest S4 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x27.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/x28.txt","10" );
          
         //Emparejo los ebrios con la primera frase
          
          FastDtwTest E1 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y21.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y22.txt","10" );
    	  FastDtwTest E2 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y23.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y24.txt","10" );
          FastDtwTest E3 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y25.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y26.txt","10" );
          FastDtwTest E4 = new FastDtwTest("/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y27.txt","/home/guido/NetBeansProjects/TPFINAL/src/txt/frase2/y28.txt","10" );
        
          //Promediar los sobrios y los ebrios para tener una sola plantilla de cada uno 
          //creamos los vectores
          
          Vector<Double> guidoS = S1.getX();Vector<Double> gabiS = S1.getY();
          Vector<Double> matiS = S2.getX();Vector<Double> julioS = S2.getY();
          Vector<Double> maxiS = S3.getX();Vector<Double> osvaS = S3.getY();
          Vector<Double> migueS = S4.getX();Vector<Double> pabloS = S4.getY();
          
          Vector<Double> guidoE = E1.getX();Vector<Double> gabiE = E1.getY();
          Vector<Double> matiE = E2.getX();Vector<Double> julioE = E2.getY();
          Vector<Double> maxiE = E3.getX();Vector<Double> osvaE = E3.getY();
          Vector<Double> migueE = E4.getX();Vector<Double> pabloE = E4.getY();
          
          
          System.out.print("Promediando vectores para crear Plantillas..." + "\n");
          
          PromVect SOBRIOF2 = new PromVect(guidoS,gabiS,matiS,julioS,maxiS,osvaS,migueS,pabloS);
          PromVect EBRIOF2 = new PromVect(guidoE,gabiE,matiE,julioE,maxiE,osvaE,migueE,pabloE);
          
          //tengo las 2 frases en una plantilla
          // calculo la distancia LTAS
          //LLamar a la funcion octave LTAS.m
          
         System.out.print("Aplicando LTAS..." + "\n");
          
         OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
         OctaveDouble LTAS1 = new OctaveDouble((SOBRIOF2.get()));
         OctaveDouble LTAS2 = new OctaveDouble((EBRIOF2.get()));
         octave.put("LTAS1", LTAS1);
         octave.put("LTAS2", LTAS2);
         String function = "" //
                 + "function [Dist]=ltas(LTAS1,LTAS2)"//
                 + "L=10;N=length(x);TamVent = round(N/L);h=hanning(TamVent);"//
                 + "Transf=zeros(L,N); ltas=zeros(1,N);"//
                 + " for i=1:L " //
                 + "xaux = x(((i-1)*(TamVent) +1):i*TamVent);"//
                 + "xaux = [zeros(1,(i-1)*(TamVent)) xaux zeros(1,N-(i*TamVent))];"//
                 + "haux = [zeros(1,(i-1)*(TamVent)) h'        zeros(1,N-(i*TamVent))];"//
                 + "Transf(i,:)=((fft(xaux(1:N).*haux(1:N))).^2 )./TamVent;"//
                 + "end"//
                 + "for j=1:N"//
                 + "ltas(j)=sum(Transf(1:L,j))/L;"//
                 + "ltas(j)=10*log(ltas(j));"//
                 + "end"//
                 + "N2=length(x2);TamVent2 = round(N2/L);h2=hanning(TamVent2);"//
                 + "Transf2=zeros(L,N2);ltas2=zeros(1,N2);"//
                 + "for i=1:L"//
                 + "xaux2 = x2(((i-1)*(TamVent2) +1):i*TamVent2);"//
                 + "xaux2 = [zeros(1,(i-1)*(TamVent2)) xaux2 zeros(1,N2-(i*TamVent2))];"//
                 + "haux2 = [zeros(1,(i-1)*(TamVent2)) h2' zeros(1,N2-(i*TamVent2))];"//
                 + "Transf2(i,:)=((fft(xaux2(1:N2).*haux2(1:N2))).^2 )./TamVent2;"//
                 + "end"//
                 + "for j=1:N2"//
                 + "ltas2(j)=sum(Transf2(1:L,j))/L;"//
                 + "ltas2(j)=10*log(ltas2(j));"//    
                 + "end"//
                 + "Dist= abs(mean(ltas2) - mean(ltas));"//
                 + "endfunction\n" //
                     + "";
        octave.eval(function);
        octave.eval(function);
        octave.eval("b = ltas(LTAS1,LTAS2);");
        OctaveDouble b = octave.get(OctaveDouble.class, "b");
        System.out.print(b.get());
        octave.close();

      }  // end main()


}  // end class TPF

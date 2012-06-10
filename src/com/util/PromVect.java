/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.util.Vector;

/**
 *
 * @author guido
 */
public class PromVect {
    
    private Vector<Double> Prom;
    private double[] Promd;
    
    
    public PromVect(double[] p1,double[] p2,double[] p3,double[] p4,double[] p5,double[] p6){
        int N1 = p1.length;
        int N2 = p2.length;
        int N3 = p3.length;
        int N4 = p4.length;
        int N5 = p5.length;
        int N6 = p6.length;

        
        int M1=Math.max(N1,N2);
        int M2=Math.max(N3, N4);
        int M3=Math.max(N5, N6);
        
        int M4=Math.max(M1, M2);
        int Max = Math.max(M3,M4);
       
        Promd = new double[Max];
        double aux = 0.0;
        for (int i=0;i<Max;i++){
            if(i<N1)
                aux+= p1[i];
            if(i<N2)
                aux+= p2[i];
            if(i<N3)
                aux+= p3[i];
            if(i<N4)
                aux+= p4[i];
            if(i<N5)
                aux+= p5[i];
            if(i<N6)
                aux+= p6[i];
            Promd[i]=aux/6.0;
            aux=0.0; 
        }
    }
    
            
    
    public PromVect(Vector<Double> P1,Vector<Double> P2,Vector<Double> P3,Vector<Double> P4,Vector<Double> P5,Vector<Double> P6,Vector<Double> P7,Vector<Double> P8)
    {
        Prom = new Vector<Double>();
        int i=0;
        Double aux = 0.0;
        while(i!=-1){         
        if(P1.isEmpty() == false){
            aux +=P1.firstElement();
            P1.remove(P1.firstElement());}
        if(P2.isEmpty() == false){
            aux +=P2.firstElement();
            P2.remove(P2.firstElement());}
        if(P3.isEmpty() == false){
            aux +=P3.firstElement();
            P3.remove(P3.firstElement());}
        if(P4.isEmpty() == false){
            aux +=P4.firstElement();
            P4.remove(P4.firstElement());}
        if(P5.isEmpty() == false){
            aux +=P5.firstElement();
            P5.remove(P5.firstElement());}
        if(P6.isEmpty() == false){
            aux +=P6.firstElement();
            P6.remove(P6.firstElement());}
        if(P7.isEmpty() == false){
            aux +=P7.firstElement();
            P7.remove(P7.firstElement());}
        if(P8.isEmpty() == false){
            aux +=P8.firstElement();
            P8.remove(P8.firstElement());}

        Prom.add(aux/8.0) ;
        aux=0.0;
        if(P1.isEmpty() && P2.isEmpty() && P3.isEmpty() && P4.isEmpty() && P5.isEmpty() && P6.isEmpty() && P7.isEmpty() && P8.isEmpty())
        i = -1;
        else
            i+=1;
            
        }//end while
        
        
    }
    public int tam(){
        return(Prom.size());
    }
    
    public int tamaniod(){
        return(Promd.length);
    }
    
    public Vector<Double> get(){
   
        return (Prom);
    }
    public double[] getdouble(){
         double [] tempArray = new double[Prom.size()];
            for(int i = 0; i <Prom.size();i++)
                tempArray[i]=(Prom.get(i));
        return(tempArray);
    }
    
public double[] getvectorDouble(){
    return Promd;
}
}

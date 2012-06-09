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
    
    public Vector<Double> mostrar(){
        return (Prom);
        
    }
    
    public double[] get(){
        double[] p = {};
        
        for(int i=0;i<Prom.size();i++)
        p[i]=Prom.elementAt(i);
            return (p);
        
    }
    
}

/*
 * FastDtwTest.java   Jul 14, 2004
 *
 * Copyright (c) 2004 Stan Salvador
 * stansalvador@hotmail.com
 */

package com;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import com.timeseries.TimeSeries;
import com.util.DistanceFunction;
import com.util.DistanceFunctionFactory;
import com.dtw.TimeWarpInfo;
import com.dtw.WarpPath;


public class FastDtwTest
{
	 // PRIVATE DATA
	   private double distancia;
	   private WarpPath wpath;
	   private ArrayList xindex;  //vectores wrapeados
	   private ArrayList yindex;
	   private Vector<Double> xwraped;  
	   private Vector<Double> ywraped;
	   

	   
      public FastDtwTest(String file1,String file2,String radio)
      {
            final TimeSeries tsI = new TimeSeries(file1, false, false, ',');
            final TimeSeries tsJ = new TimeSeries(file2, false, false, ',');
            final DistanceFunction distFn;
            distFn = DistanceFunctionFactory.getDistFnByName("EuclideanDistance"); 
            final TimeWarpInfo info = com.dtw.FastDTW.getWarpInfoBetween(tsI, tsJ, Integer.parseInt(radio), distFn);

            distancia = info.getDistance();
            wpath =  info.getPath();
            xindex = wpath.getArrayx(); //retomo los indices
            yindex = wpath.getArrayy(); 
            ArrayList auxX = tsI.getPoint(); //retomo los valores de los puntos
            ArrayList auxY = tsJ.getPoint();
       
            xwraped = new Vector<Double>();
            ywraped = new Vector<Double>();
            
            String indexAux;
            String dato;
            int indexAux2;
     	    
            //Cargo vector X
            for (int i=0;i<xindex.size();i++ )
     	    {
     	    	indexAux = ((xindex.get(i)).toString());
     	    	indexAux2 = Integer.parseInt(indexAux);
     	    	dato = (auxX.get(indexAux2)).toString();
     	    	dato=dato.replace("(", "");
     	    	dato=dato.replace(")", "");
     	    	double s = Double.parseDouble(dato);
     	    	xwraped.add(s); 	
     	   }     
     	   	
          //Cargo vector Y
            for (int i=0;i<yindex.size();i++ )
     	    {
     	    	indexAux = ((yindex.get(i)).toString());
     	    	indexAux2 = Integer.parseInt(indexAux);
     	    	dato = (auxY.get(indexAux2)).toString();
     	    	dato=dato.replace("(", "");
     	    	dato=dato.replace(")", "");
     	    	double s = Double.parseDouble(dato);
     	    	ywraped.add(s); 	
     	   }
            
      }
      
      public double getDistance()
      {
    	  return (distancia);
      }
      
      public WarpPath getWarpPath()
      {
    	  return(wpath);
      }
      
      public ArrayList getXindex()
      {
    	  return(wpath.getArrayx());
      }
      public ArrayList getYindex()
      {
    	  return(wpath.getArrayy());
      }
      
      public Vector getY()
      {
    	  return(ywraped);
      }
    @SuppressWarnings("UseOfObsoleteCollectionType")
      public Vector getX()
      {
    	  return(xwraped);
      }
      
      public double getSizex()
      {
          return (xwraped.size());
      }
      public double getSizey()
      {
          return (ywraped.size());
      }


}  // end class FastDtwTest

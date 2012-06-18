/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

/**
 *
 * @author guido
 */
public class FuncionesOctave {
    
    private String nomFunc;
    
    public FuncionesOctave(int numFuncion){
        if (numFuncion == 1) // LTAS
            loadFunc1();
        if (numFuncion == 2) // F0
            loadFunc2();
        if (numFuncion == 3)//F1 formant
            loadFunc3();
        if (numFuncion == 4)//F2 formant
            loadFunc4();
        if (numFuncion == 5)//F0 autocorr
            loadFunc5();   
        
    
    }
    public String getString(){
        return nomFunc;
    }

    private void loadFunc1() {
        nomFunc = "" //  
                 + "function [Dist,ltas11,ltas22]=ltas(x,x2)                                      \n"//
                 + "L=1;N=length(x);TamVent = round(N/L);h=hanning(TamVent);\n"//
                 + "Transf=zeros(L,N); ltas1=zeros(1,N);\n"//
                 + " for i=1:L \n" //
                 + "xaux = x(((i-1)*(TamVent) +1):i*TamVent);\n"//
                 + "xaux = [zeros(1,(i-1)*(TamVent)) xaux zeros(1,N-(i*TamVent))];\n"//
                 + "haux = [zeros(1,(i-1)*(TamVent)) h'        zeros(1,N-(i*TamVent))];\n"//
                 + "Transf(i,:)=((fft(xaux(1:N).*haux(1:N))).^2 )./TamVent;\n"//
                 + "end\n"//
                 + "for j=1:N\n"//
                 + "ltas1(j)=sum(Transf(1:L,j))/L;\n"//
                 + "ltas1(j)=10*log(ltas1(j));\n"//
                 + "end\n"//
                 + "N2=length(x2);TamVent2 = round(N2/L);h2=hanning(TamVent2);\n"//
                 + "Transf2=zeros(L,N2);ltas2=zeros(1,N2);\n"//
                 + "for i=1:L\n"//
                 + "xaux2 = x2(((i-1)*(TamVent2) +1):i*TamVent2);\n"//
                 + "xaux2 = [zeros(1,(i-1)*(TamVent2)) xaux2 zeros(1,N2-(i*TamVent2))];\n"//
                 + "haux2 = [zeros(1,(i-1)*(TamVent2)) h2' zeros(1,N2-(i*TamVent2))];\n"//
                 + "Transf2(i,:)=((fft(xaux2(1:N2).*haux2(1:N2))).^2 )./TamVent2;\n"//
                 + "end\n"//
                 + "for j=1:N2\n"//
                 + "ltas2(j)=sum(Transf2(1:L,j))/L;\n"//
                 + "ltas2(j)=10*log(ltas2(j));\n"//    
                 + "end\n"//
                 + "Dist= abs(mean(ltas2) - mean(ltas1));\n"// 
                 + "ltas1=real(ltas1);ltas2=real(ltas2);" //
                 + "ltas11 = abs(ltas1(1,:))';ltas22=abs(ltas2(1,:))'; \n"//
                 + "endfunction\n" //
                 + "";
    }

    private void loadFunc2() {
        nomFunc =  "" //
                +  " function [coef] = spCepstrum(x)        \n "// 
                +  "  fs = 44100;                           \n "// 
                +  "  N = round(length(x));                 \n "// 
                +  "  x = x(:) .* hamming(N);               \n "// 
                +  "  y = fft(x, N);                        \n "// 
                +  "  c = real(ifft(log(abs(y)+eps)));      \n "// 
                +  "  ms1=round(fs/1000);                   \n "// 
                +  "  ms20=round(fs/50);                    \n "// 
                +  "  coef=c(ms1:ms20);                     \n "// 
                +  "endfunction                             \n" //
                + "";
    }

    private void loadFunc3() {
        nomFunc = "" //
        + "function [f1] =  F1(x)                                  \n "//
        + "   fs=44100;                                            \n "//
        + "   N = length(x);                                       \n "//
        + "   dt = 1/fs;                                           \n "//
        + "   t = N*dt;                                            \n "//
        + " cantidad_ventanas = t / 0.010;                         \n "//
        + " tamano_ventanas  = round(N/cantidad_ventanas);         \n "//
        + " cantidad_ventanas = cantidad_ventanas * 2;             \n "//
        + "  V = hamming(tamano_ventanas-1);                         \n "//
        + "  V = V';                                               \n "//
        + "  y = zeros(cantidad_ventanas, tamano_ventanas);        \n "//
        + "  k = 1;                                                \n "//
        + "  f1 = zeros(1,cantidad_ventanas);                      \n "//
        + "  for i=1 : tamano_ventanas/2: N                        \n "//
        + "      if (k>cantidad_ventanas)                          \n "//
        + "        break;                                          \n "//
        + "      end                                               \n "//
       // + "      auxiliar = x(1:10) ;       \n "//
        + "      auxiliar = x(round(i+1):round(i+tamano_ventanas)-1) .* V;       \n "//

//        + "      a  = [round(i+1), round(i+tamano_ventanas)];                    \n "//
//        + "  no_exponencial = real(ifft(log(abs(fft(auxiliar))))); \n"//
//        + "      y(k,:)  = exp( real( fft(no_exponencial)));       \n "//
//        + "      y(k, 1:10) = 0;                                   \n "//
//        + "      %y(k, round(tamano_ventanas-10):round(tamano_ventanas)) = 0;     \n "//
//        + "      f1(k) = max(y(k, :));                             \n "//
//        + "      k = k + 1;                                        \n "//
        + "  end                                                   \n "//       
        + "endfunction\n" //
        + "";

    }

    private void loadFunc4() {
        nomFunc = "" //
        + "function [f2] =  F2(x)                             \n "// 
        + "  fs = 44100;                                      \n "// 
        + "  size(x)                                          \n "// 
        + "  N = length(x);                                   \n "// 
        + "  dt = 1/fs;                                       \n "// 
        + "  t = N*dt;                                        \n "// 
        + "  cantidad_ventanas = round(t / 0.010);            \n "// 
        + "  tamano_ventanas  =  round(N/cantidad_ventanas);  \n "// 
        + "  cantidad_ventanas = cantidad_ventanas * 2;       \n "// 
        + "  V = hamming(tamano_ventanas);                    \n "// 
        + "  V = V';                                          \n "// 
        + "  y = zeros(cantidad_ventanas, tamano_ventanas);   \n "// 
        + "  k = 1;                                           \n "// 
        + "  f2 = zeros(1,cantidad_ventanas);                 \n "// 
        + "  for i=1 : (tamano_ventanas/2): N                 \n "// 
        + "      if (k>cantidad_ventanas)                     \n "// 
        + "        break;                                     \n "// 
        + "      end                                          \n "// 
        + "      auxiliar = x(i+1 : i+tamano_ventanas) .* V;  \n "// 
        + "      a  = [i+1, i+tamano_ventanas];               \n "// 
        + "  no_exponencial = real(ifft(log(abs(fft(auxiliar))))); \n"//
        + "      y(k,:)  = exp( real( fft(no_exponencial)));  \n "// 
        + "      y(k, 1:20) = 0;                              \n "// 
        + "      y(k, tamano_ventanas-20:tamano_ventanas) = 0;\n "// 
        + "      f2(k) = max(y(k, :));                        \n "// 
        + "      k = k + 1;                                   \n "// 
        + "  end                                              \n "// 
        + "endfunction\n" //
        + "";
       
    }
    private void loadFunc5() {
        nomFunc = "" //    
        +" function [frecuencias] = autocorrelacion(x)                                      \n"// 
        +" fm=44100;                                                                        \n"//
        +" dt = 1/fm;                                                                       \n"//
        +" N = length(x);                                                                   \n"//
        +" t = 0:dt:(N/fm)-dt;                                                              \n"//
        +" ventana = hamming(256);                                                          \n"//
        +" k = 1;                                                                           \n"//
        +" j = 256;                                                                         \n"//
        +" for i=1:128:N-256 % Saltos de 128 (La mitad de la longitud de cada ventana)      \n"//
        +"  frame = x(i:j).*ventana’;                                                       \n"//
        +"  y(k) = (norm( frame,2))^2;  % Energía                                           \n"//
        +"  k = k+1;                                                                        \n"//
        +"  j = j+128;                                                                      \n"//
        +" end                                                                              \n"//
        +" maximo = max(y);                                                                 \n"//
        +" umbral = 0.2*maximo;                                                             \n"//
        +" p = 1;                                                                           \n"//
        +" j = 256;                                                                         \n"//
        +" for i=1:128:N-256                                                                \n"//
        +"  y1 = x(i:j).*ventana’;                                                          \n"//
        +"  autoCorr = xcorr(y1);                                                           \n"//
        +"  [maximo, tiempo ] = max(autoCorr);                                              \n"//
        +"  autoCorr = autoCorr(tiempo:length(autoCorr)); % Tomamos los valores positivos   \n"//
        +"  energia(p) = (norm(autoCorr,2))^2;                                              \n"//
        +"  if energia(p) > umbral %Tomamos la parte donde esta la Fo (entre 100 y 500 Hz)  \n"//
        +"    zzz = autoCorr(16:80);                                                        \n"//
        +"    [wm, wt] = max(zzz);   % Calculamos el máximo                                 \n"//
        +"    t1 = 0.002:dt:0.01; %1/100 = 0.01 y 1/500 = 0.002                             \n"//
        +"    to = t1(wt);   % Calculamos el lugar                                          \n"//
        +"    pitch = 1/to;    % Ahora la Fo es la inversa de este to                       \n"//
        +"    frecuencias(p) = pitch;                                                       \n"//
        +"  else                                                                            \n"//
        +"   frecuencias(p) = 0; % Si es ruido, lo dejamos en 0                             \n"//
        +"  end                                                                             \n"//
        +"  j = j+128;                                                                      \n"//
        +"  p = p+1;                                                                        \n"//
        +" end                                                                              \n"//                                                     \n"//
        + "endfunction\n" //
        + "";
        
        
        
        
    }
    
    
}

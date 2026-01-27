
package UF2;

import java.util.ArrayList;
import java.util.Scanner;

public class cFilPrincipal {
    //E2-5 COMPROBACIÓ DE NÚMEROS PRIMERS

    public static void main (String [] pArguments) {
        Scanner scanN = new Scanner(System.in);
        int nEntrat = -2;

        System.out.println("\n\n\n\n Introdueix numeros, quan et cansis introdueix -1: ");
        ArrayList<Integer> numerosEntrats = new ArrayList<>();
        while (nEntrat != -1 || nEntrat == -2) {// Input de usuari de numeros
            nEntrat = scanN.nextInt();
            if (!(nEntrat == -1 || nEntrat == -2)){// no entrar aquests numeros ja que son els que pane el bucle
                numerosEntrats.add(nEntrat);
            }
        }
        ArrayList<cFil> ArrayFils = new ArrayList<>();// Arraylist dels fils a executar
        for (int i = 0; i < numerosEntrats.size(); i++) {//Creacio e insercio dels fils a executar al arraylist
            cFil fNumeroPrimo = new cFil(numerosEntrats.get(i));
            ArrayFils.add(fNumeroPrimo);
        }
        for (int i = 0; i < ArrayFils.size(); i++) {// inicia els fils
            ArrayFils.get(i).start();
        }
        try {
            for (int i = 0; i < ArrayFils.size(); i++) {//comprobar que es primo amb la funcio isPrime de cada fil i mostrar la resposta
                ArrayFils.get(i).join();
                if (ArrayFils.get(i).isPrime){
                    System.out.println("El numero "+ numerosEntrats.get(i)+" en la posicion " + (i+1) + " es primo.");
                }
                else {
                    System.out.println("El numero "+ numerosEntrats.get(i)+" en la posicion " + (i+1) + " NO es primo.");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

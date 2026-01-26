package UF2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class cFilPrincipal {
    //E2-4 CONTEJAR NÚMEROS PARELLS

    public static void main (String [] pArguments) {
        Scanner scanN = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Indica el tamany del vector:");
        int tVector = scanN.nextInt();
        int nFils = -1;
        while (nFils >= tVector || nFils == -1) {
            System.out.println("Indica el numero de fils(Ha de ser menor o igual al Tamany del vector):");
            nFils = scanN.nextInt();
        }
        ArrayList<Integer> vectorArray = new ArrayList<Integer>();
        for (int i = 0; i < tVector; i++) {
            vectorArray.add(rand.nextInt(10000));
        }
        int divResult = tVector/nFils;
        System.out.println("Resultat Divisio: "+divResult);
        ArrayList<cFil> ArrayFils = new ArrayList<>();
        for (int i = 0; i < nFils; i++) {
            ArrayList<Integer> nRang = new ArrayList<>();
            for (int j = 0; j < divResult; j++) {
                nRang.add(vectorArray.get(j+(i*divResult)));
            }
            cFil fParell = new cFil(i,nRang);
            ArrayFils.add(fParell);
        }
        int nParells = 0;
        for (int i = 0; i < ArrayFils.size(); i++) {
            ArrayFils.get(i).start();
        }
        try {
            for (int i = 0; i < ArrayFils.size(); i++) {
                ArrayFils.get(i).join();
                System.out.println("Rang: "+(i*divResult) +"-"+ ((i*divResult)+divResult) + " Parells: "+ArrayFils.get(i).getcParells());
                nParells += ArrayFils.get(i).getcParells();
            }
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Nº de parells dins del vector: "+ nParells);
  }

}

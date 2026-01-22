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
        System.out.println(divResult);
        for (int i = 0; i < nFils; i+=divResult) {

        }

/*
        System.out.println ("Fil principal iniciat.");
        System.out.println ("Fil secundari iniciat.");

        cFil vObjecteFil = new cFil ("#1");
        //alternativa: innecessari
        Thread vFil = new Thread (vObjecteFil);

        //alternativa: vObjecteFil
        vFil.start ();
        System.out.println ("Iniciant execució procés principal");

        try {
            for (int vComptador = 0; vComptador < 10; vComptador ++) {
                Thread.sleep(500);
                System.out.println("Despertant aturada " + vComptador + " procès principal");
            }
        }
        catch (InterruptedException pExcepcio) {
            System.out.println ("Interrompent execució procès principal");
        }
        System.out.println ("Acabant execució procès principal");*/
  }

}

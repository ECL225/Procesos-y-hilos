package UF2;

import java.util.Scanner;

public class cFilPrincipal {
    //E2-1 Calcul concurrent sumes parcials
    public static void main (String [] pArguments) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introdueix el numero de fils que vols crear: ");
        int numFils = scan.nextInt();

        int[] valors = new int[numFils];
        for (int i = 0; i < numFils; i++){
            System.out.println("Introdueix en N per el fil " + i);
            valors[i] = scan.nextInt();
        }

        Thread[] fils = new Thread[numFils];



        /*System.out.println ("Fil principal iniciat.");
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

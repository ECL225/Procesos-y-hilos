package UF2;

import java.util.Scanner;

public class cFilPrincipal {
    //E2-1 Calcul concurrent sumes parcials
    public static void main (String [] pArguments) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introdueix el numero de fils que vols crear: ");
        int numFils = scan.nextInt();

        cFil[] fil = new cFil[numFils];
        for (int i = 0; i < numFils; i++){
            fil[i]=new cFil(i);
            fil[i].start();
        }
        for (int i = 0; i < numFils; i++){
            try {
                fil[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numFils; i++){
            System.out.println("Fil numero: (" + i + ") fibonacci = " + fil[i].getResultat());
        }
  }

}

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
            System.out.println("Introdueix en N per el fil " + (i+1));
            valors[i] = scan.nextInt();
        }

        Thread[] fils = new Thread[numFils];
        cFil[] filsObjectes = new cFil[numFils];

        for (int i = 0; i < numFils; i++){
            filsObjectes[i] = new cFil(i +1, valors[i]);
            fils[i] = new Thread(filsObjectes[i]);
            fils[i].start();
        }

        for (int i = 0; i < numFils; i++){
            try{
                fils[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        for(int i = 0; i < numFils; i++) {
            System.out.println("Fil: " + filsObjectes[i].getNumFils() + " Resultat: " + filsObjectes[i].getResultat());
        }
  }

}

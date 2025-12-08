package UF2;

import java.util.Scanner;

public class cFilPrincipal {
    //EXERCICI 1.4
    public static void main (String [] pArguments) {
        Scanner scanN = new Scanner(System.in);
        System.out.println("Introdueix quants fils vols activar");
        int cant = scanN.nextInt();
        System.out.println ("Fil principal iniciat.");
        System.out.println ("Fil secundari iniciat.");
        int t = 100;
        cFil vObjecteFilFinal = new cFil ("Fill child FINAL");
        Thread vFilF = new Thread (vObjecteFilFinal);
        for (int i = 1; i <=cant; i++) {
            if (i!=cant){
                cFil vObjecteFil = new cFil ("Fill child Nº:"+Integer.toString(i));
                vObjecteFil.sTemporitzacio(t);
                t=t+100;
                Thread vFil = new Thread (vObjecteFil);
                vFil.start();
            }
            else {
                vObjecteFilFinal.sTemporitzacio(t);
                vFilF.start();
            }
        }
        try {
            System.out.println ("Iniciant execució procés principal");
            vFilF.join();
            for (int vComptador = 0; vComptador < 10; vComptador ++) {
                Thread.sleep(500);
                System.out.println("Despertant aturada " + vComptador + " procès principal");
            }
        }
        catch (InterruptedException pExcepcio) {
            System.out.println ("Interrompent execució procès principal");
        }
        System.out.println ("Acabant execució procès principal");
  }

}

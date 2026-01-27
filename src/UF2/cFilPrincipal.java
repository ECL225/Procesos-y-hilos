package UF2;

import java.util.Scanner;

public class cFilPrincipal {
    //E2-1 Calcul concurrent sumes parcials
    public static void main (String [] pArguments) {
        Scanner scan = new Scanner(System.in);

        //Demanem a l'usuari el número de fils que vol crear
        System.out.println("Introdueix el numero de fils que vols crear: ");
        int numFils = scan.nextInt();

        //Demanem a l'usuari els valors N per cada fil
        int[] valors = new int[numFils];
        for (int i = 0; i < numFils; i++){
            System.out.println("Introdueix en N per el fil " + (i+1));
            valors[i] = scan.nextInt(); // guardem N per al fil i
        }

        //Creem arrays per guardar els objectes cFil i els Threads
        Thread[] fils = new Thread[numFils];
        cFil[] filsObjectes = new cFil[numFils];

        //Creem i iniciem tots els fils
        for (int i = 0; i < numFils; i++){
            filsObjectes[i] = new cFil(i +1, valors[i]); // objecte amb id i N
            fils[i] = new Thread(filsObjectes[i]); // es crea el fil amb el cFil
            fils[i].start(); // s'executa el run() del cFil
        }

        //Amb el següent for esperem que els fils acabin abans de continuar gracies al join
        for (int i = 0; i < numFils; i++){
            try{
                fils[i].join(); // espera al fil i especific
            }catch (InterruptedException e){ // si s'interrom el fil mentres esperen es mostre un error
                e.printStackTrace();
            }
        }

        //S'imprimeix els resultats en ordre del numero de fil
        for(int i = 0; i < numFils; i++) {
            System.out.println("Fil: " + filsObjectes[i].getNumFils() + " Resultat: " + filsObjectes[i].getResultat());
        }
  }

}

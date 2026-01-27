package UF2;

import java.util.Scanner;

public class cFilPrincipal {
    //E2-2 Serie de fibonacci concurrent
    public static void main (String [] pArguments) {
        Scanner scan = new Scanner(System.in);

        //Demanem a l'usuari el numero de fils que vol
        System.out.println("Introdueix el numero de fils que vols crear: ");
        int numFils = scan.nextInt();

        //Un cop l'usuari introdueix el numero de fils que vol els passem a guardar a un array de fils i els iniciem
        cFil[] fil = new cFil[numFils];
        for (int i = 0; i < numFils; i++){
            fil[i]=new cFil(i); // fil i calcularà el fibonacci que correspongui a la i
            fil[i].start(); // s'inicia el fil
        }

        //Amb el següent for esperem que els fils acabin abans de continuar gracies al join
        for (int i = 0; i < numFils; i++){
            try {
                fil[i].join(); // espera al fil i especific
            }catch (InterruptedException e){ // si s'interrom el fil mentres esperen es mostre un error
                e.printStackTrace();
            }
        }

        //El següent for imprimeix en ordre creixent del numFils (index)
        for (int i = 0; i < numFils; i++){
            System.out.println("Fil numero: (" + i + ") fibonacci = " + fil[i].getResultat());
        }
  }

}

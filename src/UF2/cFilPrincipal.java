
package UF2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class cFilPrincipal {
    //E2-3 BÚSQUEDA DEL VALOR MÀXIM D’UN VECTOR

    public static void main (String [] pArguments) {
        Scanner scanN = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Indica el tamany del vector:");
        int tVector = scanN.nextInt();
        int nFils = -1;
        while (nFils >= tVector || nFils == -1) {// Input de usuari
            System.out.println("Indica el numero de fils(Ha de ser menor o igual al Tamany del vector):");
            nFils = scanN.nextInt();
        }
        ArrayList<Integer> vectorArray = new ArrayList<Integer>(); // Arraylist de numeros aleatoris
        for (int i = 0; i < tVector; i++) {
            vectorArray.add(rand.nextInt(10000));
        }
        int divResult = tVector/nFils; //Calcul de valors
        int vRestants = divResult*nFils;
        //System.out.println("Resultat Divisio: "+divResult);
        ArrayList<cFil> ArrayFils = new ArrayList<>(); // Arraylist dels fils a executar
        for (int i = 0; i < nFils; i++) {//Creacio e insercio dels fils a executar al arraylist
            ArrayList<Integer> nRang = new ArrayList<>();
            for (int j = 0; j < divResult; j++) {
                nRang.add(vectorArray.get(j+(i*divResult)));
            }
            cFil fParell = new cFil(i,nRang);
            ArrayFils.add(fParell);
        }
        int nMGran = 0;//Variable on es guarde el numero mes gran
        for (int i = 0; i < ArrayFils.size(); i++) {//inicialitzacio dels fils
            ArrayFils.get(i).start();
        }
        try {
            if (vRestants != 0){//comprobar que no queden numeros sueltos i processarlos primer
                ArrayList<Integer> nRestants = new ArrayList<>();
                for (int i = vectorArray.size()-1; i >= vRestants; i--) {
                    nRestants.add(vectorArray.get(i));
                }
                for (int i = 0; i < nRestants.size(); i++) {
                    if (nRestants.get(i)> nMGran){
                        nMGran = nRestants.get(i);
                    }
                }
            }
            //Processar el resultat dels fils
            for (int i = 0; i < ArrayFils.size(); i++) {
                ArrayFils.get(i).join();
                if (ArrayFils.get(i).getnMGran()> nMGran){
                    nMGran = ArrayFils.get(i).getnMGran();
                }
            }

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Nº mes gran dins del vector: "+ nMGran);
    }

}


package UF2;

import java.util.ArrayList;
import java.util.Scanner;

public class cFilPrincipal {
    //E2-3 BÚSQUEDA DEL VALOR MÀXIM D’UN VECTOR

    public static void main (String [] pArguments) {
        Scanner scanN = new Scanner(System.in);

        System.out.println("Indica el tamany del vector:");
        int tVector = scanN.nextInt();
        int nEntrat = -2;

        ArrayList<Integer> vectorArray = new ArrayList<Integer>(); // Arraylist amb els numeros entrats per pantalla
        for (int i = 0; i < tVector; i++) {
            vectorArray.add(rand.nextInt(10000));
        }
        System.out.println("Introdueix numeros, quan et cansis introdueix -1: ");
        ArrayList<Integer> numerosEntrats = new ArrayList<>();
        while (nEntrat != -1 || nEntrat == -2) {// Input de usuari
            System.out.println("Indica el numero de fils(Ha de ser menor o igual al Tamany del vector):");
            nEntrat = scanN.nextInt();
            numerosEntrats.add(nEntrat);
        }
        //System.out.println("Resultat Divisio: "+divResult);
        ArrayList<cFil> ArrayFils = new ArrayList<>();// Arraylist dels fils a executar
        for (int i = 0; i < numerosEntrats.size(); i++) {//Creacio e insercio dels fils a executar al arraylist
            cFil fNumeroPrimo = new cFil(numerosEntrats.get(i));
            ArrayFils.add(fNumeroPrimo);
        }
        for (int i = 0; i < ArrayFils.size(); i++) {
            ArrayFils.get(i).join();
            if (ArrayFils.get(i).getnMGran()> nMGran){
                nMGran = ArrayFils.get(i).getnMGran();
            }
        }


        System.out.println("Nº mes gran dins del vector: "+ nMGran);
    }


}

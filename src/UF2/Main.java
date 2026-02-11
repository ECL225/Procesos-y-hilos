package UF2;

import UF2.domain.Matriz;

import java.util.Scanner;

public class Main {
    //EXERCICI 3 SUMA DE MATRIUS
    static void main(String[] pArguments) {
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        Matriz matriz1 = new Matriz();
        Matriz matriz2 = new Matriz();
        int mOpcio = 0;
        int stepCounter = 0;
        boolean excon = true;
        while (excon) {
            System.out.println("MENU PCINCIPAL  \n [1] Definir Matrius \n [2] Introduir dades manualment \n [3] Introduir dades des d'un arxiu\n [0] Exit");
            while (!scanN.hasNextInt()) {
                System.out.println("Error: Introdueix un número enter vàlid");
                scanN.next();
            }
            mOpcio = scanN.nextInt();
            switch (mOpcio) {
                case 1:
                    stepCounter = 0;
                    if (stepCounter != 2) {
                        int[] result1 = preguntarDades(stepCounter % 2);
                        matriz1.setFC(result1);
                        stepCounter++;
                        int[] result2 = preguntarDades(stepCounter % 2);
                        matriz2.setFC(result2);
                        stepCounter++;
                        if (matriz1.gColumnes() != matriz2.gFiles()) {
                            System.out.println("No has introduit el mateix numeros de columnes en la Matriu 1 i Files en la matriu 2.");
                            excon = false;
                            }
                        }
                    break;
                case 2:
                    for (int i = 0; i < matriz1.gFiles()*matriz1.gColumnes(); i++) {

                    }
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Bye,Bye");
                    excon = false;
                    break;
                default:
                    System.out.println("Introdueix un numero valid!!");
                    break;
            }


        }
        /*
        cFil vObjecteFil = new cFil("#1");
        //alternativa: innecessari
        Thread vFil = new Thread(vObjecteFil);

        //alternativa: vObjecteFil
        vFil.start();
        System.out.println("Iniciant execució procés principal");

        try {
            for (int vComptador = 0; vComptador < 10; vComptador++) {
                Thread.sleep(500);
                System.out.println("Despertant aturada " + vComptador + " procès principal");
            }
        } catch (InterruptedException pExcepcio) {
            System.out.println("Interrompent execució procès principal");
        }
        System.out.println("Acabant execució procès principal");
        */
    }


    public static int[] preguntarDades(int matriu) {
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        int n, m;
        System.out.println("Introdueix les Files de la matriu " + (matriu + 1));
        while (!scanN.hasNextInt()) {
            System.out.println("Error: Introdueix un número enter vàlid");
            scanN.next();
        }
        n = scanN.nextInt();
        System.out.println("Introdueix les Columnes de la matriu " + (matriu + 1));
        while (!scanN.hasNextInt()) {
            System.out.println("Error: Introdueix un número enter vàlid");
            scanN.next();
        }
        m = scanN.nextInt();
        int[] FiC = new int[2];
        FiC[0] = n;
        FiC[1] = m;
        return FiC;
    }


}

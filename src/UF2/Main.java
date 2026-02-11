package UF2;

import UF2.domain.Matriz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
            scanN.nextLine();
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
                    System.out.println("Introdueix les dades de la matriu manualment: ");
                    for (int i = 0; i < matriz1.gFiles(); i++) {
                        for (int j = 0; j <matriz1.gColumnes(); j++){
                            System.out.println("Introdueix les dades manualment: ");
                            while(!scanN.hasNextInt()){
                                System.out.println("Error: Introdueix un valor valid");
                                scanN.next();
                            }
                            matriz1.sValor(i, j, scanN.nextInt());
                        }
                    }
                    for (int i = 0; i < matriz1.gFiles(); i++){
                        for (int j = 0; j <matriz1.gColumnes(); j++){
                            System.out.println(matriz1.gValor(i, j)+ ' ');
                        }
                        System.out.println();
                    }
                    System.out.println("Ara introdueix les dades de la segona ");
                    for (int i = 0; i < matriz2.gFiles(); i++) {
                        for (int j = 0; j <matriz2.gColumnes(); j++){
                            System.out.println("Introdueix les dades manualment: ");
                            while(!scanN.hasNextInt()){
                                System.out.println("Error: Introdueix un valor valid");
                                scanN.next();
                            }
                            matriz2.sValor(i, j, scanN.nextInt());
                        }
                    }
                    for (int i = 0; i < matriz2.gFiles(); i++){
                        for (int j = 0; j <matriz2.gColumnes(); j++){
                            System.out.println(matriz2.gValor(i, j)+ ' ');
                        }
                        System.out.println();
                    }
                    scanN.nextLine();
                    break;
                case 3:
                    System.out.println("Ara introdueix les dades en un fitxer: ");
                    System.out.println("Introdueix la ruta del fitxer: ");
                    String fitxer = scanS.nextLine();
                    System.out.println("Introdueix la ruta del fitxer 2: ");
                    String fitxer2 = scanS.nextLine();

                    try(Scanner scanFile = new Scanner(new File(fitxer))){
                        for (int i = 0; i < matriz1.gFiles(); i++){
                            for (int j = 0; j < matriz1.gColumnes(); j++){
                                if (scanFile.hasNextInt()){
                                    matriz1.sValor(i, j, scanFile.nextInt());
                                }else {
                                    System.out.println("Error: Falten dades a la matriu 1");
                                    return;
                                }
                            }
                        }
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try (Scanner scanFile2 = new Scanner(new File(fitxer2))){
                        for (int i = 0; i < matriz2.gFiles(); i++){
                            for (int j = 0; j < matriz2.gColumnes(); j++){
                                if (scanFile2.hasNextInt()){
                                    matriz2.sValor(i, j, scanFile2.nextInt());
                                }else {
                                    System.out.println("Error: Falten dades a la matriu 2");
                                    return;
                                }
                            }
                        }
                        for (int i = 0; i <matriz1.gFiles(); i++){
                            for (int j = 0; j < matriz1.gColumnes(); j++){
                                System.out.print(matriz1.gValor(i, j) + " ");
                            }
                            System.out.println();
                        }
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Les dades s'han carregat correctament");
                    for (int i = 0; i <matriz1.gFiles(); i++){
                        for (int j = 0; j < matriz1.gColumnes(); j++){
                            System.out.print(matriz1.gValor(i, j) + " ");
                        }
                        System.out.println();
                    }
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

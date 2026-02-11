package UF2;

import UF2.domain.Matriz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //EXERCICI 3 SUMA DE MATRIUS
    static void main(String[] pArguments) throws InterruptedException {
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        Matriz matriz1 = null;
        Matriz matriz2 = null;
        int mOpcio = 0;
        int stepCounter = 0;
        boolean excon = true;
        while (excon) {
            System.out.println("MENU PCINCIPAL  \n [1] Definir Matrius \n [2] Introduir dades manualment \n [3] Introduir dades des d'un arxiu \n [4] Calcular \n [0] Exit");
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
                        matriz1 = new Matriz(result1[0], result1[1]);
                        stepCounter++;
                        int[] result2 = preguntarDades(stepCounter % 2);
                        matriz2 = new Matriz(result2[0], result2[1]);
                        stepCounter++;
                        if (matriz1.gColumnes() != matriz2.gFiles()) {
                            System.out.println("No has introduit el mateix numeros de columnes en la Matriu 1 i Files en la matriu 2.");
                            excon = false;
                        }
                    }
                    break;
                case 2:
                    if (stepCounter != 0) {
                        for (int i = 0; i < matriz1.gFiles(); i++) {
                            for (int j = 0; j < matriz1.gColumnes(); j++) {
                                System.out.println("Introdueix el numero de la matriu 1 en la fila " + i + " i columna " + j);
                                while (!scanN.hasNextInt()) {
                                    System.out.println("Error: Introdueix un número enter vàlid");
                                    scanN.next();
                                }
                                matriz1.sValor(i, j, scanN.nextInt());
                            }
                        }
                        System.out.println("Matriu 1 mostrada completa: ");
                        for (int i =0; i < matriz1.gFiles(); i++){
                            for (int j = 0; j < matriz1.gColumnes(); j++){
                                System.out.print(matriz1.gValor(i, j)+" ");
                            }
                            System.out.println();
                        }
                        for (int i = 0; i < matriz2.gFiles(); i++) {
                            for (int j = 0; j < matriz2.gColumnes(); j++) {
                                System.out.println("Introdueix el numero de la matriu 2 en la fila " + i + " i columna " + j);
                                while (!scanN.hasNextInt()) {
                                    System.out.println("Error: Introdueix un número enter vàlid");
                                    scanN.next();
                                }
                                matriz2.sValor(i, j, scanN.nextInt());
                            }
                        }
                        for (int i = 0; i < matriz2.gFiles(); i++){
                            for (int j = 0; j < matriz2.gColumnes(); j++){
                                System.out.print(matriz2.gValor(i, j) + " ");
                            }
                            System.out.println();
                        }
                    }
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
                case 4:
                    ArrayList<FMatriu> lFils = new ArrayList<>();
                    for (int i = 0; i < matriz1.gFiles() * matriz2.gColumnes(); i++) {
                        FMatriu mm1 = new FMatriu(matriz1,matriz2,i);
                        lFils.add(mm1);
                        mm1.start();
                    }
                    for (int i = 0; i < lFils.size(); i++) {
                        try {
                            lFils.get(i).join();
                            int result = lFils.get(i).gResultat();
                            System.out.println("Posición " + i + " calculada: " + result);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
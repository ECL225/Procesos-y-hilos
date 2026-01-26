package UF2;

import java.util.ArrayList;

//alternativa:
public class cFil extends Thread {

    int valor;
    boolean isPrime;
    public cFil(int valor) {
        this.valor = valor;
    }

    public boolean isPrime() {
        return isPrime;
    }


    public void run () {
        try {
            isPrime = esPrimo(valor);
        }
        catch (Exception pExcepcio) {
            System.out.println("Interrompent execució procès");
        }
        // System.out.println("Acabant execució procès");
    }
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }
}
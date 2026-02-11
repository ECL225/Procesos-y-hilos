package UF2;

import UF2.domain.Matriz;

//alternativa: implements Runnable
public class FMatriu extends Thread {

    int posicio;
    Matriz matriu1;
    Matriz matriu2;
    int resultat;

    public FMatriu(Matriz m1,Matriz m2, int p){
        matriu1 = m1;
        matriu2 = m2;
        posicio = p;
    }

    void multiplicar (){
        int fila = posicio/matriu2.gColumnes();
        int columna = posicio % matriu1.gColumnes();
        int total = 0;
        for (int i = 0; i < matriu1.gColumnes(); i++) {
            total += (matriu1.gValor(fila, i) * matriu2.gValor(i, columna));
        }
        resultat = total;
    }
    public int gResultat(){
        return resultat;
    }
    public void run() {
        multiplicar();
    }
}

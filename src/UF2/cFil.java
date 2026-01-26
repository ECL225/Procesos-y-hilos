package UF2;

import java.util.ArrayList;

//alternativa:
public class cFil extends Thread {

    int rang;
    ArrayList<Integer> aIterar = new ArrayList<Integer>();
    int cParells;
    public cFil(int rang, ArrayList<Integer> aIterar) {

        this.aIterar = aIterar;
    }


    public int getRang() {
        return rang;
    }

    public int getcParells (){ return cParells;}

    public void run () {
        try {
            cParells=0;
            //iterar entre els numeros i contar els parells
            for (int i = 0; i < aIterar.size(); i++) {
                if (aIterar.get(i)%2 == 0){
                    cParells++;
                }
            }
        }
        catch (Exception pExcepcio) {
          System.out.println("Interrompent execució procès");
        }
       // System.out.println("Acabant execució procès");
    }
}

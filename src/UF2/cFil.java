package UF2;

import java.util.Scanner;

//alternativa: extends Thread
public class cFil extends Thread {
    private int numFils;
    private int resultat;
    private int N;

  public cFil (int numFils, int N) {
      this.numFils = numFils;
      this.N = N;
  }

  @Override
  public void run () {
      resultat = 0;

      for (int i = 1; i <= N; i++){
          resultat += i;
      }
  }
    public int getResultat(){
        return resultat;
    }

    public int getNumFils(){
      return numFils;
    }
}

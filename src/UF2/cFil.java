package UF2;

public class cFil extends Thread {
    private int numFils;
    private long resultat;

    public cFil (int numFils) {
        this.numFils = numFils;
    }

    private long fibonacci(int posicio){
        if (posicio <= 1){
            return posicio;
        }
        long num1 = 0;
        long num2 = 1;

        for (int i = 2; i <= posicio; i++){
            long resultat = num1 + num2;
            num1 = num2;
            num2 = resultat;
        }
        return num2;
    }
    @Override
    public void run () {
        resultat = fibonacci(numFils);
    }
    public long getResultat(){
        return resultat;
    }

    public int getNumFils(){
        return numFils;
    }
}

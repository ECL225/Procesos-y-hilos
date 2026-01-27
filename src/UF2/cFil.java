package UF2;

public class cFil extends Thread {
    private int numFils; // identificador del fil
    private int resultat; // on es guarda la suma calculada
    private int N; // valor màxim per calcular la suma

    //Constructor que rep l'identificador del fil i el seu N
    public cFil (int numFils, int N) {
        this.numFils = numFils;
        this.N = N;
    }

    //Quan s'executa el fil, calcula la suma 1+2+...+N
    @Override
    public void run () {
        resultat = 0; // s'inicialitza el resultat a 0

        //Bucle per sumar tots els numeros de 1 fins N
        for (int i = 1; i <= N; i++){
            resultat += i; // es va sumant i al resultat acumulat
        }
    }

    //Getter perque el main pugui llegir el resultat de la suma
    public int getResultat(){
        return resultat;
    }

    //Getter per identificar quin fil es
    public int getNumFils(){
        return numFils;
    }
}

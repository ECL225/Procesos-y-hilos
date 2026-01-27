package UF2;

public class cFil extends Thread {
    private int numFils; // l'index del fil per calcular el fibonacci
    private long resultat; // on es guarda el resultat del fibonacci

    //Constructor que rep el numero de fils
    public cFil (int numFils) {
        this.numFils = numFils;
    }

    //Mètode que calcula el fibonacci de la posició que es dona
    private long fibonacci(int posicio){
        //Si la posicio donada es 0 o 1 (casos inicials) retorna directament el mateix numero
        if (posicio <= 1){
            return posicio;
        }

        //Els dos primers numeros de la serie fibonacci
        long num1 = 0; // anterior comença amb 0
        long num2 = 1; //actual comença amb 1

        //Bucle per calcular fibonacci segons la posicio o numero de fil
        for (int i = 2; i <= posicio; i++){
            long resultat = num1 + num2; //cada numero es igual a la suma dels 2 anteriors
            num1 = num2; // el anterior ara es l'actual
            num2 = resultat; // el nou es el resultat de la suma
        }
        return num2; // l'actual conte el resultat final del fibonacci
    }

    //Quan s'executa el fil es calcula el fibonacci i el guarda a resultat
    @Override
    public void run () {
        resultat = fibonacci(numFils);
    }
    //Getter per poder llegir el resultat
    public long getResultat(){
        return resultat;
    }
}

package UF2.domain;

public class Matriz {
  
  private int Files;
  private int Columnes;
  private int[][] aDades;
  
  public Matriz(int pFiles, int pColumnes) {
    Files = pFiles;
    Columnes = pColumnes;
    aDades = new int[pFiles][pColumnes];
  }
  public Matriz() {
  }

  public int gFiles() {
    return Files;
  }
  
  public int gColumnes() {
    return Columnes;
  }
  
  public int gValor(int pFila, int pColumna) {
    return aDades[pFila][pColumna];
  }
  
  public int[][] gDades() {
    return aDades;
  }
  
  public void sValor(int pFila, int pColumna, int pValor) {
    aDades[pFila][pColumna] = pValor;
  }
  
  public void setFC(int[] pDades) {
    Files = pDades[0];
    Columnes = pDades[1];
  }

}

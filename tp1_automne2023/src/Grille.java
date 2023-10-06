public class Grille {

    private int colonne;
    private int ligne;
    private String[][] lignesGrille;

    public Grille(int colonne , int ligne, String[][] lignesGrille) {
        this.colonne = colonne;
        this.ligne = ligne;
        this.lignesGrille = lignesGrille;
    }

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public String[][] getGrille() { return lignesGrille; }


}

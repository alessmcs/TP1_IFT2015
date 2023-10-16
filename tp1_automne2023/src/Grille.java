public class Grille {

    private int colonne;
    private int ligne;
    private String[][] lignesGrille;
    private char[][] listChar;

    public Grille(int colonne , int ligne, String[][] lignesGrille) {
        this.colonne = colonne;
        this.ligne = ligne;
        this.lignesGrille = lignesGrille;
    }

    public Grille(){

    }

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setGrille(String[][] grille) {
        this.lignesGrille = grille;
    }

    public String[][] getGrille() {
        return lignesGrille;
    }




}

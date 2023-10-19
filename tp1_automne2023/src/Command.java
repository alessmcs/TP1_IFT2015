
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Command {

    public static Grille readFile( String fileName){

        Grille grille = new Grille();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();

            // 1re ligne indique les dimensions de la grille
            String[] dimension = line.split(" ");
            int colonne = Integer.parseInt(dimension[0]);
            int ligne = Integer.parseInt(dimension[1]);
            String[][] lignesGrille = new String[ligne][colonne];

            // identifier les lignes de la grille & faire un tableau 2d
           for (int i = 0 ; i < colonne; i++) {
                line = br.readLine();
                String[] uneLigne = line.split(" ");
                lignesGrille[i] = uneLigne;
           }

            // Créer un nouvel objet grille contenant les dimensions et la grille
            grille.setColonne(colonne);
           grille.setLigne(ligne);
           grille.setGrille(lignesGrille);

            // enfin, la dernière ligne indique la liste de mots à chercher dans la grille
            line = br.readLine();

            String[] listeMots = line.split(" ");
            // créer un nouvel objet Arbre à partir de la liste de mots
            Arbre arbre = new Arbre(listeMots);


            br.close();


        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            PrintStream out = System.out;
            File file = new File(fileName);
            out.println("Absolute path:" + file.getAbsolutePath());
        }

        return grille;

    }


    public static char[][]listLettre(Grille grille) {
        char[][] listChar = new char[grille.getLigne()][grille.getColonne()];
        for (int i = 0; i < grille.getLigne(); i++) {
            for (int j = 0; j < grille.getColonne(); j++) {

                listChar[i][j] = grille.getGrille()[i][j].charAt(0);
            }
        }
        return listChar;
    }


    public static char[] trouverVoisin(int posI, int posJ, char[][] liste) {
        char[]  voisins = new char[8];

        int[][] directions = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

        for (int pos = 0; pos < directions.length; pos++) {
            int i = posI + directions[pos][0];
            int j = posJ + directions[pos][1];

            if (i >= 1 && i <= liste.length && j >= 1 && j <= liste[0].length) {
                voisins[pos] = liste[i][j];
            } else {
                voisins[pos] = ' ';
            }
        }
        return voisins;
    }

    public static Lettre[] lettreGrille(char[][] liste){
        ArrayList<Lettre> listeLettre = new ArrayList<>();

        for(int i = 0; i < liste.length;i++){
            for(int j = 0; j < liste[i].length; j++) {
                Lettre uneLettre = new Lettre(liste[i][j],i,j);
                listeLettre.add(uneLettre);
            }
        }
        Lettre[] resultat = listeLettre.toArray(new Lettre[0]);

        return resultat;
    }


    public void parcourir(char[][] liste, Arbre arbre){
        int longArbre = 
    }

}

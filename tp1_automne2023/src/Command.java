
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Command {

    public static void readFile( String fileName){
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
            Grille grille = new Grille(colonne,ligne, lignesGrille);

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

    }




}

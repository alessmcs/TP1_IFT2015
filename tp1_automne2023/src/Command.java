
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Command {

    public static void readFile( String fileName){
        // 2 premieres lignes indiquent m x n -> faire des tableaux

        Arbre tree = new Arbre();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            String[] dimension = line.split("\\s+");

            int colonne = Integer.parseInt(dimension[0]);
            int ligne = Integer.parseInt(dimension[1]);

            Grille grille = new Grille(colonne,ligne);

            } catch (IOException var) {
            System.err.println("Error reading file: " + var.getMessage());
            PrintStream e = System.out;
            File x = new File(fileName);
            e.println("Absolute path:" + x.getAbsolutePath());
        }

    }




}

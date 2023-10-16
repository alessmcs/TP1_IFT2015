import java.util.ArrayList;
import java.util.Arrays;

// TODO:  lire le fichier txt pour identifier la grille
// TODO: si un mot est le préfixe d'un autre, pas besoin de refaire la recherche
// TODO: arbre pour la liste de mots pour eviter de refaire la recherche
public class Main {
    public static void main(String[] args) {

        String path = "/Users/oceane/Desktop/TP1_IFT2015/tp1_automne2023/TP1Input.txt";

        Grille grille = Command.readFile(path);
        System.out.println(grille.getColonne());

        char[][] liste = Command.listLettre(grille);

        System.out.println(Command.trouverVoisin(2,2, liste));

        System.out.println(Arrays.deepToString(liste));

    }

}
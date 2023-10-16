public class Arbre {

    private String[] listeMots;
    private String[][] listeMots2d;

    private char[] tree;

    // Tree constructor
    public Arbre(String[] listeMots) {
        this.listeMots = listeMots;
        this.listeMots2d = makeMap(listeMots);
        makeNodes();
    }

    public String[][] makeMap(String[] listeMots) {
        String[][] listeMots2d = new String[listeMots.length][];
        for (int i = 0; i < listeMots.length; i++){
            String[] word = listeMots[i].split("");
            listeMots2d[i] = word;
        }
        System.out.println(listeMots2d);
        return listeMots2d;
    }

    public void makeNodes(){
        // compare first letters and make parent nodes 1-5 (in this case)
        // parse through the letter list and compare the first element of each, then add that letter if it appears more than once
        // maybe associate to indexes??
        String[] firstLetters = new String[listeMots.length]; //array des premières lettres des mots
        for (int i = 0; i < listeMots.length; i++){
            firstLetters[i] = listeMots2d[i][0];
        }

}
// build a tree from listeMots
    // 1- découper en lettres
    // 2- find which letters are in common and make nodes



}

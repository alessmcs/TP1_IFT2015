import java.util.*;

public class Arbre {


    private String[] listeMots;
    private String[][] listeMots2d;

    //private char[] testArray = new char[]{'m','a','k','s', 'o', 'n', 'j', 'l', 'n'};

    /*
    a k s
    e m n
    n j n
     */

    /*
    s e a m
    e s p n
    l e v o
    l n l p
     */

    // cols & lignes du tableau
    private int m = 4;
    private int n = 4;
    public void setTestArraySize(int m, int n) {
        this.testArray = testArray;
    }

    //public static char[][] testArray = new char[m][n];
    public static char[][] testArray = {{'s','e','a','m'}, {'e','s','p','n'}, {'l','e','v','o'}, {'l','n','l','p'}};

    // index of an element in a 2d array
    List<ArrayList<List<Character>>> letterArray = new ArrayList<ArrayList<List<Character>>>();
    // this right now is the grid input

    // méthode to iterate through the voisins & add to the list

    // setLetterArray makes an arrayList of my test array
    public void setLetterArray(){
        for (int i = 0; i < this.m; i++){
            ArrayList<List<Character>> aL = new ArrayList<>();
            for (int j = 0; j < this.n; j++){
                aL.add(Collections.singletonList((Character) testArray[i][j]));
            }
            letterArray.add(aL);
        }
    }
    // Tree constructor
    public Arbre(String[] listeMots) {
        this.listeMots = listeMots;
        for( String mot: listeMots ) this.insert( mot );
        setLetterArray(); // builds the correct form of the array implementing list methods
        findWord(letterArray, testArray);
    }
    private final TrieNode root = new TrieNode(); // root of the Trie ; empty node

    // Code du Trie basé sur les notes de cours

    // Utiliser le Trie pour construire l'arbre à partir de la liste de mots (NOTES DE COURS)
    private static class TrieNode {
        private Map<Character,TrieNode> children; // Map for children nodes
        private boolean isWord; // boolean for marking word nodes; remove the prefix restriction
        private boolean hasNext;
        private TrieNode parent;
        // constructor
        public TrieNode() {
            //this.parent = parent;
            children = new HashMap<>(); // empty HashMap for children
            this.isWord = false; // a node is not storing a word by default
            //this.hasNext = true;
        }
        @Override
        public String toString() {
            return "Node< " + this.children.size() + " children, is a word? " + this.isWord + " >";
        }
    }
    public void insert( String word ) {
        // insert a word in the Trie
        TrieNode node = root; // take the root
        for( char c: word.toCharArray() ) {
            // if there is no node with char c in the children, create it
            if( node.children.get( c ) == null ) node.children.put( c, new TrieNode() );
            node = node.children.get( c ); // move to it to process the next char
        }
        node.isWord = true; // last node accessed was for the last char of word

    }




    // function to find letters in the tree
    // iterate through the tree with each square being read

    public boolean findWord(List<ArrayList<List<Character> >> array, char[][] charArray){
        /* this bit identifies if the current (middle) letter is located in the first level of the tree
          then the current node becomes the new parent node we found
          the next step is to check for any child nodes as long as TrieNode.isWord = false
          if none are found i give up and move on to the next
          for now we're working w the top square of the grid
         */

        // TODO: handle elements on the sides of the grid
        // work with the 2d array to get the info and the list object to get indexes
        char[] squareArray = {  charArray[0][0],  charArray[0][1],  charArray[0][2],  charArray[1][0],
                charArray[1][1],  charArray[1][2] };

        TrieNode currentNode = root;
        for (char c : squareArray){
            // children is a HashMap within a node so i can use the .get(c) method
            char character = c;
            TrieNode node = currentNode.children.get(c);
            int index = 1; //skip the first letter of the array when you look for the rest of the letters
            searchChildren(node, squareArray, index);
            // maybe work with prefixes genre find a prefix and from there make a new root & search
        }

        return false;
    }


    public void searchChildren(TrieNode parent, char[] array, int index){
        // TrieNode currentNode = parent;
        // ArrayList to add elements for the word (indexes from the 2d grid)
        // make a pointer for the branch & recursive call there when you're back
        //TODO: throw exceptions
        TrieNode childNode = null;
        TrieNode branchNode = parent; // pointer ; temp value for index so I can return to it when i go back up the branch

        ArrayList<int[]> chemin = new ArrayList<>(); // maybe mets à l'extérieur
        char character = array[index];

        if(parent.children != null) childNode = parent.children.get(character); // if it's not null keep moving down the branch

        if (childNode != null && childNode.isWord == false){
            // if not null, recursive call until isWord or null (so only part of the word is in the array not the whole thing)
            // childNode becomes parent, array stays the same but index advances

            chemin.add(CharArraySearch(testArray, character)); // add to the coordinates
            searchChildren(childNode,array,++index);

        } else if (childNode != null && childNode.isWord == true){
            System.out.println("Word found!");
            // when the word is found, return to the base of the branch and check the array for an earlier index
            // if it's the end of the branch, go back to the parent and check for other children
            if(childNode.children == null) searchChildren(branchNode,array,++index);
            // if it's not the end of the branch & the word is found, keep advancing until the next word
            if(childNode.children != null) searchChildren(childNode,array,++index);

        } else if (childNode==null){
            searchChildren(parent, array, ++index);
        } else {
            System.out.println("No word in sub-grid");
        }

    }
    // TODO: find a way to return the word we found


    public int[] CharArraySearch(char[][] charArray, char target) {

        int rowIndex = -1;
        int columnIndex = -1;

        int[] result = new int[2]; // tableau pour les coordonnées

        // Loop through the rows and columns to find the character
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                if (charArray[i][j] == target) {
                    result[0] = i; // row index
                    result[1] = j; // col index
                    break; // Exit the loop when the character is found
                }
            }
        }
        return result;
    }
}




public class Lettre {
    char caractere;
    int indexX;
    int indexY;
    public Lettre(char caractere, int indexX, int indexY) {
        this.caractere = caractere;
        this.indexX = indexX;
        this.indexY = indexY;
    }

    public char getCaractere(){
        return caractere;
    }

    public int getIndexX(){
        return indexX;
    }

    public int getIndexY(){
        return indexY;
    }
}

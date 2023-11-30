package VoyagesAeriennes;

import java.util.Random;

import MethodesStatiques.MethodesUniverselles;

public class Aeroport {
    private String nom;
    private String code;
    private static String codes[];
    private static int tailleCodes=0;
    private Vol volesDeparts[];
    private Vol volesArrive[];
    private TarifLocal tarif;
    public Aeroport(String nom) {
        this.nom = nom;
        this.code = generateString(nom+"0123456789@^\\#&~|-_@=+°)({}[]", 5,tailleCodes);
        // ajouter code unique au codes
        ajouterElement(code);

    }   

    public static void ajouterElement(String code){
        String c[] = new String[tailleCodes+1];
        MethodesUniverselles.copierTableaux(c,codes,tailleCodes);
        c[tailleCodes] = code;
        tailleCodes++;
    }

    public static boolean existe(String ch, String[]tab,int tailleC){
        int i=0;
        while(ch.compareTo(tab[i])!=0 && i<tailleC)
            i++;
        return(i>=tailleC)?false:true;
    }

    public static String generateString(String characters, int length, int tailleC){
        char[] text = new char[length];
        Random rng = new Random();
        String res;
        do{
            for (int i = 0; i < length; i++)
            {
                text[i] = characters.charAt(rng.nextInt(characters.length()));
            }
            res = new String(text);
        }while(existe(res,codes,tailleC));
        return res;
    }

    public void ajouterVol(Vol v){
        //
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}

package VoyagesAeriennes;

import java.util.Arrays;

import Exceptions.VolNotFoundException;
import MethodesStatiques.MethodesUniverselles;

public class Aeroport implements Aviation {
    private String nom;
    private static int N=0;
    private String code;
    private static String codes[];
    private static int tailleCodes=0;
    private Vol volesDeparts[];
    private int capaciteVolesDeparts =-1;
    private Vol volesArrive[];
    private int capaciteVolesArrive =-1;
    private TarifLocal tarif;
    private double rating;
    
    public Aeroport(String nom, TarifLocal tarif, double rating){
        this.nom = nom;
        this.rating = rating;
        //this.code = generateString(nom+"0123456789@^\\#&~|-_@=+°)({}[]", 5,tailleCodes);
        this.code = nom + " " +Integer.toString(N);
        N++;
        // ajouter code unique au codes
        ajouterElement(code);
        // voles
        this.tarif = tarif;
        this.capaciteVolesDeparts ++;
        this.volesDeparts = new Vol[capaciteVolesDeparts];
        this.capaciteVolesArrive ++;
        this.volesArrive = new Vol[capaciteVolesArrive];
    }   
    
    @Override
    public String toString() {
        return "Aeroport: nom=" + nom + ", code=" + code + ", rating=" + rating + "%, tarif=" + tarif + ", on a "+capaciteVolesDeparts+" vol(s) de depart:" + Arrays.toString(volesDeparts)
                + ", on a "+capaciteVolesArrive+" vol(s) d'arrivé: "+ Arrays.toString(volesArrive)+"\n";
    }

    //getters & setters
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
    public static String[] getCodes() {
        return codes;
    }

    public static void setCodes(String[] codes) {
        Aeroport.codes = codes;
    }

    public static int getTailleCodes() {
        return tailleCodes;
    }

    public static void setTailleCodes(int tailleCodes) {
        Aeroport.tailleCodes = tailleCodes;
    }

    public Vol[] getVolesDeparts() {
        return volesDeparts;
    }

    public void setVolesDeparts(Vol[] volesDeparts) {
        this.volesDeparts = volesDeparts;
    }

    public int getCapaciteVolesDeparts() {
        return capaciteVolesDeparts;
    }

    public void setCapaciteVolesDeparts(int capaciteVolesDeparts) {
        this.capaciteVolesDeparts = capaciteVolesDeparts;
    }

    public Vol[] getVolesArrive() {
        return volesArrive;
    }

    public void setVolesArrive(Vol[] volesArrive) {
        this.volesArrive = volesArrive;
    }

    public int getCapaciteVolesArrive() {
        return capaciteVolesArrive;
    }

    public void setCapaciteVolesArrive(int capaciteVolesArrive) {
        this.capaciteVolesArrive = capaciteVolesArrive;
    }

    public TarifLocal getTarif() {
        return tarif;
    }

    public void setTarif(TarifLocal tarif) {
        this.tarif = tarif;
    }

    //methods
    public static void ajouterElement(String code){
        String c[] = new String[tailleCodes+1];
        MethodesUniverselles.copierTableaux(c,codes,tailleCodes);
        c[tailleCodes] = code;
        codes = c;
        tailleCodes++;
    }

    
    
    public void ajouterVolDeparts(Vol V){
        Vol v[] = new Vol[capaciteVolesDeparts+1];
        MethodesUniverselles.copierTableaux(v, volesDeparts, capaciteVolesDeparts);
        v[capaciteVolesDeparts]=V;
        volesDeparts = v;
        capaciteVolesDeparts++;
    }
    
    public void supprimerVoldDeparts(Vol V) throws VolNotFoundException{
        Vol v = volesDeparts[0];
        int i=0;
        while(!V.equals(v) && i<capaciteVolesDeparts){
            i++;
            v = volesDeparts[i];
        }
        if(i<capaciteVolesDeparts){
            MethodesUniverselles.decalage(volesDeparts,i,capaciteVolesDeparts);
            capaciteVolesDeparts--;
        }
        else{
            throw new VolNotFoundException(V);
        }
    }
    
    public void ajouterVolArrive(Vol V){
        Vol v[] = new Vol[capaciteVolesArrive+1];
        MethodesUniverselles.copierTableaux(v, volesArrive, capaciteVolesArrive);
        v[capaciteVolesArrive]=V;
        volesArrive = v;
        capaciteVolesArrive++;
    }
    
    public void supprimerVoldArrive(Vol V)throws VolNotFoundException{
        Vol v = volesArrive[0];
        int i=0;
        while(!V.equals(v) && i<capaciteVolesArrive){
            i++;
            v = volesArrive[i];
        }
        if(i<capaciteVolesArrive){
            MethodesUniverselles.decalage(volesArrive,i,capaciteVolesArrive);
            capaciteVolesArrive--;
        }
        else{
            throw new VolNotFoundException(V);
        }
    }
    
}

/* public static String generateString(String characters, int length, int tailleC){
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
} */
/* public static boolean existe(String ch, String[]tab,int tailleC){
    int i=0;
    while(ch.compareTo(tab[i])!=0 && i<tailleC)
        i++;
    return(i>=tailleC)?false:true;
} */
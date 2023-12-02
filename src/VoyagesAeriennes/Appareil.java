package VoyagesAeriennes;

import Exceptions.ChargeUtilMaxDepasseException;
import Exceptions.ModelAppareilNotUniqueException;
import MethodesStatiques.MethodesUniverselles;

public class Appareil {
    private String model;
    private static String models[];
    private static int tailleModels=0;
    private double capaciteCarburant,equippage;
    private double consommationVide; // n’inclut pas le transport du carburant lui-même
    private double chargeUtilMax;
    private double consommationSupp;
    private Vol voles[];
    private int capaciteVoles=-1;// aussi capaciteChargeUtil
    private int capaciteVolesMax;
    private DateVol dates[];
    private int capaciteDates=-1;
    /* private double chargeUtile[];
    private int capaciteChargeUtil=-1; */
    
    // Constructor    
    public Appareil(String model, double capaciteCarburant, double equippage, int capaciteVolesMax, double consommationVide, double consommationSupp, double chargeUtilMax)throws ModelAppareilNotUniqueException {
        if(existe(model, models, tailleModels))
            throw new ModelAppareilNotUniqueException(model);
        this.model = model;
        // ajouter model
        ajouterElement(model);
        this.chargeUtilMax = chargeUtilMax;
        this.capaciteVolesMax = capaciteVolesMax;
        this.capaciteCarburant = capaciteCarburant;
        this.equippage = equippage;
        this.consommationVide = consommationVide;
        //this.chargeUtile = new double[0];
        this.consommationSupp = consommationSupp;
        this.voles = new Vol[0];
        this.capaciteVoles ++;;
    }

    public static void ajouterElement(String model){
        String m[] = new String[tailleModels+1];
        MethodesUniverselles.copierTableaux(m,models,tailleModels);
        m[tailleModels] = model;
        models = m;
        tailleModels++;
    }

    public static boolean existe(String ch, String[]tab,int tailleC){
        int i=0;
        while(ch.compareTo(tab[i])!=0 && i<tailleC)
            i++;
        return(i>=tailleC)?false:true;
    }


    // getters & setters
    public int getCapaciteVolesMax() {
        return capaciteVolesMax;
    }

    public void setCapaciteVolesMax(int capaciteVolesMax) {
        this.capaciteVolesMax = capaciteVolesMax;
    }

    public String getModel() {
        return model;
    }
    
    public static String[] getModels() {
        return models;
    }

    public static void setModels(String[] models) {
        Appareil.models = models;
    }

    public static int getTailleModels() {
        return tailleModels;
    }

    public static void setTailleModels(int tailleModels) {
        Appareil.tailleModels = tailleModels;
    }

    public double getChargeUtilMax() {
        return chargeUtilMax;
    }


    public void setChargeUtilMax(double chargeUtilMax) {
        this.chargeUtilMax = chargeUtilMax;
    }


    public int getCapaciteVoles() {
        return capaciteVoles;
    }


    public void setCapaciteVoles(int capaciteVoles) {
        this.capaciteVoles = capaciteVoles;
    }


    public void setModel(String model) {
        this.model = model;
    }
    
    public double getCapaciteCarburant() {
        return capaciteCarburant;
    }
    
    public void setCapaciteCarburant(double capaciteCarburant) {
        this.capaciteCarburant = capaciteCarburant;
    }
    
    public double getEquippage() {
        return equippage;
    }
    
    public void setEquippage(double eqippage) {
        this.equippage = eqippage;
    }
    
    public double getConsommationVide() {
        return consommationVide;
    }
    
    public void setConsommationVide(double consommationVide) {
        this.consommationVide = consommationVide;
    }
    public double getConsommationSupp() {
        return consommationSupp;
    }
    
    public void setConsommationSupp(double consommationSupp) {
        this.consommationSupp = consommationSupp;
    }
    
    public Vol[] getVoles() {
        return voles;
    }
    
    public void setVoles(Vol[] voles) {
        this.voles = voles;
    }
    
    public int getcapaciteVoles() {
        return capaciteVoles;
    }
    
    public void setcapaciteVoles(int capaciteVoles) {
        this.capaciteVoles = capaciteVoles;
    }
    public DateVol[] getDates() {
        return dates;
    }
    
    public void setDates(DateVol[] dates) {
        this.dates = dates;
    }
    
    public int getCapaciteDates() {
        return capaciteDates;
    }
    
    public void setCapaciteDates(int capaciteDates) {
        this.capaciteDates = capaciteDates;
    }
    // methods
    public int getVolParDate(DateVol date){ // à faire
        return 0;
    }

    public double getConsommationEnVol(){
        return consommationSupp + consommationVide;
    }
    
    public boolean equals(Appareil A){
        return (this.model==A.model)?true:false;
    }
    
    public void ajouterVol(Vol V){
        Vol v[] = new Vol[capaciteVoles+1];
        for(int i=0;i<capaciteVoles;i++){
            v[i] = voles[i];
        }
        v[capaciteVoles]=V;
        voles = v;
        capaciteVoles++;
    }
    
    public void supprimerVol(Vol V){
        Vol v = voles[0];
        int i=0;
        while(!V.equals(v) && i<capaciteVoles){
            i++;
            v = voles[i];
        }
        if(i<capaciteVoles){
            MethodesUniverselles.decalage(voles,i,capaciteVoles);
            capaciteVoles--;
        }
        else{
            return;// exception!
        }
    }
    public void ajouterDate(DateVol date){
        DateVol d[] = new DateVol[capaciteDates+1];
        MethodesUniverselles.copierTableaux(d,dates,capaciteDates);
        d[capaciteDates] = date;
        dates = d;
        capaciteDates++;
    }
    public void supprimerDate(DateVol date){
        int i=0;
        DateVol d = dates[0];
        while(!d.equals(date) && i<capaciteDates){
            i++;
            d = dates[i];
        }
        if(i<capaciteDates){
            MethodesUniverselles.decalage(dates,i,capaciteDates);
            capaciteDates--;
        }
        else{
            return;// exception!
        }
    }
    public void ravitalleEnCarburant(double carburant){ this.capaciteCarburant += carburant;}
    public boolean chargeUtileValide(double charge)throws ChargeUtilMaxDepasseException{
        if(charge>chargeUtilMax)
            throw new ChargeUtilMaxDepasseException(chargeUtilMax);
        else 
            return true;
    }
}
/* 
public double[] getChargeUtile() {
    return chargeUtile;
}

public void setChargeUtile(double [] chargeUtile) {
    this.chargeUtile = chargeUtile;
}
 */
/* public void ajouterChargeUtile(double charge){
    if(charge>chargeUtilMax)
    return; // exception!
    double c[] = new double[capaciteChargeUtil+1];
    MethodesUniverselles.copierTableaux(c,chargeUtile,capaciteChargeUtil);
    c[capaciteChargeUtil] = charge;
    chargeUtile = c;
    capaciteChargeUtil++;
}

public void supprimerChargeUtile(double charge){
    int i=0;
    double c = chargeUtile[0];
    while(c !=charge && i<capaciteDates){
        i++;
        c = chargeUtile[i];
    }
    if(i<capaciteDates){
        MethodesUniverselles.decalage(chargeUtile,i,capaciteDates);
        capaciteDates--;
    }
    else{
        return;// exception!
    }
} */
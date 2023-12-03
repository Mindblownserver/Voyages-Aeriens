package VoyagesAeriennes;

import java.util.Arrays;
import java.util.Date;

import Exceptions.*;
import MethodesStatiques.MethodesUniverselles;

public class Appareil implements Aviation{
    private String code;
    private static String codes[];
    private static int tailleCodes=0;
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
    public Appareil(String code, double capaciteCarburant, double equippage, int capaciteVolesMax, double consommationVide, double consommationSupp, double chargeUtilMax)throws ValeurNotUniqueException, InvalidValeurException {
        if(tailleCodes !=0 && existe(code))
            throw new ValeurNotUniqueException(0,code);
        if(capaciteVolesMax<=0)
            throw new InvalidValeurException(0,code,capaciteVolesMax);
        if(chargeUtilMax<200)
            throw new InvalidValeurException(1,code ,200);
        this.code = code;
        // ajouter code
        ajouterElement(code);
        this.chargeUtilMax = chargeUtilMax;

        this.capaciteVolesMax = capaciteVolesMax;
        this.capaciteCarburant = capaciteCarburant;
        this.equippage = equippage;
        this.consommationVide = consommationVide;
        //this.chargeUtile = new double[0];
        this.consommationSupp = consommationSupp;
        this.voles = new Vol[0];
        this.dates = new DateVol[0];
        this.capaciteVoles ++;
        this.capaciteDates++;
    }

    public static void ajouterElement(String code){
        String m[] = new String[tailleCodes+1];
        MethodesUniverselles.copierTableaux(m,codes,tailleCodes);
        m[tailleCodes] = code;
        codes = m;
        tailleCodes++;
    }

    public  boolean existe(String ch){
        int i=0;
        while(i<tailleCodes && ch.compareTo(codes[i])!=0)
            i++;
        return(i>=tailleCodes)?false:true;
    }

    
    @Override
    public String toString() {
        return "Code=" + code + ", CapaciteCarburant=" + capaciteCarburant + ", Equipage=" + equippage
                + ", ConsommationVide=" + consommationVide + ", ChargeUtilMax=" + chargeUtilMax + ", ConsommationSupp="
                + consommationSupp + ", il accepte au max "+capaciteVolesMax+", et il a "+capaciteVoles+" Vol(s):{" + Arrays.toString(voles) + "}"
                +" il a "+capaciteDates+" date(s):{" + Arrays.toString(dates) + "}";
    }

    // getters & setters
    public int getCapaciteVolesMax() {
        return capaciteVolesMax;
    }

    public void setCapaciteVolesMax(int capaciteVolesMax) {
        this.capaciteVolesMax = capaciteVolesMax;
    }

    public String getCode() {
        return code;
    }
    
    public static String[] getCodes() {
        return codes;
    }

    public static void setCodes(String[] codes) {
        Appareil.codes = codes;
    }

    public static int getTailleCodes() {
        return tailleCodes;
    }

    public static void setTailleCodes(int tailleCodes) {
        Appareil.tailleCodes = tailleCodes;
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


    public void setCode(String code) {
        this.code = code;
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
        int res = 0;
        for(int i =0;i<capaciteVoles;i++){

            if(voles[i].getDates()[0].getDateDepart().equals(date.getDateDepart()) && voles[i].getDates()[capaciteVoles-1].getDateArrive().equals(date.getDateArrive()))
                res+=1;
        }
        return res;
    }

    public double getConsommationEnVol(){
        return consommationSupp + consommationVide;
    }
    
    public boolean equals(Appareil A){
        return (this.code==A.code)?true:false;
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
    
    public void supprimerVol(Vol V) throws VolNotFoundException{
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
            throw new VolNotFoundException(V);
        }
    }
    public void ajouterDate(DateVol date) throws InvalidValeurException{
        Date today = new Date();
        // Tester si la date est valide(>= date d'aujourd'hui)
        if(date.getDateDepart().compareTo(today)<0)
            throw new InvalidValeurException(0);
        // ajouter la date
        DateVol d[] = new DateVol[capaciteDates+1];
        MethodesUniverselles.copierTableaux(d,dates,capaciteDates);
        d[capaciteDates] = date;
        dates = d;
        capaciteDates++;
    }
    public void supprimerDate(DateVol date)throws DateVolNotFoundException{
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
            throw new DateVolNotFoundException(date);
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
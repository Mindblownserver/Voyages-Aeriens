package VoyagesAeriennes;

import MethodesStatiques.MethodesTableaux;

public class Appareil {
    private String model;
    private double capaciteCarburant,equippage;
    private double consommationVide; // n’inclut pas le transport du carburant lui-même
    private double chargeUtile[];
    private int capaciteChargeUtil=-1;
    private double consommationSupp;
    private Vol voles[];
    private int capaciteVoles=-1;// aussi capaciteChargeUtil
    private DateVol dates[];
    private int capaciteDates=-1;
    
    // Constructor    
    public Appareil(String model, double capaciteCarburant, double equippage,double capaciteChargeUtil, double consommationVide, double consommationSupp) {
        this.model = model;
        this.capaciteCarburant = capaciteCarburant;
        this.equippage = equippage;
        this.consommationVide = consommationVide;
        this.chargeUtile = new double[0];
        this.consommationSupp = consommationSupp;
        this.voles = new Vol[0];
        this.capaciteVoles ++;;
    }
    // getters & setters

    public String getModel() {
        return model;
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
    
    public double getChargeUtileMax() {
        return chargeUtile;
    }
    
    public void setChargeUtileMax(double chargeUtile) {
        this.chargeUtile = chargeUtile;
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
            MethodesTableaux.decalage(voles,i,capaciteVoles);
            capaciteVoles--;
        }
        else{
            return;
        }
    }
    public void ajouterDate(DateVol date){
        DateVol d[] = new DateVol[capaciteDates+1];
        MethodesTableaux.copierTableaux(d,dates,capaciteDates);
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
            MethodesTableaux.decalage(dates,i,capaciteDates);
            capaciteDates--;
        }
        else{
            return;
        }
    }
}
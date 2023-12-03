package VoyagesAeriennes;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.*;

class Init{
    public static Scanner sc = new Scanner(System.in);
    public Aeroport Carthage,Lyon,Dubai,Paris,Bejaia,Bahrein,Enfidha,Kars;
    public Appareil Airbus220, Airbus320, Airbus330, Airbus350, Airbus380;
    public Appareil Boeing737,Boeing747,Boeing777,Boeing787;
    public double capaciteCarb=1000, equipage=50, consommVide=40, consommSupp=89,chargeUtilMax=500;
    public int capaciteVolMax=2;
    public ArrayList<Aeroport> airports;
    public ArrayList<Appareil> appareils;
    public ArrayList<Vol> vols;
    public TarifLocal tarifTun,tarifFr,tarifBhr,tarifTurk,tarifEma,tarifAlg;
    public Date today = new Date();
    public Date d1 = new Date(2023,12,30);
    public Date d2 = new Date(2023,11,31);
    public Date d3 = new Date(2023,11,30);
    public Date d4 = new Date(2023,9,5);
    public Date d5 = new Date(2023,1,2);
    public Init() throws ValeurNotUniqueException, InvalidValeurException{
        // ajouter Tarif
        tarifTun= new TarifLocal(today, 10);
        tarifFr = new TarifLocal(today, 15);
        tarifEma = new TarifLocal(today, 18);
        tarifAlg= new TarifLocal(today, 13);
        tarifTurk = new TarifLocal(today,7);
        tarifBhr = new TarifLocal(today,17);

        //ajouter aeroports
        Carthage = new Aeroport("Tunis Carthage International Airport", tarifTun,60);
        Lyon = new Aeroport("Lyon Bron Airport",tarifFr,50);
        Dubai = new Aeroport("Dubai International Airport",tarifEma,89);
        Paris = new Aeroport("Paris Le Bourget Airport",tarifFr,82);
        Bejaia = new Aeroport("Bejaia Soummam Airport", tarifAlg,93);
        Bahrein = new Aeroport("Bahrain International Airport",tarifBhr,76);
        Enfidha = new Aeroport("Enfidha Hammamet International Airport", tarifTun,75);
        Kars = new Aeroport("Kars Harakani Airport", tarifTurk, 97);
        // ajouter appareils
        Airbus220 = new Appareil("Airbus 220", capaciteCarb, equipage, capaciteVolMax+1, consommVide, consommSupp, chargeUtilMax);
        Airbus320 = new Appareil("Airbus 320", capaciteCarb, equipage, capaciteVolMax-1, consommVide, consommSupp, chargeUtilMax);
        Airbus330 = new Appareil("Airbus 330", capaciteCarb, equipage, capaciteVolMax+3, consommVide, consommSupp, chargeUtilMax);
        Airbus350 = new Appareil("Airbus 350", capaciteCarb, equipage, capaciteVolMax+2, consommVide, consommSupp, chargeUtilMax);
        Airbus380 = new Appareil("Airbus 380", capaciteCarb, equipage, capaciteVolMax+1, consommVide, consommSupp, chargeUtilMax);
        Boeing737 = new Appareil("Boeing 737", capaciteCarb, equipage, capaciteVolMax-1, consommVide, consommSupp, chargeUtilMax);
        //Boeing747 = new Appareil("Boeing 747", capaciteCarb, equipage, capaciteVolMax-4, consommVide, consommSupp, chargeUtilMax);
        //Boeing777 = new Appareil("Boeing 777", capaciteCarb, equipage, capaciteVolMax-2, consommVide, consommSupp, chargeUtilMax);
        Boeing787 = new Appareil("Boeing 787", capaciteCarb, equipage, capaciteVolMax, consommVide, consommSupp, chargeUtilMax);

        // ArrayLists
        airports = new ArrayList<>();
        vols = new ArrayList<>();
        appareils = new ArrayList<>();
        // aeroports
        airports.add(Bahrein);
        airports.add(Carthage);
        airports.add(Enfidha);
        airports.add(Lyon);
        airports.add(Dubai);
        airports.add(Bejaia);
        airports.add(Kars);
        //appareils
        appareils.add(Airbus220);
        appareils.add(Airbus320);
        appareils.add(Airbus350);
        appareils.add(Airbus380);
        appareils.add(Airbus330);
        appareils.add(Boeing737);
        /* appareils.add(Boeing747);
        appareils.add(Boeing777); */
        appareils.add(Boeing787);
    }
    public void afficheToutAeroports(){
        for(Aeroport air: airports){
            afficherElement(air);
        }
    }

    public void afficheToutAppareils(){
        for(Appareil app: appareils){
            afficherElement(app);
        }
    }
    // mixed feelings for this one
    public <E extends Aviation> int recherche(ArrayList<E> arr, String code){
        int indiceElement = 0;
        while(indiceElement<arr.size()){
            if( arr.get(indiceElement).getCode().compareTo(code)==0)
                return indiceElement;
            indiceElement++;
        }
        return -1;
    }
    public <T extends Aviation> int listerElements(ArrayList<T> arr){
        int i,n;
        for(i=0;i<arr.size();i++){
            System.out.printf("%d-%s\n",i+1,arr.get(i).getCode());
        }
        do{
            System.out.print("Votre Reponse:");
            n = sc.nextInt(); // n va representer le i+1
        }while(n>arr.size());
        return n-1;
    }
    public <T> void afficherElement(T element){
        System.out.println("---------------");
        System.out.println(element);
    }

    public void afficheWelcome(){
        System.out.println("---------------\n");
        System.out.println("1-Consultation\n2-Quitter\nVotre Reponse:");
        int n = sc.nextInt();
        if(n==1)
            this.afficheConsultation();
        else {
            System.out.println("Merci pour utiliser mon application d'aviation...");
        }
    }
    public void afficheConsultation(){
        System.out.println("---------------\nVoici les commandes pour l'operation Consultation:");
        System.out.print("1-Affichage\n2-Calculer consommation en Vol\n3-Calculer longueur d'une Vol\n4-Calculer (en litres) la quantite du carburant nécessaire pour un vol\n5-Calculer (en litres) la quantite du carburant nécessaire pour un tronçon du vol\n6-Calculer Nombre des escales pour un Vol\nVotre reponse:");
        int n= sc.nextInt();
        switch (n) {
            case 1:
                this.afficherAffichage();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                break;    
        }
        this.afficheWelcome();
    }
    public void afficherAffichage(){
        System.out.println("---------------\nQue'est qu'on va afficher?");
        System.out.print("1-Tout aeroports\n2-Un aeroport\n3-Tout vols\n4-Un vol\n5-Tout appareils\n6-Un appareil\n7-touts Tronçons\n8-Un tronçon\nVotre reponse:");
        int indice;
        switch (sc.nextInt()) {
            case 1:
                afficheToutAeroports();
                break;
            case 2:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(airports);
                afficherElement(airports.get(indice));
                break;
            case 3:
                break;
            case 4: break;
            case 5:
                afficheToutAppareils();
                break;
            case 6:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(appareils);
                afficherElement(appareils.get(indice)); 
            default:
                break;
        }
    }
}

public class Teste {
    
    public static void main(String[] args) {
        try{
            System.out.println("Synchronisation des données est en cours!");
            System.out.println("Bienvenu à l'application de gestion des voyages Aérienne, voici les commandes disponibles pour vous:");
            Init a = new Init();
            a.afficheWelcome();
                
        }catch(InputMismatchException e){
            System.out.println("Vous n'avez pas saisi un chiffre\nArrêt du programme");

        }
        catch(Exception e){
            System.out.println(e);
        }finally{
            Init.sc.close();
            System.exit(0);
        }
    }
}

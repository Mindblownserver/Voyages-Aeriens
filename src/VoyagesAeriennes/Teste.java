package VoyagesAeriennes;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.*;

class Init{
    public static Scanner sc = new Scanner(System.in);
    public Vol TunAlgVol,TunFrVol,AlgTunVol,FrTunVol,FrTurkVol,TurkFrVol,TurkEmaVol,TurkBhVol,FrAlgVol,AlgFrVol,EmaTunVol,EmaFrVol,AlgEmaVol,EmaAlgVol;
    public ArrayList<Vol> vols;
    public TronconDuVol AlgTurkTr,TurkEmaTr,EmaTurkTr,TurkAlgTr,TunTurkTr,TurkTunTr,FrTurkTr,TurkFrTr,FrAlgTr,AlgFrTr,FrTunTr,TunFrTr,AlgTunTr,TunAlgTr;
    public ArrayList<TronconDuVol> troncons;
    public Aeroport Carthage,Lyon,Dubai,Paris,Bejaia,Enfidha,Kars;
    public Appareil Airbus220, Airbus320, Airbus330, Airbus350, Airbus380;
    public Appareil Boeing737,Boeing747,Boeing777,Boeing787;
    public double capaciteCarb=1000, equipage=50, consommVide=40, consommSupp=89,chargeUtilMax=583, carburantNecessaire = 200;
    public double longEmaTurk=2423,longTurkAlg=3325,longTunTurk=2364,longFrTurk=2792.75,longFrTun=1504,longAlgTun=891.2,longAlgFr=2003.44; // en km
    public int capaciteVolMax=2;
    public ArrayList<Aeroport> airports;
    public ArrayList<Appareil> appareils;
    public TarifLocal tarifTun,tarifFr,tarifTurk,tarifEma,tarifAlg;
    public ArrayList<TarifLocal> tarifs;
    public Date today = new Date();
    public Date d1;
    public Date d2; 
    public Date d3; 
    public Date d4; 
    public DateVol date1,date2,date3,date4;
    public ArrayList<DateVol> dates;
    public static Date getDate(int year,int month, int day){
        Calendar c = new GregorianCalendar();
        c.set(year,month,day);
        return c.getTime();
    }
    
    public Init() throws ValeurNotUniqueException, InvalidValeurException,InvalidTronconException, DateVolNotFoundException,ChargeUtilMaxDepasseException, CapaciteVolMaxDepasseException{
        // ajouter dates 
        d1 = getDate(2023, 12, 11);
        d2=getDate(2022,4,6);
        d3 = getDate(2023,11,8);
        d4 = getDate(2023,2,29);
        // ajouter Tarif
        tarifTun= new TarifLocal(today, 10);
        tarifFr = new TarifLocal(today, 15);
        tarifEma = new TarifLocal(today, 18);
        tarifAlg= new TarifLocal(today, 13);
        tarifTurk = new TarifLocal(today,7);
        //ajouter aeroports
        Carthage = new Aeroport("Tunis Carthage International Airport", tarifTun,60);
        Lyon = new Aeroport("Lyon Bron Airport",tarifFr,50);
        Dubai = new Aeroport("Dubai International Airport",tarifEma,89);
        Paris = new Aeroport("Paris Le Bourget Airport",tarifFr,82);
        Bejaia = new Aeroport("Bejaia Soummam Airport", tarifAlg,93);
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
        // ajouter vols
        TunAlgVol =new Vol(Carthage,Bejaia,"Militaire",500);
        //TunAlgVol =new Vol(Enfidha,Bejaia,"Militaire",500);
        TunFrVol = new Vol(Enfidha,Lyon,"Commercial",300);
        AlgTunVol =new Vol(Bejaia,Carthage,"Commercial",400);
        FrTunVol = new Vol(Paris, Carthage, "Commercial", 600);
        FrTurkVol =new Vol(Paris, Kars, "Commercial", 438);
        TurkFrVol =new Vol(Kars,Lyon,"privés",280);
        TurkEmaVol=new Vol(Kars,Dubai,"Courrier/Cargo",670);
        FrAlgVol = new Vol(Lyon,Bejaia,"privé",340);
        AlgFrVol = new Vol(Bejaia,Paris,"Corrier/Cargo",250);
        EmaTunVol= new Vol(Dubai,Carthage,"Commercial",869);
        EmaFrVol = new Vol(Dubai,Lyon,"privé",972);
        AlgEmaVol =new Vol(Bejaia,Dubai,"Commercial",616);
        EmaAlgVol =new Vol(Dubai,Bejaia,"Commercial",537);
        // ajouter troncons
        AlgTurkTr = new TronconDuVol(carburantNecessaire, Bejaia, Kars,longTurkAlg);
        TurkEmaTr = new TronconDuVol(carburantNecessaire, Kars, Dubai, longEmaTurk);
        EmaTurkTr = new TronconDuVol(carburantNecessaire, Dubai, Kars, longEmaTurk);
        TurkAlgTr = new TronconDuVol(carburantNecessaire, Kars, Bejaia, longTurkAlg);
        TunTurkTr = new TronconDuVol(carburantNecessaire, Carthage, Kars, longTunTurk);
        TurkTunTr = new TronconDuVol(carburantNecessaire, Kars, Enfidha,longTunTurk);
        TurkFrTr = new TronconDuVol(carburantNecessaire,Kars ,Lyon, longFrTurk);
        FrTurkTr = new TronconDuVol(carburantNecessaire, Paris, Kars, longFrTurk);
        FrAlgTr = new TronconDuVol(carburantNecessaire, Paris, Bejaia, longAlgFr);
        AlgFrTr = new TronconDuVol(carburantNecessaire, Bejaia, Paris, longAlgFr);
        FrTunTr = new TronconDuVol(carburantNecessaire, Paris, Enfidha, longFrTun);
        TunFrTr = new TronconDuVol(carburantNecessaire, Carthage, Paris, longFrTun);
        AlgTunTr = new TronconDuVol(carburantNecessaire,Bejaia,Carthage, longAlgTun);
        TunAlgTr = new TronconDuVol(carburantNecessaire, Carthage, Bejaia, longAlgTun);
        // TunAlgTr = new TronconDuVol(carburantNecessaire, Enfidha, Bejaia, longAlgTun);
        // ajouter les dates du Vol
        date1 = new DateVol(d2, d1);
        date2 = new DateVol(d2, today);
        date3 = new DateVol(today, d1);
        //date4= new DateVol(d3,today);
        // ajouter partir
        ajouterPartir(Carthage, TunAlgVol);
        ajouterPartir(Bejaia, AlgEmaVol);
        ajouterPartir(Dubai,EmaFrVol);
        // ajouter arriver
        ajouterArriver(Lyon, EmaFrVol);
        ajouterArriver(Bejaia, TunAlgVol);
        ajouterArriver(Dubai, AlgEmaVol);
        // ajouter contenir
        ajouterContenir(TunAlgVol, TunAlgTr, date1);
        ajouterContenir(AlgEmaVol, AlgTurkTr, date2);
        ajouterContenir(AlgEmaVol, TurkEmaTr, date3);
        ajouterContenir(EmaFrVol, EmaTurkTr, date2);
        ajouterContenir(EmaFrVol, TurkFrTr, date3);

        // ArrayLists
        airports = new ArrayList<>();
        vols = new ArrayList<>();
        appareils = new ArrayList<>();
        troncons = new ArrayList<>();
        dates = new ArrayList<>();
        tarifs = new ArrayList<>();
        // tarifs
        tarifs.add(tarifAlg);
        tarifs.add(tarifEma);
        tarifs.add(tarifFr);
        tarifs.add(tarifTun);
        tarifs.add(tarifTurk);
        // dates des vols
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        
        // troncons
        troncons.add(AlgTurkTr);
        troncons.add(TurkEmaTr);
        troncons.add(EmaTurkTr);
        troncons.add(TurkAlgTr);
        troncons.add(TunTurkTr);
        troncons.add(TurkTunTr);
        troncons.add(TurkFrTr);
        troncons.add(FrTurkTr);
        troncons.add(FrAlgTr);
        troncons.add(AlgFrTr);
        troncons.add(FrTunTr);
        troncons.add(TunFrTr);
        troncons.add(AlgTunTr);
        troncons.add(TunAlgTr);
        // vols
        vols.add(TunAlgVol);
        vols.add(TunFrVol);
        vols.add(AlgTunVol);
        vols.add(AlgFrVol);
        vols.add(FrTunVol);
        vols.add(FrTurkVol);
        vols.add(TurkFrVol);
        vols.add(TurkEmaVol);
        vols.add(FrAlgVol);
        vols.add(EmaTunVol);
        vols.add(EmaFrVol);
        vols.add(AlgEmaVol);
        vols.add(EmaAlgVol);
        // aeroports
        airports.add(Carthage);
        airports.add(Enfidha);
        airports.add(Lyon);
        airports.add(Dubai);
        airports.add(Bejaia);
        airports.add(Kars);
        // appareils
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
    public void ajouterContenir(Vol v, TronconDuVol t, DateVol d)throws InvalidTronconException,InvalidValeurException, DateVolNotFoundException{
        new Contenir(v, t, d);
    }
    public void ajouterEffectuer(Vol v, Appareil app, DateVol d)throws ChargeUtilMaxDepasseException, CapaciteVolMaxDepasseException, InvalidValeurException{
        new Effectuer(v,app,d);
    }
    public void ajouterPartir(Aeroport dep, Vol v)throws InvalidValeurException{
        new Partir(dep, v);
    }
    public void ajouterArriver(Aeroport arr, Vol v)throws InvalidValeurException{
        new Arriver(v,arr);
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
    public <E> void afficherToutElements(ArrayList<E> arr){
        for(E element: arr){
            afficherElement(element);
        }
    }
    public <T> void afficherElement(T element){
        System.out.println("---------------");
        System.out.println(element);
    }

    public void afficheWelcome() throws InvalidTronconException, InvalidValeurException, DateVolNotFoundException,CapaciteVolMaxDepasseException,ChargeUtilMaxDepasseException,ValeurNotUniqueException{
        System.out.println("---------------\n");
        System.out.println("1-Consultation\n2-Modification\n3-Quitter\nVotre Reponse:");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                this.afficheConsultation();
                break;
            case 2:
                this.afficheModification();
                break;
            case 3:
                System.out.println("Merci pour utiliser mon application d'aviation...");
                break;
            default:
                break;
        };
    }
    public void afficheModification()throws InvalidTronconException, InvalidValeurException, DateVolNotFoundException,CapaciteVolMaxDepasseException,ChargeUtilMaxDepasseException,ValeurNotUniqueException{
        System.out.println("---------------\nVoici les commandes pour l'operation Modification:");
        System.out.print("1-Contenir (relie vol, troncon & date vol)\n2-partir (relie vol et son aeroportde depart)\n3-arriver (relie vol et son aeroport d'arrivé)\n4-Effectuer (relie vol, appareil et date vol)\n5-Ajouter une classe\nVotre reponse:");
        int n= sc.nextInt(), indiceApp,indiceVol,indiceTr,indiceAero,indiceDate;
        switch (n) {
            case 1:
                System.out.println("Choisir un d'entre eux:\n");
                indiceVol = listerElements(vols);
                indiceTr = listerElements(troncons);
                indiceDate = listerElements(dates);
                ajouterContenir(vols.get(indiceVol), troncons.get(indiceTr), dates.get(indiceDate));
                System.out.println("\nResultat:\n");
                afficherElement(vols.get(indiceVol));
                afficherElement(dates.get(indiceDate));
                break;
            case 2:
                System.out.println("Choisir un d'entre eux:\n");
                indiceVol = listerElements(vols);
                indiceAero= listerElements(airports);
                ajouterPartir(airports.get(indiceAero), vols.get(indiceVol));
                System.out.println("\nResultat:\n");
                afficherElement(airports.get(indiceAero));
                break;
            case 3:
                System.out.println("Choisir un d'entre eux:\n");
                indiceVol = listerElements(vols);
                indiceAero= listerElements(airports);
                ajouterArriver(airports.get(indiceAero), vols.get(indiceVol));
                System.out.println("\nResultat:\n");
                afficherElement(airports.get(indiceAero));
                break;
            case 4:
                System.out.println("Choisir un d'entre eux:\n");
                indiceVol = listerElements(vols);
                indiceApp = listerElements(appareils);
                indiceDate = listerElements(dates);
                ajouterEffectuer(vols.get(indiceVol), appareils.get(indiceApp), dates.get(indiceDate));
                System.out.println("\nResultat:\n");
                afficherElement(vols.get(indiceVol));
                afficherElement(appareils.get(indiceApp));
                afficherElement(dates.get(indiceDate));
                break;
            case 5:
                System.out.println("Que'est ce que vous voulez ajouter?\n");
                System.out.print("1-Un aeroport\n2-Un Vol\n3-Un Troncon du vol\n4-Un appareil\n5-Une Date du vol\n6-Un Tarif\nVotre reponse");
                n = sc.nextInt();
                ajouterClasse(n);
            default:
                break;
        }
        this.afficheWelcome();
    }
    public void ajouterClasse(int indice)throws ValeurNotUniqueException,InvalidValeurException{
        int indiceTar,indiceAeroDep,indiceAeroArr;
        
        switch (indice) {
            case 1:
                System.out.print("\n Saisir le nom de l'aeroport: ");
                String nom = sc.nextLine()+sc.nextLine();
                System.out.print("\n Saisir le rating de l'aeroport: ");
                double rating = sc.nextDouble();
                System.out.print("\n choisi le tarif de l'aeroport");
                indiceTar = listerElements(tarifs);
                airports.add(new Aeroport(nom, tarifs.get(indiceTar), rating));
                break;
            case 2:
                System.out.print("\nChoisir son aeroport de depart:");
                indiceAeroDep= listerElements(airports);
                System.out.print("\nChoisir son aeroport de d'arrive:");
                indiceAeroArr= listerElements(airports);
                System.out.print("\nQuelle est le type de ce vol:");
                String type =sc.nextLine()+sc.nextLine();
                System.out.print("\nQuelle est sa charge util: ");
                double charge = sc.nextDouble();
                vols.add(new Vol(airports.get(indiceAeroDep),airports.get(indiceAeroArr),type,charge));
                break;
            case 3:
                System.out.print("\nChoisir son aeroport de depart:");
                indiceAeroDep= listerElements(airports);
                System.out.print("\nChoisir son aeroport de d'arrive:");
                indiceAeroArr= listerElements(airports);
                System.out.print("\nQuelle est la quantite du carburant necessaire pour effectuer le troncon: ");
                double carbNecess = sc.nextDouble();
                System.out.print("\n saisie la distance (longueur) entre l'aeroport de depart et d'arrive (en KM)");
                double longueur = sc.nextDouble();
                troncons.add(new TronconDuVol(carbNecess, Paris, Bejaia, longueur));
                break;
            case 4:
                System.out.print("\nQuelle est le model de cet appareil:");
                String model = sc.nextLine()+sc.nextLine();
                System.out.print("\nQuelle est le nombre max des vols qu'elle peut effectuer par jour: ");
                int volMax = sc.nextInt();
                System.out.print("\nQuelle est sa charge util Max: ");
                double chargeMax = sc.nextDouble();
                System.out.print("\nQuelle est son  capacite du carburant: ");
                double capaCarb = sc.nextDouble();
                System.out.print("\nQuelle est son equipage: ");
                double equipe = sc.nextDouble();
                System.out.print("\nQuelle est son consommation supplémentaire: ");
                double consoS = sc.nextDouble();
                System.out.print("\nQuelle est son consommation a vide: ");
                double consoV = sc.nextDouble();
                appareils.add(new Appareil(model, capaCarb, equipe, volMax, consoV, consoS, chargeMax));
                break;
            case 5:
                System.out.print("\n donner le jour de depart: ");
                int jourDep = sc.nextInt();
                System.out.print("\n donner le mois de depart: ");
                int moisDep = sc.nextInt();
                System.out.print("\n donner l'annee de depart: ");
                int anneeDep = sc.nextInt();

                System.out.print("\n donner le jour d'arrivee: ");
                int jourArr = sc.nextInt();
                System.out.print("\n donner le mois d'arrivee: ");
                int moisArr = sc.nextInt();
                System.out.print("\n donner l'annee d'arrivee: ");
                int anneeArr = sc.nextInt();
                dates.add(new DateVol(getDate(anneeDep, moisDep, jourDep),getDate(anneeArr, moisArr, jourArr)));
                break;
            case 6:
                System.out.print("\n donner le jour de depart: ");
                int jour = sc.nextInt();
                System.out.print("\n donner le mois de depart: ");
                int mois = sc.nextInt();
                System.out.print("\n donner l'annee de depart: ");
                int annee = sc.nextInt();
                System.out.print("\nDonner sa valeur:");
                int prix = sc.nextInt();
                tarifs.add(new TarifLocal(getDate(annee, mois, jour), prix));
                break;
            default:
                break;
        }
    }
    public void afficheConsultation()throws InvalidTronconException, InvalidValeurException, DateVolNotFoundException,CapaciteVolMaxDepasseException,ChargeUtilMaxDepasseException,ValeurNotUniqueException{
        System.out.println("---------------\nVoici les commandes pour l'operation Consultation:");
        System.out.print("1-Affichage\n2-Calculer consommation en Vol\n3-Calculer longueur d'une Vol\n4-Calculer (en litres) la quantite du carburant nécessaire pour un vol\n5-Calculer (en litres) la quantite du carburant nécessaire pour un tronçon du vol\n6-Calculer Nombre des escales pour un Vol\nVotre reponse:");
        int n= sc.nextInt(), indice;
        switch (n) {
            case 1:
                this.afficherAffichage();
                break;
            case 2:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(appareils);
                this.afficherConsommVol(appareils.get(indice));
                break;
            case 3:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(vols);
                this.afficherLongueurVol(vols.get(indice));
                break;
            case 4:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(vols);
                this.afficherCarburantNecessaireVol(vols.get(indice));
                break;
            case 5:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(troncons);
                this.afficherCarburantNecessaireVol(troncons.get(indice));
                break;
            case 6:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(vols);
                this.afficherNbrEscalesVol(vols.get(indice));
                break;
            default:
                break;    
        }
        this.afficheWelcome();
    }
    public void afficherNbrEscalesVol(Vol v){
        System.out.printf("Le nombre d'escales à éffectuer pour aller de %s au %s est %d escale(s)",v.getDepart().getNom(),v.getDestination().getNom(),v.getCapaciteTroncon()-1);
    }
    public void afficherCarburantNecessaireVol(TronconDuVol t){
        System.out.printf("La quantité du carburant necessaire pour aller de %s vers %s est %.2f littres",t.getDepart().getNom(),t.getDestination().getNom(),t.getCarburantNecessaire());
    }
    public void afficherCarburantNecessaireVol(Vol vol){
        double carbN = 0;
        for(TronconDuVol t: vol.getTroncons())
            carbN+=t.getCarburantNecessaire();
        System.out.printf("La quantité du carburant necessaire pour aller de %s vers %s est %.2f littres",vol.getDepart().getNom(),vol.getDestination().getNom(),carbN);
    }
    public void afficherLongueurVol(Vol vol){
        double longueur=0;
        for(TronconDuVol t: vol.getTroncons())
            longueur+=t.getLongueur();
        System.out.printf("La longueur d'une vol est %.2f",longueur);
    }
    public void afficherConsommVol(Appareil app){
        System.out.printf("%s: consommation à vide: %.2f\nconsommation supplementaire: %.2f\nconsommation en vol: %.2f",app.getCode(),app.getConsommationVide(),app.getConsommationSupp(),app.getConsommationEnVol());
    }
    public void afficherAffichage(){
        System.out.println("---------------\nQue'est qu'on va afficher?");
        System.out.print("1-Tout aeroports\n2-Un aeroport\n3-Tout vols\n4-Un vol\n5-Tout appareils\n6-Un appareil\n7-Tout Tronçons\n8-Un tronçon\n9-Tout dates du vol\nVotre reponse:");
        int indice;
        switch (sc.nextInt()) {
            case 1:
                afficherToutElements(airports);
                break;
            case 2:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(airports);
                afficherElement(airports.get(indice));
                break;
            case 3:
                afficherToutElements(vols);
                break;
            case 4: 
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(vols);
                afficherElement(vols.get(indice));
            break;
            case 5:
                afficherToutElements(appareils);
                break;
            case 6:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(appareils);
                afficherElement(appareils.get(indice)); 
            case 7:
                afficherToutElements(troncons);
                break;
            case 8:
                System.out.println("Choisir un d'entre eux:\n");
                indice = listerElements(troncons);
                afficherElement(troncons.get(indice));
            case 9:
                afficherToutElements(dates);
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

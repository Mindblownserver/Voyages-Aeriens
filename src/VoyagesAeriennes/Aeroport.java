package VoyagesAeriennes;

public class Aeroport {
    private String nom;
    private String code;
    private Vol voles[];
    private TarifLocal tarif;
    public Aeroport(String nom, String code) {
        this.nom = nom;
        this.code = code;
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

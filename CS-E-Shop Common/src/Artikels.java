public class Artikels {
    private String aname= null;
    private int anummer = 0;
    private String akategorie = null;

    public Artikels(String aname, int anummer, String akategorie) {
        this.aname = aname;
        this.anummer =0;
        this.akategorie = akategorie;




    }

    public String getaName() {
        return aname;
    }

    public void setaName(String aname) {
        this.aname = aname;
    }

    public int getaNummer() {
        return anummer;
    }

    public void setaNummer(int anummer) {
        this.anummer = anummer;
    }

    public String getaKategorie() {
        return akategorie;
    }

    public void setaKategorie(String kategorie) {
        this.akategorie = akategorie;
    }

}
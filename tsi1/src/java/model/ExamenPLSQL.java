package model;

public class ExamenPLSQL {
    private String dejofi;
    private int increm;
    private int canjob;
    private float indice;
    private float disama;

    public ExamenPLSQL() {
    }

    public ExamenPLSQL(String dejofi) {
        this.dejofi = dejofi;
    }

    public ExamenPLSQL(String dejofi, int increm, int canjob, float indice, float disama) {
        this.dejofi = dejofi;
        this.increm = increm;
        this.canjob = canjob;
        this.indice = indice;
        this.disama = disama;
    }

    public String getDejofi() {
        return dejofi;
    }

    public void setDejofi(String dejofi) {
        this.dejofi = dejofi;
    }

    public int getIncrem() {
        return increm;
    }

    public void setIncrem(int increm) {
        this.increm = increm;
    }

    public int getCanjob() {
        return canjob;
    }

    public void setCanjob(int canjob) {
        this.canjob = canjob;
    }

    public float getIndice() {
        return indice;
    }

    public void setIndice(float indice) {
        this.indice = indice;
    }

    public float getDisama() {
        return disama;
    }

    public void setDisama(float disama) {
        this.disama = disama;
    }
    
}

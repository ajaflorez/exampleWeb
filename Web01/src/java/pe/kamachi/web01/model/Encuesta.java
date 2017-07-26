/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.kamachi.web01.model;


public class Encuesta {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String fullName;
    private String[] langProg;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String[] getLangProg() {
        return langProg;
    }
    public void setLangProg(String[] langProg) {
        this.langProg = langProg;
    }
}

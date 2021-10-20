/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.M226a.dierberger.dominik;


public class AlkoholischesGetraenk {

    public final double BIER_ALKOHOLGEHALT = 0.05;
    public final double WEIN_ALKOHOLGEHALT = 0.10;
    public final double SCHNAPS_ALKOHOLGEHALT = 0.40;
    private final double DICHTE_ALKOHOL = 0.8;

    private final int volumenMilliLiter;
    private final double alkoholgehalt;
    private final java.util.Date getrunkenAm;


    public AlkoholischesGetraenk(int volumenMilliLiter, double alkoholGehalt, java.util.Date getrunkenAm){
        this.volumenMilliLiter = volumenMilliLiter;
        this.alkoholgehalt = alkoholGehalt;
        this.getrunkenAm = getrunkenAm;
    }

    public double getStundenSeitEinnahme(java.util.Date jetzt){
        long timeDifference = jetzt.getTime() - getrunkenAm.getTime();
        return (double) (((timeDifference / 1000) / 60) / 60);
    }
    public double getAlkoholMasseInGramm(){
        return volumenMilliLiter * alkoholgehalt * DICHTE_ALKOHOL;
    }
}

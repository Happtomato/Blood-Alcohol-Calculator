/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.M226a.dierberger.dominik;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class Person {

    public final int MAENNLICH = 0;
    public final int WEIBLICH = 1;
    private final double ABBAU_WARTEZEIT_STUNDEN = 1.0;
    private final double ABBAU_PRO_STUNDE = 0.1;
    private final double ANTEIL_WASSER_IM_BLUT = 0.8;
    private final double DICHTE_BLUT_GRAMM_PRO_CCM = 1.055;
    private double koerpermasse;
    private double koerpergroesseInCm;
    private java.util.Date geburtsdatum;
    private int geschlecht;
    private double alkoholPromille = 0.0;

    public Person(double koerpermasse, double koerpergroesseInCm, java.util.Date geburtsdatum, int geschlecht) {
        this.koerpermasse = koerpermasse;
        this.koerpergroesseInCm = koerpergroesseInCm;
        this.geburtsdatum = geburtsdatum;
        this.geschlecht = geschlecht;
    }

    private double getAlterInJahren() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        final int jahrGeburtsdatum = Integer.parseInt(simpleDateFormat.format(geburtsdatum));

        final LocalDate jetzt = LocalDate.now();
        final LocalDate localGeburtsdatum = geburtsdatum.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        final Period period = Period.between(localGeburtsdatum, jetzt);
        final long days = ChronoUnit.DAYS.between(localGeburtsdatum, jetzt);
        return days / 365.0;

    }

    public void trinke(AlkoholischesGetraenk alkoholischesGetraenk) {
        Date jetzt = new Date();

        double GKW = getGKW();
        double promille = (0.8 * alkoholischesGetraenk.getAlkoholMasseInGramm()) / (DICHTE_BLUT_GRAMM_PRO_CCM * GKW);
        double stundenZumAbbau = alkoholischesGetraenk.getStundenSeitEinnahme(jetzt) - ABBAU_WARTEZEIT_STUNDEN;
        alkoholPromille = promille;
        for(double i = 0; i < stundenZumAbbau; i++){
            alkoholPromille -= ABBAU_PRO_STUNDE;
        }
    }

    public double getAlkoholPromille() {
        return alkoholPromille;
    }



    public double getGKW() {
        double alter = getAlterInJahren();
        double GKW = 0.0;
        if(geschlecht == 0){
            GKW = 2.447 - 0.09516 * alter + 0.1074 * koerpergroesseInCm + 0.3362 * koerpermasse;
        }
        else if(geschlecht == 1){
            GKW = 0.203 - 0.07 * alter + 0.1069 * koerpergroesseInCm + 0.2466 * koerpermasse;
        }
        return GKW;
    }
}

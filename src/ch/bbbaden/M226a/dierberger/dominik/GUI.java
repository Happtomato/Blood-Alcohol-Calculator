/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.M226a.dierberger.dominik;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class GUI {

    public static void main(String[] args) {
        Spruch spruch;
        GUI gui = new GUI();
        gui.promilleRechner();
    }

    private Person askPersonData() {
        int koerpermasse = 0;
        int koerpergroesse = 0;
        java.util.Date geburtsdatum = null;
        int geschlecht = 0;
        boolean error;
        final DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        final Date jetzt = new Date();

        do {
            error = false;
            try {
                koerpermasse = Integer.valueOf(JOptionPane.showInputDialog(null, "Geben Sie ihr Gewicht in Kilo ein", "Eingabe Gewicht", JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                System.out.println("Sie müssen eine Zahl eingeben");
                error = true;
            }
        } while (error);

        do {
            error = false;
            try {
                koerpergroesse = Integer.valueOf(JOptionPane.showInputDialog(null, "Geben Sie ihr Grösse in Centimeter ein", "Eingabe Groesse", JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                System.out.println("Sie müssen eine Zahl eingeben");
                error = true;
            }
        } while (error);

        do {
            final String eingabe = JOptionPane.showInputDialog(null, "Geben Sie ihr Geburtsdatum ein.",
                    "Eingabe Geburtsdatum",
                    JOptionPane.QUESTION_MESSAGE);
            if (eingabe == null) { // Cancel
                System.exit(0);
            }
            try {
                geburtsdatum = formatter.parse(eingabe);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, eingabe + " ist keine gültige Trinkzeit.");
            }
        } while (geburtsdatum == null || !jetzt.after(geburtsdatum));

        Object[] options = {"Männlich", "Weiblich"};

        JPanel panel = new JPanel();
        panel.add(new JLabel("Wählen Sie ihr Geschlecht"));

        int answer = JOptionPane.showOptionDialog(null, panel, "Geschlecht auswahl", JOptionPane.CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, null);
        switch (answer) {
            case JOptionPane.CANCEL_OPTION:
                System.exit(0);
                break;
            case 0:
                geschlecht = 0;
                break;
            case 1:
                geschlecht = 1;
                break;
        }

        Person person = new Person(koerpermasse, koerpergroesse, geburtsdatum, geschlecht);
        return person;
    }
    private AlkoholischesGetraenk askAlkoholischeGetraenkData(Date trinkDatum) {
        int volumenInMilliliter;
        double alkoholGehalt = 0.0;
        Date getrunkenAm = null;
        final DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy kk:mm");
        final Date jetzt = new Date();

        Object[] options = {"Bier", "Wein", "Schnaps"};

        JPanel panel = new JPanel();
        panel.add(new JLabel("Was haben Sie getrunken?"));

        int answer = JOptionPane.showOptionDialog(null, panel, "Getränke auswahl", JOptionPane.CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, null);
        switch (answer) {
            case 0:
                alkoholGehalt = 0.05;
                break;
            case 1:
                alkoholGehalt = 0.10;
                break;
            case 2:
                alkoholGehalt = 0.40;
                break;
        }

        volumenInMilliliter = Integer.parseInt(JOptionPane.showInputDialog(null, "Wie viele Milliliter haben Sie getrunken?", "Eingabe Milliliter", JOptionPane.PLAIN_MESSAGE));

        AlkoholischesGetraenk getraenk = new AlkoholischesGetraenk(volumenInMilliliter, alkoholGehalt, trinkDatum);
        return getraenk;
    }
    private java.util.Date askTrinkDatum() {
        Date trinkDatum = null;
        final DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy kk:mm");
        final Date jetzt = new Date();

        do {
            final String eingabe = JOptionPane.showInputDialog(null, "Geben Sie Trinkdatum und -zeit ein.",
                    "Trinkzeit",
                    JOptionPane.QUESTION_MESSAGE);
            if (eingabe == null) { // Cancel
                System.exit(0);
            }
            try {
                trinkDatum = formatter.parse(eingabe);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, eingabe + " ist keine gültige Trinkzeit.");
            }
        } while (trinkDatum == null || !jetzt.after(trinkDatum));

        return trinkDatum;
    }
    public void promilleRechner() {
        Person person = askPersonData();
        java.util.Date trinkDatum = askTrinkDatum();
        AlkoholischesGetraenk getraenk = askAlkoholischeGetraenkData(trinkDatum);

        person.trinke(getraenk);

        Spruch spruch = new Spruch(person.getAlkoholPromille());
        JOptionPane.showMessageDialog(null, "Promillegehalt: " + person.getAlkoholPromille() + "" + spruch.getSpruch());
    }
}
i
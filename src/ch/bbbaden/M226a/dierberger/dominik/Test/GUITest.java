package ch.bbbaden.M226a.dierberger.dominik.Test;

import ch.bbbaden.M226a.dierberger.dominik.AlkoholischesGetraenk;
import ch.bbbaden.M226a.dierberger.dominik.Person;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GUITest {

    @Test
    public void testFall1(){
        //Arange
        int geschlecht = 1;
        int milliliter = 1200;
        int kilo = 88;
        int centimeter = 176;
        java.util.Date alter = new Date(67, Calendar.SEPTEMBER,21);
        java.util.Date getrunkenAm = new Date(2021,Calendar.SEPTEMBER,21,17,9);
        Person person = new Person(kilo,centimeter,alter,geschlecht);
        AlkoholischesGetraenk getraenk = new AlkoholischesGetraenk(milliliter,0.05, getrunkenAm);

        //Act
        person.trinke(getraenk);
        double alkAct = person.getAlkoholPromille();
        //Assert
        assertEquals(0.9688540911037222, alkAct, 0.2);

    }
    @Test
    public void testFall2(){
        //Arange
        int geschlecht = 0;
        int milliliter = 1200;
        int kilo = 88;
        int centimeter = 176;
        java.util.Date alter = new Date(67, Calendar.SEPTEMBER,21);
        java.util.Date getrunkenAm = new Date(2021,Calendar.SEPTEMBER,21,17,9);
        Person person = new Person(kilo,centimeter,alter,geschlecht);
        AlkoholischesGetraenk getraenk = new AlkoholischesGetraenk(milliliter,0.05, getrunkenAm);

        //Act
        person.trinke(getraenk);
        double alkAct = person.getAlkoholPromille();
        //Assert
        assertEquals(0.7801912053596537, alkAct,0.2);

    }
    @Test
    public void testFall3(){
        //Arange
        int geschlecht = 1;
        int milliliter = 1200;
        int kilo = 88;
        int centimeter = 176;
        java.util.Date alter = new Date(67, Calendar.SEPTEMBER,21);
        java.util.Date getrunkenAm = new Date(2021,Calendar.SEPTEMBER,21,14,40);
        Person person = new Person(kilo,centimeter,alter,geschlecht);
        AlkoholischesGetraenk getraenk = new AlkoholischesGetraenk(milliliter,0.05, getrunkenAm);

        //Act
        person.trinke(getraenk);
        double alkAct = person.getAlkoholPromille();
        //Assert
        assertEquals(0.8188540911037222, alkAct, 0.2);

    }
    @Test
    public void testFall4(){
        //Arange
        int geschlecht = 0;
        int milliliter = 1200;
        int kilo = 88;
        int centimeter = 176;
        java.util.Date alter = new Date(67, Calendar.SEPTEMBER,21);
        java.util.Date getrunkenAm = new Date(2021,Calendar.SEPTEMBER,21,14,40);
        Person person = new Person(kilo,centimeter,alter,geschlecht);
        AlkoholischesGetraenk getraenk = new AlkoholischesGetraenk(milliliter,0.05, getrunkenAm);

        //Act
        person.trinke(getraenk);
        double alkAct = person.getAlkoholPromille();
        //Assert
        assertEquals(0.6301912053596537, alkAct, 0.2);

    }


}
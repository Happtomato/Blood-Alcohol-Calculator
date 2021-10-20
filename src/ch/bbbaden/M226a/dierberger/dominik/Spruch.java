package ch.bbbaden.M226a.dierberger.dominik;

public class Spruch {


    double promille;
    public Spruch(double alkoholPromille){
        this.promille = alkoholPromille;
    }

    public String getSpruch() {
        if (promille < 1){
            return "Ist ja noch nix";
        }
        else if (promille > 1){
            return "Merkst du schon was?";
        }
        else if (promille > 2){
            return "Das Zimmert schon ordentlich";
        }
        else if (promille > 3){
            return "Gehts dir gut?";
        }
        else if (promille > 4){
            return "Da hilft auch kein Konterbier mehr";
        }
        return "Hm da ist wohl was falsch.";
    }
}

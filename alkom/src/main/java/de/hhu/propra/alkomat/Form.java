package de.hhu.propra.alkomat;

import javax.validation.constraints.Min;

public record Form (String geschlecht, @Min(value=20, message="Das Gewicht muss mind. 20Kg betragen!" ) int gewicht, int bier, int wein){

    private double reduktionsFaktor(){
        return male() ? 0.7 : 0.6;
    }

    private boolean male() {
        return geschlecht.equals("m");
    }

    public String berechneAlkohol(){
        double alk = berechneMasse()/(reduktionsFaktor()*gewicht);
        return String.format("%.2f", alk);
    }

    private double berechneMasse() {
        return bier*0.05*0.8+
                wein*0.12*0.8;
    }

}

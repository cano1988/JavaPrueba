package com.riwiJava.entity;

public class Entity2 {




    @Override
    public String toString() {
        return  "| name: " + this.name + " |\n" +
                "| lastName: " + this.lastName + " |\n" +
                "| document: " + this.document + " |\n" +
                "| clan: " + this.clan + " cohorte: " + this.cohorte + " |\n" +
                "|-------------------------------|\n" +
                "| cv: '" + this.cv + " |\n \n";
    }
}

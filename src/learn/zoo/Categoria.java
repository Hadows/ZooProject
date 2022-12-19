package learn.zoo;

import java.util.ArrayList;

public enum Categoria {
    CODATO(Codato()),
    ALATO(Alato());

    ArrayList<String> famiglie;

    Categoria(ArrayList<String> famiglie){
        this.famiglie = famiglie;
    }

    private static ArrayList<String> Codato()
    {
        ArrayList<String> array = new ArrayList<>();
        array.add("Felino");
        return array;
    }

    private static ArrayList<String> Alato()
    {
        ArrayList<String> array = new ArrayList<>();
        array.add("Aviano");
        return array;
    }
}

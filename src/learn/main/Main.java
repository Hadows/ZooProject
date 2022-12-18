package learn.main;

import learn.animali.famiglia.specie.Aquila;
import learn.animali.famiglia.specie.Leone;
import learn.animali.famiglia.specie.Tigre;
import learn.zoo.ZOO;

public class Main {
    public static void main (String[] args) {

        ZOO zoo = ZOO.getInstance();
        PopulateZoo();

        System.out.println(zoo.ricercaAltoBasso("Leone"));
        System.out.println(zoo.ricercaGrassoMagro("Aquila"));
        System.out.println(zoo.ricercaCodaLunga());
        System.out.println(zoo.ricercaAperturaAlare());
    }

    public static void PopulateZoo(){
        ZOO zoo = ZOO.getInstance();

        zoo.addAnimale(Leone.builder()
                .nome("Micino")
                .ciboPreferito("Mici")
                .età(8)
                .dataIngresso("11/11/2022")
                .peso(18)
                .altezza(1.22f)
                .lunghezzaCoda(1.25f)
                .build());
        zoo.addAnimale(Leone.builder()
                .nome("Gattone")
                .ciboPreferito("Mici")
                .età(8)
                .dataIngresso("11/11/2022")
                .peso(18)
                .altezza(1.5f)
                .lunghezzaCoda(2.0f)
                .build());
        zoo.addAnimale(Tigre.builder()
                .nome("Micione")
                .ciboPreferito("Mici")
                .età(8)
                .dataIngresso("11/11/2022")
                .peso(18)
                .altezza(1.22f)
                .lunghezzaCoda(1.25f)
                .build());
        zoo.addAnimale(Aquila.builder()
                .nome("USAeGetta")
                .ciboPreferito("Americani(nativi)")
                .età(8)
                .dataIngresso("11/11/2022")
                .peso(18)
                .altezza(0.1f)
                .aperturaAlare(1.22f)
                .build());
    }
}

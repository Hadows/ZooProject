package learn.zoo;

import learn.animali.Animale;
import learn.animali.famiglia.Aviano;
import learn.animali.famiglia.Felino;

import java.util.*;

public class ZOO {
    // SINGLETON
    private static ZOO instance;
    Map<String, Map<String, ArrayList<Animale>>> zooDatabase;


    private ZOO() {
        zooDatabase = new HashMap<>();
    }

    public static synchronized ZOO getInstance() {
        if (instance == null) {
            instance = new ZOO();
        }
        return instance;
    }

    public <T extends Animale> void addAnimale(T animale){
        String famiglia = animale.getClass().getSuperclass().getSimpleName();
        String specie = animale.getClass().getSimpleName();

        if (zooDatabase.containsKey(famiglia)){
            Map<String, ArrayList<Animale>> family = zooDatabase.get(famiglia);
            if (family.containsKey(specie)){
                family.get(specie).add(animale);
            }
            else {
                family.put(specie, new ArrayList<>());
                family.get(specie).add(animale);
            }
        }
        else{
            zooDatabase.put(famiglia, new HashMap<>());
            zooDatabase.get(famiglia).put(specie, new ArrayList<>());
            zooDatabase.get(famiglia).get(specie).add(animale);
        }
    }

    private <T extends Animale> ArrayList<T> getListSpecie(String nomeSpecie){
        ArrayList<T> lista = new ArrayList<>();
        zooDatabase.keySet().forEach(chiave -> {
            if (zooDatabase.get(chiave).containsKey(nomeSpecie)){
                lista.addAll((Collection<? extends T>) zooDatabase.get(chiave).get(nomeSpecie));
            }
        });
        return lista;
    }

    private <T extends Animale> ArrayList<T> getListFamiglia(String nomeFamiglia){
        Map<String, ArrayList<Animale>> famiglia = zooDatabase.get(nomeFamiglia);
        ArrayList<T> lista = new ArrayList<>();

        famiglia.keySet().forEach(chiave -> {
            lista.addAll((Collection<? extends T>) famiglia.get(chiave));
        });

        return lista;
    }

    //ricerca l'esemplare pi?? alto e pi?? basso per la specie indicata
    public String ricercaAltoBasso(String specie){
        ArrayList<Animale> animali = getListSpecie(specie);

        float max = 0;
        Animale animaleMax = null;
        float min = 100;
        Animale animaleMin = null;
        for (int i = 0; i < animali.size(); i++){
            Animale animale = animali.get(i);
            if (animale.getAltezza() > max){
                max = animale.getAltezza();
                animaleMax = animale;
            }
            if (animale.getAltezza() < min){
                min = animale.getAltezza();
                animaleMin = animale;
            }
        }

        String result = "Animale pi?? alto: " + animaleMax.getNome() + " Animale pi?? basso: " + animaleMin.getNome();
        return result;
    }

    //ricerca l'esemplare pi?? magro e pi?? grasso
    public String ricercaGrassoMagro(String specie){
        ArrayList<Animale> animali = getListSpecie(specie);

        float max = 0;
        Animale animaleMax = null;
        float min = 100;
        Animale animaleMin = null;
        for (int i = 0; i < animali.size(); i++){
            Animale animale = animali.get(i);
            if (animale.getPeso() > max){
                max = animale.getPeso();
                animaleMax = animale;
            }
            if (animale.getPeso() < min){
                min = animale.getPeso();
                animaleMin = animale;
            }
        }

        String result = "Animale pi?? grasso: " + animaleMax.getNome() + " Animale pi?? magro: " + animaleMin.getNome();
        return result;
    }

    //ricerca l'animale dello zoo con la coda pi?? lunga
    public String ricercaCodaLunga(){
        ArrayList<Felino> felini = getListFamiglia("Felino");

        float max = 0;
        Felino animaleMax = null;
        for (int i = 0; i < felini.size(); i++){
            Felino animale = felini.get(i);
            if (animale.getLunghezzaCoda() > max){
                max = animale.getLunghezzaCoda();
                animaleMax = animale;
            }
        }

        String result = "Animale con la coda pi?? lunga: " + animaleMax.getNome();
        return result;
    }

    //ricerca l'animale con l'apertura alare maggiore
    public String ricercaAperturaAlare(){
        ArrayList<Aviano> aviani = getListFamiglia("Aviano");

        float max = 0;
        Aviano animaleMax = null;
        for (int i = 0; i < aviani.size(); i++){
            Aviano animale = aviani.get(i);
            if (animale.getAperturaAlare() > max){
                max = animale.getAperturaAlare();
                animaleMax = animale;
            }
        }

        String result = "Animale con l'apertura alare maggiore: " + animaleMax.getNome();
        return result;
    }

}

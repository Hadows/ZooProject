package learn.zoo;

import learn.animali.Animale;
import learn.animali.famiglia.Aviano;
import learn.animali.famiglia.Felino;

import java.util.*;

//dizionari con le famiglie e le specie
//metodo che le popola
public class ZOO {
    // SINGLETON
    private static ZOO instance;

    //Database mockato
    Map<String, Map<String, ArrayList<Animale>>> zooDatabase;


    private ZOO() {
        zooDatabase = new HashMap<>();
        zooDatabase.put("Aviano", new HashMap<>());
        zooDatabase.put("Felino", new HashMap<>());

        Map<String, ArrayList<Animale>> aviano = zooDatabase.get("Aviano");
        aviano.put("Aquila", new ArrayList<>());

        Map<String, ArrayList<Animale>> felino = zooDatabase.get("Felino");
        felino.put("Leone", new ArrayList<>());
        felino.put("Tigre", new ArrayList<>());
    }

    public static synchronized ZOO getInstance() {
        if (instance == null) {
            instance = new ZOO();
        }
        return instance;
    }

    public void addAnimale(Animale animale){
        Set<String> famiglie = zooDatabase.keySet();

        famiglie.forEach(famiglia -> {

            if (famiglia == animale.getClass().getSimpleName()){
                Set<String> specie = zooDatabase.get(famiglia).keySet();

                specie.forEach(spece ->{
                    if (spece == animale.getClass().getSimpleName()){
                        zooDatabase.get(famiglia).get(spece).add(animale);
                    }
                });
            }
        });
    }

    private ArrayList<Animale> getListSpecie(String nomeSpecie){
        ArrayList<Animale> lista = new ArrayList<>();
        zooDatabase.keySet().forEach(chiave -> zooDatabase.get(chiave).keySet().forEach(key -> {
            if (key == nomeSpecie){
                lista.addAll(zooDatabase.get(chiave).get(key));
            }
        }));
        return lista;
    }

    private ArrayList<Animale> getListFamiglia(String nomeFamiglia){
        Map<String, ArrayList<Animale>> famiglia = zooDatabase.get(nomeFamiglia);
        ArrayList<Animale> lista = new ArrayList<>();

        famiglia.keySet().forEach(chiave -> {
            lista.addAll(famiglia.get(chiave));
        });

        return lista;
    }

    //ricerca l'esemplare più alto e più basso per la specie indicata
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

        String result = "Animale più alto: " + animaleMax.getNome() + " Animale più basso" + animaleMin.getNome();
        return result;
    }

    //ricerca l'esemplare più magro e più grasso
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

        String result = "Animale più grasso: " + animaleMax.getNome() + " Animale più magro" + animaleMin.getNome();
        return result;
    }

    //ricerca l'animale dello zoo con la coda più lunga
    public String ricercaCodaLunga(){
        ArrayList<Animale> animali = getListFamiglia("Felino");
        ArrayList<Felino> felini = new ArrayList<>();
        for (int i = 0; i < animali.size(); i++){
            felini.add((Felino)animali.get(i));
        }

        float max = 0;
        Felino animaleMax = null;
        for (int i = 0; i < felini.size(); i++){
            Felino animale = felini.get(i);
            if (animale.getLunghezzaCoda() > max){
                max = animale.getLunghezzaCoda();
                animaleMax = animale;
            }
        }

        String result = "Animale con la coda più lunga: " + animaleMax.getNome();
        return result;
    }

    //ricerca l'animale con l'apertura alare maggiore
    public String ricercaAperturaAlare(){
        ArrayList<Animale> animali = getListFamiglia("Aviano");
        ArrayList<Aviano> aviani = new ArrayList<>();
        for (int i = 0; i < animali.size(); i++){
            aviani.add((Aviano)animali.get(i));
        }

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

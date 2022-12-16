package learn.animali;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Animale {
    @Getter
    @Setter
    @NonNull
    private String nome;
    @Getter
    @Setter
    @NonNull
    private String ciboPreferito;
    @Getter
    @Setter
    @NonNull
    private int età;
    @Getter
    @NonNull
    private final String dataIngresso;
    @Getter
    @Setter
    @NonNull
    private float peso;
    @Getter
    @Setter
    @NonNull
    private float altezza;

    @Override
    public String toString() {
        return "Animale{" +
                "nome='" + nome + '\'' +
                ", ciboPreferito='" + ciboPreferito + '\'' +
                ", età=" + età +
                ", dataIngresso='" + dataIngresso + '\'' +
                ", peso=" + peso +
                ", altezza=" + altezza +
                '}';
    }
}

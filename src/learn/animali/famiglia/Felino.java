package learn.animali.famiglia;

import learn.animali.Animale;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Felino extends Animale {
    @Getter
    @Setter
    @NonNull
    private float lunghezzaCoda;
}

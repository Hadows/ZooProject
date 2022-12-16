package learn.animali.famiglia;

import learn.animali.Animale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Aviano extends Animale {
    @Getter
    @Setter
    @NonNull
    private float aperturaAlare;

}

package pl.creazy.creazylib.game.constraints;

import pl.creazy.creazylib.part.constraints.Part;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Part
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GameState {
  long period() default 1L;
}

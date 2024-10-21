package pl.creazy.creazylib.data.persistence.config.constraints;

import pl.creazy.creazylib.data.persistence.config.Config;
import pl.creazy.creazylib.part.constraints.Part;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Part
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigFile {
  String name();
  String path() default Config.DEFAULT_PATH;
}

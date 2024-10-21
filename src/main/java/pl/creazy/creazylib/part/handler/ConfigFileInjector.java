package pl.creazy.creazylib.part.handler;

import lombok.SneakyThrows;
import pl.creazy.creazylib.data.persistence.config.Config;
import pl.creazy.creazylib.data.persistence.config.constraints.ConfigFile;
import pl.creazy.creazylib.log.Logger;
import pl.creazy.creazylib.part.PartCreateHandler;
import pl.creazy.creazylib.part.PartManager;
import pl.creazy.creazylib.part.PartOptions;
import pl.creazy.creazylib.part.constraints.Handler;
import pl.creazy.creazylib.part.constraints.Injected;
import pl.creazy.creazylib.plugin.CreazyPlugin;
import pl.creazy.creazylib.util.text.Text;

import java.lang.reflect.Field;

@Handler
class ConfigFileInjector implements PartCreateHandler {
  @Injected
  private Logger logger;

  @SneakyThrows
  @Override
  public void onPartCreate(Object part, PartManager partManager, CreazyPlugin plugin, PartOptions options) {
    for (Field field : part.getClass().getDeclaredFields()) {
      var configData = field.getAnnotation(ConfigFile.class);
      if (configData != null) {
        field.setAccessible(true);
        field.set(part, Config.getConfig(configData.name(), configData.path(), plugin));
        logger.success("Injected config file to ".concat(Text.getPrettyClassName(part.getClass())));
      }
    }
  }
}

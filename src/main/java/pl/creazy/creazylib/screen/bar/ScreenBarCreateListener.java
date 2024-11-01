package pl.creazy.creazylib.screen.bar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.creazy.creazylib.listener.constraints.EventHandlers;
import pl.creazy.creazylib.part.constraints.Injected;

@EventHandlers
class ScreenBarCreateListener implements Listener {
  @Injected
  private ScreenBarManager screenBarManager;

  @EventHandler
  void onScreenBarCreate(ScreenBarCreateEvent event) {
    screenBarManager.addBar(event.getBar());
  }
}

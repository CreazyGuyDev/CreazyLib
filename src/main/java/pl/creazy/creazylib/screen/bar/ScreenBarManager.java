package pl.creazy.creazylib.screen.bar;

import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.manager.constraints.Manager;
import pl.creazy.creazylib.part.constraints.OnDisable;

import java.util.ArrayList;
import java.util.List;

@Manager
class ScreenBarManager {
  private final List<ScreenBar> bars = new ArrayList<>();

  void addBar(@NotNull ScreenBar bar) {
    bars.add(bar);
  }

  @OnDisable
  private void removeBars() {
    bars.forEach(bar -> {
      bar.getBar().removeAll();
      bar.getBar().setVisible(false);
    });
  }
}

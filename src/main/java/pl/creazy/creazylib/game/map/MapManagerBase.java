package pl.creazy.creazylib.game.map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.creazy.creazylib.data.persistence.config.Config;

import java.util.ArrayList;
import java.util.List;

public abstract class MapManagerBase<T extends MapBase> {
  private final List<T> maps = new ArrayList<>();

  public final @Nullable T getMap(@NotNull String name) {
    return maps.stream()
        .filter(other -> other.getName().equals(name))
        .findAny()
        .orElse(null);
  }

  public final void addMap(@NotNull T map) {
    if (maps.stream().noneMatch(other -> other.getWorldName().equals(map.getWorldName()))) {
      maps.add(map);
      map.getWorld();
    }
  }

  public final void removeMap(@NotNull String worldName) {
    for (var map : maps) {
      if (map.getWorldName().equals(worldName)) {
        removeMap(map);
        return;
      }
    }
  }

  public final void removeMap(@NotNull T map) {
    maps.remove(map);
  }

  public void save(@NotNull Config config) {
    config.set("maps", maps);
    config.save();
  }

  @SuppressWarnings("unchecked")
  public void restore(@NotNull Config config) {
    var maps = config.getList("maps");
    if (maps != null) {
      this.maps.addAll((List<T>) maps);
    }
  }
}

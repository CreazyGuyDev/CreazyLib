package pl.creazy.creazylib.game.map;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public abstract class MapBase implements ConfigurationSerializable {
  private String name;

  public MapBase(String name) {
    this.name = name;
  }

  public MapBase(Map<String, Object> data) {
    name = (String) data.get("name");
  }

  public final @NotNull World getWorld() {
    var world = Bukkit.getWorld(getWorldName());
    if (world == null) {
      world = Objects.requireNonNull(new WorldCreator(getWorldName()).createWorld(), "Failed to create world");
      world.save();
    }
    world.setAutoSave(isPersistent());
    return world;
  }

  public @NotNull String getWorldName() {
    return "world_map_".concat(name);
  }

  public final void reset() throws IllegalStateException {
    var world = getWorld();
    if (!world.getPlayers().isEmpty()) {
      throw new IllegalStateException("World must have no players");
    }
    Bukkit.unloadWorld(world, isPersistent());
    getWorld();
  }

  public abstract boolean isPersistent();

  @Override
  public @NotNull Map<String, Object> serialize() {
    return Map.of(
        "name", name
    );
  }
}

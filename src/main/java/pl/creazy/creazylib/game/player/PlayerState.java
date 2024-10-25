package pl.creazy.creazylib.game.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface PlayerState {
  void onStart(@NotNull Player player);
  void onEnd(@NotNull Player player);
}

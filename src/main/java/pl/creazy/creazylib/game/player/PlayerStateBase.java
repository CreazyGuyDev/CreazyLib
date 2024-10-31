package pl.creazy.creazylib.game.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface PlayerStateBase {
  void onStart(@NotNull Player player);
  void onEnd(@NotNull Player player);
}

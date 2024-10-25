package pl.creazy.creazylib.game.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class PlayerStateManagerBase {
  private final Map<UUID, PlayerState> states = new HashMap<>();

  public void setPlayerState(@NotNull Player player, @NotNull PlayerState state) {
    getPlayerState(player).onEnd(player);
    states.put(player.getUniqueId(), state);
    state.onStart(player);
  }

  public @NotNull PlayerState getPlayerState(@NotNull Player player) {
    return states.getOrDefault(player.getUniqueId(), getDefaultPlayerState());
  }

  public @NotNull PlayerState getDefaultPlayerState() {
    return new DefaultPlayerState();
  }
}

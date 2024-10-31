package pl.creazy.creazylib.game.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.CreazyLib;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public abstract class PlayerStateManagerBase {
  private final Map<UUID, PlayerStateBase> states = new HashMap<>();

  public void setPlayerState(@NotNull Player player, @NotNull Class<? extends PlayerStateBase> type) {
    var state = (PlayerStateBase) CreazyLib.request().getPartManager().getPart(type);
    getPlayerState(player).onEnd(player);
    states.put(player.getUniqueId(), state);
    Objects.requireNonNull(state, "You have to register player state using @PlayerState").onStart(player);
  }

  public @NotNull PlayerStateBase getPlayerState(@NotNull Player player) {
    return states.getOrDefault(player.getUniqueId(), getDefaultPlayerState());
  }

  public @NotNull PlayerStateBase getDefaultPlayerState() {
    return new DefaultPlayerState();
  }
}

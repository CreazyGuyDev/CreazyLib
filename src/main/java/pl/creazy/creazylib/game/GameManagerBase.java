package pl.creazy.creazylib.game;

import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.CreazyLib;
import pl.creazy.creazylib.plugin.CreazyPlugin;

import java.util.Objects;

public abstract class GameManagerBase {
  private GameStateBase currentGameState;


  public final void setGameState(@NotNull Class<? extends GameStateBase> type) {
    if (currentGameState != null) {
      currentGameState.end();
    }
    currentGameState = (GameStateBase) CreazyLib.request().getPartManager().getPart(type);
    Objects.requireNonNull(currentGameState).start(this);
  }

  public final void stopGame() {
    currentGameState.end();
    currentGameState = null;
  }

  public abstract @NotNull CreazyPlugin getPlugin();
}

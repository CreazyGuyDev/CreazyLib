package pl.creazy.creazylib.game;

import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.game.constraints.GameState;

public abstract class GameStateBase {
  private long ticks = 0L;
  private BukkitRunnable task;

  public void onStart() {
  }

  public void onEnd() {
  }

  public abstract void handle();

  public long getPeriod() {
    return getClass().getAnnotation(GameState.class).period();
  }

  public final void start(@NotNull GameManagerBase gameManager) {
    onStart();
    task = new BukkitRunnable() {
      @Override
      public void run() {
        handle();
        ticks += getPeriod();
      }
    };
    task.runTaskTimer(gameManager.getPlugin(), 0L, getPeriod());
  }

  public final void end() {
    task.cancel();
    onEnd();
    ticks = 0;
  }

  public final long getTicks() {
    return ticks;
  }

  public final long getSeconds() {
    return getTicks() / 20L;
  }

  public final long getMinutes() {
    return getSeconds() / 60L;
  }

  public final long getHours() {
    return getMinutes() / 60L;
  }
}

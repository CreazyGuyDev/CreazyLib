package pl.creazy.creazylib.game;

import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public abstract class GameStateBase extends BukkitRunnable {
  private long ticks = 0L;

  public void onStart() {
  }

  public void onEnd() {
  }

  public abstract void handle();

  public long getPeriod() {
    return 1L;
  }

  public final void start(@NotNull GameManagerBase gameManager) {
    onStart();
    runTaskTimer(gameManager.getPlugin(), 0L, getPeriod());
  }

  public final void end() {
    cancel();
    onEnd();
  }

  @Override
  public final void run() {
    handle();
    ticks += getPeriod();
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

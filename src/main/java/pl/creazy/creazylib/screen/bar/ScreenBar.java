package pl.creazy.creazylib.screen.bar;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.util.text.Text;

@Getter(AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ScreenBar {
  private final BossBar bar;

  public static @NotNull ScreenBar create(
      @NotNull String title,
      @NotNull BarColor color,
      @NotNull BarStyle style,
      @NotNull BarFlag... flags
  ) {
    var bar = new ScreenBar(Bukkit.createBossBar(Text.color(title), color, style, flags));
    bar.bar.setVisible(true);
    Bukkit.getPluginManager().callEvent(new ScreenBarCreateEvent(bar));
    return bar;
  }

  public void hide() {
    bar.setVisible(false);
  }

  public void show() {
    bar.setVisible(true);
  }

  public void setProgress(double progress) {
    bar.setProgress(progress);
  }

  public @NotNull ScreenBar addPlayers(Player... players) {
    if (players.length == 0) {
      Bukkit.getOnlinePlayers().forEach(bar::addPlayer);
    } else {
      for (var player : players) {
        bar.addPlayer(player);
      }
    }
    return this;
  }

  public void setTitle(@NotNull String title) {
    bar.setTitle(Text.color(title));
  }

  public void setColor(@NotNull BarColor color) {
    bar.setColor(color);
  }

  public void setStyle(@NotNull BarStyle style) {
    bar.setStyle(style);
  }

  public void addFlags(@NotNull BarFlag... flags) {
    for (var flag : flags) {
      bar.addFlag(flag);
    }
  }

  public void removeFlags(@NotNull BarFlag... flags) {
    for (var flag : flags) {
      bar.removeFlag(flag);
    }
  }

  public void removePlayers(@NotNull Player... players) {
    if (players.length == 0) {
      Bukkit.getOnlinePlayers().forEach(bar::removePlayer);
    } else {
      for (var player : players) {
        bar.removePlayer(player);
      }
    }
  }
}

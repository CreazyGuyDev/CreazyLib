package pl.creazy.creazylib.screen.menu;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class ContextPlayerMenuHolder<T> extends MenuHolder {
  private final T context;

  public ContextPlayerMenuHolder(ContextPlayerMenu<T> menu, MenuPage page, Player owner, T context) {
    super(menu, page, owner);
    this.context = context;
  }
}

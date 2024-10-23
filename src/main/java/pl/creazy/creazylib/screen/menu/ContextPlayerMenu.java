package pl.creazy.creazylib.screen.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.CreazyLib;
import pl.creazy.creazylib.util.text.Text;

import java.util.Objects;

public interface ContextPlayerMenu<T> extends MenuBase {
  static <U> void open(@NotNull Class<? extends ContextPlayerMenu<U>> type, @NotNull Player player, U context) {
    open(type, player, 0, context);
  }

  @SuppressWarnings("unchecked")
  static <U> void open(@NotNull Class<? extends ContextPlayerMenu<U>> type, @NotNull Player owner, int pageIndex, U context) {
    var menu = (ContextPlayerMenu<U>) CreazyLib.request().getPartManager().getPart(type);
    Objects.requireNonNull(menu).open(owner, pageIndex, context);
  }

  default void open(@NotNull Player owner, T context) {
    open(owner, 0, context);
  }

  default void open(@NotNull Player owner, int pageIndex, T context) {
    var page = getPage(pageIndex, owner);
    var title = Text.color(getTitle(pageIndex, owner, page.getSize()));
    var inventory = Bukkit.createInventory(new ContextPlayerMenuHolder<>(this, page, owner, context), page.getSize(), title);
    page.setContent(inventory, owner);
    owner.openInventory(inventory);
  }
}

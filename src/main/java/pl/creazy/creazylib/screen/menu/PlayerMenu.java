package pl.creazy.creazylib.screen.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.CreazyLib;
import pl.creazy.creazylib.util.text.Text;

import java.util.Objects;

public interface PlayerMenu extends MenuBase {
  static boolean isMenu(@NotNull Inventory inventory) {
    return inventory.getHolder() instanceof MenuHolder;
  }

  static void open(@NotNull Class<? extends PlayerMenu> type, @NotNull Player player) {
    open(type, player, 0);
  }

  static void open(@NotNull Class<? extends PlayerMenu> type, @NotNull Player owner, int pageIndex) {
    var menu = (PlayerMenu) CreazyLib.request().getPartManager().getPart(type);
    Objects.requireNonNull(menu).open(owner, pageIndex);
  }

  default void open(@NotNull Player owner) {
    open(owner, 0);
  }

  default void open(@NotNull Player owner, int pageIndex) {
    var page = getPage(pageIndex, owner);
    var title = Text.color(getTitle(pageIndex, owner, page.getSize()));
    var inventory = Bukkit.createInventory(new PlayerMenuHolder(this, page, owner), page.getSize(), title);
    page.setContent(inventory, owner);
    owner.openInventory(inventory);
  }
}

package pl.creazy.creazylib.screen.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.jetbrains.annotations.NotNull;

public interface MenuBase {
  default void onClose(@NotNull InventoryCloseEvent event) {
  }

  default void onOpen(@NotNull InventoryOpenEvent event) {
  }

  @NotNull MenuPage getPage(int pageIndex, @NotNull Player owner);

  default @NotNull String getTitle(int pageIndex, @NotNull Player player, int size) {
    return "Menu";
  }
}

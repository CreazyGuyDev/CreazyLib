package pl.creazy.creazylib.screen.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public interface MenuContentSetter {
  void setContent(@NotNull Inventory inventory, @NotNull Player player);
}

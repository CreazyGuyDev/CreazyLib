package pl.creazy.creazylib.screen.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class MenuPage implements MenuContentSetter {
  private final ItemStack[] content = new ItemStack[getSize()];

  @Override
  public final void setContent(@NotNull Inventory inventory, @NotNull Player player) {
    setContent(player);
    inventory.setContents(content);
  }

  public void onClick(@NotNull InventoryClickEvent event) {
  }

  protected abstract void setContent(@NotNull Player player);

  protected int getSize() {
    return 54;
  }

  protected final void setIcon(@NotNull ItemStack icon, int... indexes) {
    for (var index : indexes) {
      content[index] = icon;
    }
  }
}

package pl.creazy.creazylib.screen.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public abstract class MenuHolder implements InventoryHolder {
  protected final MenuBase menu;
  protected final MenuPage page;
  protected final Player owner;

  @NotNull
  @Override
  public Inventory getInventory() {
    return owner.getOpenInventory().getTopInventory();
  }
}

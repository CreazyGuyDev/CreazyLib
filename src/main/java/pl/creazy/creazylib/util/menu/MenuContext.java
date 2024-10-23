package pl.creazy.creazylib.util.menu;

import lombok.experimental.UtilityClass;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import pl.creazy.creazylib.screen.menu.ContextPlayerMenu;
import pl.creazy.creazylib.screen.menu.ContextPlayerMenuHolder;

import java.util.Objects;

@UtilityClass
public class MenuContext {
  @SuppressWarnings("unchecked")
  public static <U> U get(@NotNull Inventory inventory, Class<? extends ContextPlayerMenu<U>> type) {
    return ((ContextPlayerMenuHolder<U>) Objects.requireNonNull(inventory.getHolder())).getContext();
  }
}

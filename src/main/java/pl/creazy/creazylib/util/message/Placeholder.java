package pl.creazy.creazylib.util.message;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Placeholder {
  static Placeholder create(@NotNull String placeholder, @NotNull Object value) {
    return new Placeholder() {
      @Override
      public @NotNull String getPlaceholder() {
        return placeholder;
      }

      @Override
      public @NotNull Object getValue() {
        return value;
      }
    };
  }

  static @NotNull Placeholder text(@NotNull String text) {
    return create("\\$\\{TEXT\\}", text);
  }

  static @NotNull Placeholder name(@NotNull String name) {
    return create("\\$\\{NAME\\}", name);
  }

  static @NotNull Placeholder location(@NotNull String location) {
    return create("\\$\\{LOCATION\\}", location);
  }

  static @NotNull Placeholder playerName(@NotNull String playerName) {
    return create("\\$\\{PLAYER_NAME\\}", playerName);
  }

  static @NotNull Placeholder playerUuid(@NotNull UUID playerUuid) {
    return create("\\$\\{PLAYER_UUID\\}", playerUuid.toString());
  }

  static @NotNull Placeholder amount(double amount) {
    return create("\\$\\{AMOUNT\\}", String.format("%.2f", amount));
  }

  static @NotNull Placeholder amount(int amount) {
    return create("\\$\\{AMOUNT\\}", String.valueOf(amount));
  }

  static @NotNull Placeholder amount(@NotNull String amount) {
    return create("\\$\\{AMOUNT\\}", amount);
  }

  @NotNull String getPlaceholder();

  @NotNull Object getValue();

  default @NotNull String replace(@NotNull String text) {
    return text.replaceAll(getPlaceholder(), getValue().toString());
  }
}

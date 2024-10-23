package pl.creazy.creazylib.util.text;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import net.md_5.bungee.api.ChatColor;

@UtilityClass
public class Text {
  public static @NotNull String color(@NotNull String text) {
    var pattern = Pattern.compile("<#[a-fA-F0-9]{6}>");
    var matcher = pattern.matcher(text);

    while (matcher.find()) {
      var color = text.substring(matcher.start(), matcher.end());
      text = text.replace(color, ChatColor.of(color.substring(1, color.length() - 1)) + "");
      matcher = pattern.matcher(text);
    }

    return ChatColor.translateAlternateColorCodes('&', text);
  }

  public static @NotNull String create(@NotNull Object... strings) {
    var builder = new StringBuilder();
    for (var string : strings) {
      builder.append(string);
    }
    return builder.toString();
  }

  @SneakyThrows
  public static @NotNull String hash(@NotNull String text) {
    var digest = MessageDigest.getInstance("SHA-256");
    return new BigInteger(digest.digest(text.getBytes())).toString(16);
  }

  public static @NotNull String getPrettyClassName(@NotNull Class<?> type) {
    var name = type.getName();
    var lastIndex = name.lastIndexOf('.');
    return name.substring(lastIndex + 1);
  }

  public static @NotNull String pretty(@NotNull NamespacedKey key) {
    return key.getNamespace().concat(":").concat(key.getKey());
  }

  public static @NotNull String orElse(@NotNull String textOr, @NotNull String textElse) {
    return textOr.isBlank() ? textElse : textOr;
  }

  public static @NotNull String path(@NotNull String path) {
    return path.replace("/", File.separator);
  }
}

package pl.creazy.creazylib.engine.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.creazy.creazylib.command.constraints.Args;
import pl.creazy.creazylib.command.constraints.Command;

@Command("setworld")
class SetWorldCommand {
  @Args("?s")
  void setWorld(Player sender, String worldName) {
    sender.teleport(Bukkit.getWorld(worldName).getSpawnLocation());
  }
}

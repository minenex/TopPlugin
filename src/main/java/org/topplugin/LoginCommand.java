package org.topplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Particle;

public class LoginCommand implements CommandExecutor {
    private final TopPlugin plugin;

    public LoginCommand(TopPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Эту команду могут использовать только игроки.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage("Исп.: /login <код>");
            return true;
        }

        String inputCode = args[0];
        String correctCode = plugin.getLoginCode();

        if (inputCode.equals(correctCode)) {
            plugin.getPlayerManager().loginPlayer(player);
            player.sendMessage("Вход успешен! Теперь вы можете двигаться и взаимодействовать во всем.");

            // Spawn particles around the player as a salute
        } else {
            player.sendMessage("Неправильный код входа. Пожалуйста, попробуйте еще раз.");
        }

        return true;
    }
}

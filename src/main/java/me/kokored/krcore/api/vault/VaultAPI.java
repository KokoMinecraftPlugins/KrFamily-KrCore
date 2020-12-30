package me.kokored.krcore.api.vault;

import me.kokored.krcore.KrCore;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultAPI {

    Plugin plugin = KrCore.getPlugin(KrCore.class);

    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    public VaultAPI() {
        if (!checkVault()) {
            plugin.getLogger().warning("[API] Vault was not found!");
            return;
        }
        plugin.getLogger().info("[API] Vault was found!");
        setupEconomy();
        setupPermissions();
        setupChat();
    }

    private void setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        econ = rsp.getProvider();
    }

    private void setupChat() {
        RegisteredServiceProvider<Chat> rsp = plugin.getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
    }

    private void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = plugin.getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
    }

    public Economy getEconomy() {
        if (checkVault()) {
            return econ;
        }
        return null;
    }

    public Permission getPermissions() {
        if (checkVault()) {
            return perms;
        }
        return null;
    }

    public Chat getChat() {
        if (checkVault()) {
            return chat;
        }
        return null;
    }

    private boolean checkVault() {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        return true;
    }

}

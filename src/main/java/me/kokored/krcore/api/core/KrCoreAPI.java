package me.kokored.krcore.api.core;

import me.kokored.krcore.KrCore;
import me.kokored.krcore.api.vault.VaultAPI;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class KrCoreAPI {

    static VaultAPI vaultAPI;

    public KrCoreAPI() {
        vaultAPI = KrCore.vaultAPI;
    }

    //VaultAPI
    //Depend plugins: [ Vault ]

    public static Economy getVaultEco() {
        return vaultAPI.getEconomy();
    }

    public static Chat getVaultChat() {
        return vaultAPI.getChat();
    }

    public static Permission getPerms() {
        return vaultAPI.getPermissions();
    }

}

package me.kokored.krcore;

import me.kokored.krcore.api.core.KrCoreAPI;
import me.kokored.krcore.api.vault.VaultAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class KrCore extends JavaPlugin {

    public static KrCoreAPI krCoreAPI;
    public static VaultAPI vaultAPI;

    @Override
    public void onEnable() {

        sendStartupConsoleMsg();

        setupAPI();

    }

    private void setupAPI() {

        krCoreAPI = new KrCoreAPI();
        vaultAPI = new VaultAPI();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void sendStartupConsoleMsg() {
        //Send Logo
        getLogger().info(getLogo());

        //Send Plugin info & Support info
        getLogger().info("\n" +
                " {}======================[ Enabled KrCore ]======================{} " + "\n" +
                " ||                                                              || " + "\n" +
                " ||  Name    : KrCore                                            || " + "\n" +
                " ||  Author  : Koko_red                                          || " + "\n" +
                " ||  Website : https://hackmd.io/@Kokored7214/KrFamily-KrCore    || " + "\n" +
                " ||                                                              || " + "\n" +
                " {}==========================[ KrCore ]=========================={} ");
    }

    private String getLogo() {
        String logo = "\n" +
                "        ||||    ||||                   ||||||||||||                                                      " + "\n" +
                "        ||||   ||||                  ||||        |||                                                     " + "\n" +
                "        ||||  ||||     ||||    |||   ||||                ||||||||||     ||||    |||                      " + "\n" +
                "        |||||||||      ||||  ||||    ||||              |||        |||   ||||  ||||       ||||||||        " + "\n" +
                "        |||||||||      ||||||||      ||||              |||        |||   ||||||||       |||      |||      " + "\n" +
                "        ||||  ||||     |||||         ||||         ||   |||        |||   |||||          ||||||||||        " + "\n" +
                "        ||||   ||||    ||||          ||||       ||||   |||        |||   ||||           |||       ||      " + "\n" +
                "        ||||    ||||   ||||            |||||||||||       ||||||||||     ||||             |||||||||       ";
        return logo;
    }

}

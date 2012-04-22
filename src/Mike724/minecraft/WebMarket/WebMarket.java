package Mike724.minecraft.WebMarket;

import java.util.logging.Logger;

import net.milkbowl.vault.Vault;

import org.bukkit.plugin.java.JavaPlugin;

import Mike724.minecraft.WebMarket.util.Settings;
import Mike724.minecraft.WebMarket.util.VaultManager;

public class WebMarket extends JavaPlugin {

	public Logger log;

	public void onEnable() {
		log = this.getLogger();
		log.info("Enabled");
		VaultManager.setupEconomy(this);
		VaultManager.setupPermissions(this);
		
		Settings.setSK(this.getConfig().getString("secret-key"));
		Settings.setPort(this.getConfig().getInt("http-port"));
		
		//Run player info HTTP server
		try {
			PlayerHttpServer phs = new PlayerHttpServer();
			phs.start();
		} catch (Exception e) {
		}
	}

	@Override
	public void onDisable() {
		log.info("Disabled");
	}
}

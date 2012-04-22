package com.mike724.webmarket;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import com.mike724.webmarket.util.Settings;
import com.mike724.webmarket.util.VaultManager;

public class WebMarket extends JavaPlugin {

	public Logger log;

	public void onEnable() {
		log = this.getLogger();
		log.info("Enabled");
		
		if(VaultManager.setupEconomy(this)) {
			log.info("Setup economy correctly");
		} else {
			log.severe("Could not setup economy!");
		}
		
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
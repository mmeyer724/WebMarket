package Mike724.minecraft.WebMarket;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import Mike724.minecraft.WebMarket.util.VaultManager;

public class WebMarket extends JavaPlugin {
	
	public Logger log;

	public void onEnable() {
		log = this.getLogger();
		log.info("Enabled");
		VaultManager.setupEconomy(this);
		VaultManager.setupPermissions(this); 
	}
	
	@Override
	public void onDisable() {
		log.info("Disabled");
	}
	//now we can push it
}

package com.techfoxis.personalizedWelcome;

import java.util.HashMap;
import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// Loads the custom welcome messages from the config.yml.
public class ConfigLoader {
	
	private JavaPlugin plugin;
	private FileConfiguration config;
	private HashMap<String, String> welcomeMessages;
	
	public ConfigLoader() {
		this.plugin = JavaPlugin.getPlugin(PersonalizedWelcome.class);
		this.config = plugin.getConfig();
		this.welcomeMessages = new HashMap<String, String>();
		
		ensureConfig();
	}
	
	// Ensures that config.yml exists.
	private void ensureConfig() {
		plugin.saveConfig();
	}
	
	// Loads the custom welcome messages from the config.yml.
	public void loadWelcomeMessages() {
		Set<String> playerNames = config.getKeys(false);
		
		for (String playerName : playerNames) {
			String playerWelcomeMessage = config.getString(playerName);
			
			if (playerWelcomeMessage == null) {
				return;
			}
			
			welcomeMessages.put(playerName, playerWelcomeMessage);
		}
	}
	
	// Returns the currently cached player names and their welcome messages.
	public HashMap<String, String> getWelcomeMessages() {
		return welcomeMessages;
	}
}

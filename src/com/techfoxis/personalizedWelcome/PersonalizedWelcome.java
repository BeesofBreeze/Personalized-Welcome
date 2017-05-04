package com.techfoxis.personalizedWelcome;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class PersonalizedWelcome extends JavaPlugin {

	private Server server;
	private Logger logger;
	private HashMap<String, String> welcomeMessages;
	
	@Override
	public void onEnable() {
		this.server = getServer();
		this.logger = getLogger();
		
		logMessage("Boi, Green sure does looks like a bean... Doesn't he?");
		
		loadConfig();
		registerListeners();
	}

	// Loads config.yml/Welcome Messages.
	private void loadConfig() {
		ConfigLoader configLoader = new ConfigLoader();
		
		configLoader.loadWelcomeMessages();
		
		this.welcomeMessages = configLoader.getWelcomeMessages();
	}
	
	// Registers all the plugin's Listeners with the PluginManager.
	private void registerListeners() {
		ConnectionListener connectionListener = new ConnectionListener();
		
		server.getPluginManager().registerEvents(connectionListener, this);
	}
	
	// Logs a given string to the console.
	private void logMessage(String message) {
		logger.info(message);
	}
	
	// Returns the cached Player Names and Welcome Messages.
	public HashMap<String, String> getWelcomeMessages() {
		return welcomeMessages;
	}
}

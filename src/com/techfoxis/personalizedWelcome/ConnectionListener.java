package com.techfoxis.personalizedWelcome;

import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

// Listens for connections to the server
public class ConnectionListener implements Listener {
	
	private PersonalizedWelcome plugin;
	private HashMap<String, String> welcomeMessages;
	
	public ConnectionListener() {
		this.plugin = JavaPlugin.getPlugin(PersonalizedWelcome.class);
		this.welcomeMessages = plugin.getWelcomeMessages();
	}
	
	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent event) {
		String playerName = event.getPlayer().getDisplayName();
		String playerWelcomeMessage = welcomeMessages.get(playerName);
		String modifiedJoinMessage = playerName + " " + playerWelcomeMessage;
		
		event.setJoinMessage(modifiedJoinMessage);
	}
	
}

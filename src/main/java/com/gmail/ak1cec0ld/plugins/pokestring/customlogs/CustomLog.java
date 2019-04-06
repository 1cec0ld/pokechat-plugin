package com.gmail.ak1cec0ld.plugins.pokestring.customlogs;

import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners.CommandListener;
import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners.JoinListener;
import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners.QuitListener;

public class CustomLog {
	
	public CustomLog() {
		new LogFile();
		new JoinListener();
		new QuitListener();
		new CommandListener();
	}
	
}

package com.mavericks.main;

import java.io.*;
import java.util.Properties;

/**
 * Config Loader is a singleton class which load config properties file
 * @author RoopaBalappa
 *
 */

public class ConfigLoader {
	
	private static ConfigLoader configObj;
	private Properties configProperties;
	
	private ConfigLoader() throws IOException{
		InputStream in = getClass().getResourceAsStream("/config/config.properties");
		configProperties  = new Properties();
		configProperties.load(in);
	}
	
	public static ConfigLoader getInstance(){
		if(configObj == null){
			try {
				configObj = new ConfigLoader();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return configObj;
	}

	public static void main(String args[]) throws IOException{
		ConfigLoader obj = new ConfigLoader();
		System.out.println(obj.getLostMsg());
		System.out.println(obj.getTieMsg());
		System.out.println(obj.getWelcomeMsg());
		System.out.println(obj.getWonMsg());
	}
	
	public String getWelcomeMsg(){
		return configProperties.getProperty("welcomeMsg");
	}
	
	public String getGamingModeMsg(){
		return configProperties.getProperty("gamingModesMsg");
	}
	
	public String getGameMode1Msg(){
		return configProperties.getProperty("gameMode1");
	}
	
	public String getGameMode2Msg(){
		return configProperties.getProperty("gameMode2");
	}
	
	public String getGameMode3Msg(){
		return configProperties.getProperty("gameMode3");
	}
	
	public String getSelectOption(){
		return configProperties.getProperty("selectMsg");
	}
	
	public String getSelectedGameModeMsg(){
		return configProperties.getProperty("selectedGameMode");
	}
	
	public String getGameModeRegex(){
		return configProperties.getProperty("gameModeRegex");
	}
	
	public String getInvalidGameModeSelectMsg(){
		return configProperties.getProperty("invalidGameModeSelectMsg");
	}
	
	public String getValidGameMode1SelectMsg(){
		return configProperties.getProperty("validGameMode1SelectMsg");
	}
	
	public String getValidGameMode2SelectMsg(){
		return configProperties.getProperty("validGameMode2SelectMsg");
	}
	
	public String getValidGameMode3SelectMsg(){
		return configProperties.getProperty("validGameMode3SelectMsg");
	}
	
	public String getChoseExitOptionMsg(){
		return configProperties.getProperty("choseExitOptionMsg");
	}
	
	public String getEnterPlayerNameMsg(){
		return configProperties.getProperty("enterPlayerNameMsg");
	}
	
	public String getSelectRPSMsg(){
		return configProperties.getProperty("selectRPSMsg");
	}
	
	public String getUserInputRegEx(){
		return configProperties.getProperty("userInputRegEx");
	}
	
	public String getComputerPlayer1(){
		return configProperties.getProperty("computerPlayer1");
	}
	
	public String getComputerPlayer2(){
		return configProperties.getProperty("computerPlayer2");
	}
	
	public String getComputerSelectedMsg(){
		return configProperties.getProperty("computerSelectedMsg");
	}
	
	public String getUserSelectedMsg(){
		return configProperties.getProperty("userSelectedMsg");
	}
	
	public String getWonMsg(){
		return configProperties.getProperty("wonMsg");
	}
	
	public String getLostMsg(){
		return configProperties.getProperty("lostMsg");
	}
	
	public String getTieMsg(){
		return configProperties.getProperty("tieMsg");
	}
}

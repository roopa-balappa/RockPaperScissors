package com.mavericks.tests.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mavericks.main.ConfigLoader;

public class ConfigLoaderTest {

	ConfigLoader configLoader;
	
	@Before
	public void setUp() throws Exception {
		configLoader = ConfigLoader.getInstance();
	}

	@Test
	public void testGetWelcomeMsg() {
		Assert.assertEquals("Welcome to Rock Paper Scissors Game", configLoader.getWelcomeMsg());
	}

	@Test
	public void testGetGamingModeMsg() {
		Assert.assertEquals("Gaming mode options are :", configLoader.getGamingModeMsg());
	}
}

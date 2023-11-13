package com.base;

import java.io.File;
import java.util.Properties;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {

	public static AppiumDriverLocalService getServer(Properties configProperties) {
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		serviceBuilder.withIPAddress(configProperties.getProperty("appiumServerIPAddress")).usingPort(Integer.parseInt(configProperties.getProperty("appiumServerPort")))
				.withAppiumJS(new File(configProperties.getProperty("appiumFilePath")))
				.usingDriverExecutable(new File(configProperties.getProperty("nodeJSPath")))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
				.withLogFile(new File("AppiumLog.txt"));
		return AppiumDriverLocalService.buildService(serviceBuilder);
	}
}

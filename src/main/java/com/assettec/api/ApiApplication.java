package com.assettec.api;

import com.assettec.api.integration.CLIENTES.Excel.CaminhoArquivoGUI;
import com.assettec.api.integration.CLIENTES.Excel.WorkOrderCreationService;
import com.assettec.api.internal.core.entities.asset.AssetService;
import com.assettec.api.internal.users.ApiUserRepository;
import com.assettec.api.internal.users.ApiUserService;
import com.assettec.api.internal.utilities.common.XMLParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	private static ConfigurableApplicationContext context;
	private final static Logger logger = LoggerFactory.getLogger(ApiApplication.class);

	public static void main(String[] args) {
		context = SpringApplication.run(ApiApplication.class, args);


	}

	public static void restart() {
		logger.info("[ApiApplication][ Spring boot restarting: CIAO ]");
		ApplicationArguments args = context.getBean(ApplicationArguments.class);

		Thread thread = new Thread(() -> {
			context.close();
			context = SpringApplication.run(ApiApplication.class, args.getSourceArgs());
		});

		thread.setDaemon(false);
		thread.start();
	}
}

package sg.edu.nuss.iss.app.workshop11;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop11Application {
	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);
	private static String portNumber = null;
	private static final String DEFAULT_PORT = "8080";
	public static void main(String[] args) {

		// logger.info("Args : " + args);
		for(String argVal: args){
			logger.debug("Args : " + argVal);
			if(argVal.contains("--ports=")){
				portNumber = argVal.substring(argVal.length()-4,argVal.length());
				logger.debug("PortNumber : " + portNumber);
			}
		}

		if (portNumber == null) {
			portNumber = System.getenv("APP_PORT");
			logger.debug("Sys ENV portNumber : " + portNumber);
		}

		if (portNumber == null) {
			portNumber = DEFAULT_PORT;
		}
		
		SpringApplication app = new SpringApplication(Workshop11Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		app.run(args);


		// SpringApplication app = new SpringApplication(Workshop11Application.class);
		// String port = "8080";
		// ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		// if (cliOpts.containsOption("port"))
		// port = cliOpts.getOptionValues("port").get(0);

		// app.setDefaultProperties(
		// Collections.singletonMap("server.port", port));
		// // System.out.printf("Application started on port %d\n", port);
		// app.run(args);
		
		// SpringApplication.run(Workshop11Application.class, args);
	}

}

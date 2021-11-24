package com.example.Server.Manager;

import com.example.Server.Manager.models.Server;
import com.example.Server.Manager.repositories.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static com.example.Server.Manager.enums.Status.SERVER_UP;

@SpringBootApplication
public class ServerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository){
		return args -> {
			serverRepository.save(new Server(
					null,
					"192.168.1.160",
					"Ubuntu Linux",
					"16 GB",
					"Personal PC",
					"http://localhost:8080/server/image/server1.png",
					SERVER_UP));
			serverRepository.save(new Server(
					null,
					"192.168.1.58",
					"Fedora Linux",
					"16 GB",
					"Dell Tower",
					"http://localhost:8080/server/image/server2.png",
					SERVER_UP));
			serverRepository.save(new Server(
					null,
					"192.168.1.21",
					"MS 2008",
					"32 GB",
					"Personal PC",
					"http://localhost:8080/server/image/server3.png",
					SERVER_UP));
			serverRepository.save(new Server(
					null,
					"192.168.0.103",
					"Munte laptop",
					"64 GB",
					"Personal PC",
					"http://localhost:8080/server/image/server4.png",
					SERVER_UP));
		};
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

//	@Bean
//	CorsConfigurationSource corsConfigurationSource()
//	{
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//		configuration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		configuration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
//				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
//		configuration.setAllowCredentials(true);
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
}

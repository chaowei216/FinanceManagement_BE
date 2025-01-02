package com.weiz.loanscheduleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan({
		"com.weiz.loanscheduleservice",
		"com.weiz.commonservice"
})
public class LoanscheduleserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanscheduleserviceApplication.class, args);
	}

}

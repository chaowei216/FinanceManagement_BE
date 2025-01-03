package com.weiz.loanscheduleservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Loan Schedule API Specification",
                description = "Api documentation for Loan Schedule Service",
                version = "v1.0.0",
                contact = @Contact(
                  name = "chaoweiz",
                  email = "luutrieuvi2003@gmail.com",
                  url = "http://chaoweiz.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "http://chaoweiz.com/licenses"
                ),
                termsOfService = "http://chaoweiz.com/terms"
        ),
        servers = @Server(
                url = "http://localhost:9002",
                description = "Local ENV"
        )
)
public class OpenApiConfig {
}
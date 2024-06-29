package nob.example.split_bill_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Split bill API", version = "1.0.0", description = "割り勘APIです。"))
public class SplitBillAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitBillAppApplication.class, args);
	}

}

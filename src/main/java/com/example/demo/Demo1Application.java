package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	@RestController
	public class SampleController {

	    @GetMapping("/test")
	    public String test() {
	        List<Tag> tags = List.of(
	                Tag.of("my_label_a", "A"),
	                Tag.of("my_label_b", "B")
	        );
	        Metrics.counter("keda.demo.count.total", tags).increment();
	        return "test";
	    }
	}

}
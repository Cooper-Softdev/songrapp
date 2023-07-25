package com.songr.songrapp;

import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SongrappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongrappApplication.class, args);
	}
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello";
	}
	@GetMapping("/capitalize/{words}")
	public String capitalize(@PathVariable String words, Model model) {
		model.addAttribute("capitalizedWords", words.toUpperCase());
		return "capitalize";
	}

}

package com.songr.songrapp;

import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import com.songr.songrapp.Album;

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
	@GetMapping("/albums")
	public String albums(Model model) {
		List<Album> albums = new ArrayList<>();
		albums.add(new Album("Master of Puppets", "Metallica", 10, 3600, "METALRULZ.com"));
		albums.add(new Album("Kitsch", "Avery Green", 12, 4000, "Shredtacular.com"));
		albums.add(new Album("Scotland's Okay-est", "Lewis Catapulti", 8, 3000, "Sheeps.com"));
		model.addAttribute("albums", albums);
		return "albums";
	}

}

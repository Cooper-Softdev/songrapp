package com.songr.songrapp;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class Album {
    @GetMapping("/albums")
    public String albums(Model model) {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Master of Puppets", "Metallica", 10, 3600, "METALRULZ.com"));
        albums.add(new Album("Kitsch", "Avery Green", 12, 4000, "Shredtacular.com"));
        albums.add(new Album("Scottland's Okayest", "Lewis Catapulti", 8, 3000, "URL 3"));
        model.addAttribute("albums", albums);
        return "albums";
    }
}

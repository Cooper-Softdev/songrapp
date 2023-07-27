package com.songr.songrapp.controllers;
import com.songr.songrapp.respositories.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.songr.songrapp.models.Album;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepo albumRepo;
    @GetMapping("/")
    public String getHomePage(Model m) {
        List<Album> albumsArray = albumRepo.findAll();
        m.addAttribute("albums", albumsArray);
        return "home";
    }
    @GetMapping("/add-album")
    public String getAlbumsPage() {
        return "albums.html";
    }
    @PostMapping("/add-album")
    public RedirectView addAlbumFromForm(String title, String artist, Integer songCount, Integer length, String imageUrl ) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepo.save(newAlbum);

        return new RedirectView("/");
    }
    @GetMapping("/album/{id}")
    public String getAlbumPage(@PathVariable Long id, Model m) {
        Album album = albumRepo.findById(id).orElse(null);
        if (album != null) {
            m.addAttribute("album", album);
            return "album";
        } else {
            return "notFound";
        }
    }
}
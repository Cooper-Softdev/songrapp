package com.songr.songrapp.controllers;

import com.songr.songrapp.models.Album;
import com.songr.songrapp.models.Song;
import com.songr.songrapp.respositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;
import com.songr.songrapp.respositories.AlbumRepo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SongController {
    @Autowired
    SongRepo songRepo;

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        List<Song> songs = songRepo.findAll();
        m.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/add-song")
    public String getAddSongPage() {
        return "add-song";
    }

    @Autowired
    AlbumRepo albumRepo;

    @PostMapping("/add-song")
    public RedirectView addSongFromForm(String title, int length, int trackNumber, String albumTitle, RedirectAttributes redirectAttributes) {
        Album album = albumRepo.findByTitle(albumTitle);
        if (album == null) {
            redirectAttributes.addFlashAttribute("error", "The album does not exist.");
            return new RedirectView("/add-song");
        } else {
            Song newSong = new Song(title, length, trackNumber, album);
            songRepo.save(newSong);
            return new RedirectView("/songs");
        }
    }
}

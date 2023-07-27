package com.songr.songrapp.respositories;

import com.songr.songrapp.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {
    Song findByTitle(String title);
}

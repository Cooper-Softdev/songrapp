package com.songr.songrapp.respositories;

import com.songr.songrapp.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album, Long> {
    Album findByTitle(String title);
}

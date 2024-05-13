package services;

import entities.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Model
@SessionScoped
public class GenreSongLoader implements Serializable
{
    @Getter
    @Setter
    private Map<Long, CompletableFuture> genresWithLoadedSongs = new HashMap<>();

    public void loadGenreSongs(Long genreId)
    {
        genresWithLoadedSongs.put(genreId, CompletableFuture.runAsync(() -> {}));
    }
}

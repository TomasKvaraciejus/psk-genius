package services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped
@Specializes
public class SpecializedGenreSongLoader extends GenreSongLoader{
    public void loadGenreSongs(Long genreId)
    {
        getGenresWithLoadedSongs().put(genreId, CompletableFuture.runAsync(() -> loadSongsAsync()));
    }

    private void loadSongsAsync(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}

package services;

import entities.Song;
import persistence.IDAO;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Decorator
@Dependent
public abstract class SongViewCountDecorator implements IDAO<Song> {
    @Inject
    @Delegate
    private IDAO<Song> songDAO;

    @Override
    @Transactional
    public Song findById(long id){
        Song song = songDAO.findById(id);

        int viewCount = song.getViewCount() == null ? 0 : song.getViewCount() + 1;
        song.setViewCount(viewCount);
        songDAO.update(song);
        return song;
    }
}

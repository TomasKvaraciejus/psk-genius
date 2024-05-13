
package rest;

import dto.DTOMapper;
import dto.GenreCreateOrUpdateDAO;
import entities.Genre;
import entities.Song;
import persistence.GenreDAO;
import persistence.SongDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/genres")
public class GenresController {

    @Inject
    private GenreDAO genresDAO;

    @Inject
    private SongDAO songDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Genre> genres = genresDAO.findAll();
        return Response.ok(genres.stream()
                .map(DTOMapper::toGenreDTO)
                .collect(Collectors.toList())).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(
            @PathParam("id") final Long id) {
        Genre genre = genresDAO.findById(id);
        if (genre == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(DTOMapper.toGenreDTO(genre)).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final long genreId,
            GenreCreateOrUpdateDAO genreData) {
        Genre currentGenre = genresDAO.findById(genreId);
        if (currentGenre == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Song> songs = genreData.getSongIds().stream()
                .map(songDAO::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (songs.size() < genreData.getSongIds().size()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("One or more songs were not found.").build();
        }
        currentGenre.setSongs(songs);
        try {
            genresDAO.update(currentGenre);
            for(Song song : songs) {
                song.getGenres().add(currentGenre);
                songDAO.update(song);
            }
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.ok(DTOMapper.toGenreDTO(currentGenre)).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(GenreCreateOrUpdateDAO genreData) {
        List<Song> songs = genreData.getSongIds().stream()
                .map(songDAO::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (songs.size() < genreData.getSongIds().size()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("One or more songs were not found.").build();
        }
        Genre newGenre = new Genre();
        newGenre.setName(genreData.getName());
        newGenre.setSongs(songs);
        genresDAO.save(newGenre);
        for(Song song : songs) {
            song.getGenres().add(newGenre);
            songDAO.update(song);
        }
        return Response.created(URI.create("/genres/" + newGenre.getId())).entity(DTOMapper.toGenreDTO(newGenre)).build();
    }

    @Path("/{id}")
    @DELETE
    @Transactional
    public Response delete(
            @PathParam("id") final long genreId) {
        Genre currentGenre = genresDAO.findById(genreId);
        if (currentGenre == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        for(Song song : currentGenre.getSongs()) {
            song.getGenres().remove(currentGenre);
            songDAO.update(song);
        }
        genresDAO.delete(currentGenre);
        return Response.noContent().build();
    }
}
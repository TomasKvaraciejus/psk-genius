package dto;

import entities.Genre;

import java.util.stream.Collectors;

public class DTOMapper {

    public static GenreDTO toGenreDTO(Genre genre) {
        GenreDTO dto = new GenreDTO();
        dto.setId(genre.getId());
        dto.setName(genre.getName());
        dto.setSongIds(genre.getSongs().stream().map(song -> song.getId()).collect(Collectors.toList()));
        return dto;
    }
}
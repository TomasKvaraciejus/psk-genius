package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenreCreateOrUpdateDAO {
    private String name;
    private List<Long> songIds = new ArrayList<>();
}

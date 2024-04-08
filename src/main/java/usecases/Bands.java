package usecases;

import entities.Band;
import lombok.Getter;
import lombok.Setter;
import persistence.BandDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Bands implements Serializable {
    @Inject
    private BandDAO bandDAO;

    @Getter
    @Setter
    private Band bandToCreate = new Band();

    @Getter
    private List<Band>   allBands;

    @PostConstruct
    public void init() {
        loadAllBands();
    }

    @Transactional
    public void createBand() {
        this.bandDAO.save(bandToCreate);
    }

    private void loadAllBands() {
        this.allBands = bandDAO.findAll();
    }
}
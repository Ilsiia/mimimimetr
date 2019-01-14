package ilsiya.sabirzyanova.service;

import ilsiya.sabirzyanova.model.Cat;

import java.util.List;
import java.util.UUID;

public interface CatService {
    void saveOrUpdate(Cat persistent);

    Cat getById(UUID id);

    List<Cat> getTop();

    List<Cat> getAll();

    List<Cat[]> getShuffleList();

}

package ilsiya.sabirzyanova.service;

import ilsiya.sabirzyanova.dao.CatJpaRepository;
import ilsiya.sabirzyanova.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Lazy
@Transactional
public class CatServiceImpl implements CatService {
    private final CatJpaRepository repository;

    @Autowired
    public CatServiceImpl(CatJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveOrUpdate(Cat persistent) {
        repository.save(persistent);
    }

    @Override
    public Cat getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cat> getTop() {
        return repository.findTop10ByOrderByRatingDesc();
    }

    @Override
    public List<Cat> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Cat[]> getShuffleList() {
        List<Cat[]> result = new ArrayList<>();
        List<Cat> cats = getAll();
        Collections.shuffle(cats);
        int pairCount = cats.size() / 2;
        for (int i = 0; i < pairCount * 2 - 1; i = i + 2) {
            result.add(new Cat[]{cats.get(i), cats.get(i + 1)});
        }
        boolean even = cats.size() % 2 == 0;
        if (!even) {
            result.add(new Cat[]{cats.get(new Random().nextInt(cats.size() - 2)), cats.get(cats.size() - 1)});
        }
        return result;
    }

    @Override
    public synchronized void voteForCat(UUID catId) {
        Cat entity = getById(catId);
        System.out.println("rating " + entity.getName() + ": " + entity.getRating());
        int rating = entity.getRating() + 1;
        entity.setRating(rating);
        saveOrUpdate(entity);
    }
}

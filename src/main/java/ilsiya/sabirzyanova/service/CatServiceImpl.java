package ilsiya.sabirzyanova.service;

import ilsiya.sabirzyanova.dao.CatJpaRepository;
import ilsiya.sabirzyanova.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

}

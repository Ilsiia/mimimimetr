package ilsiya.sabirzyanova.controller;

import ilsiya.sabirzyanova.model.Cat;
import ilsiya.sabirzyanova.model.ResponseMetadata;
import ilsiya.sabirzyanova.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {

    private final CatService catService;

    @Autowired
    public VoteController(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Cat[]> getShuffleList() {
        List<Cat[]> result = new ArrayList<>();
        List<Cat> cats = catService.getAll();
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

    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMetadata handleFileUpload(@RequestParam(value = "catId") UUID id) {
        Cat entity = catService.getById(id);
        int rating = entity.getRating() + 1;
        entity.setRating(rating);
        catService.saveOrUpdate(entity);
        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setMessage("success");
        metadata.setStatus(200);
        return metadata;
    }
}

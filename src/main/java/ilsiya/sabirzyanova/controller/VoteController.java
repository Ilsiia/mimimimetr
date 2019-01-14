package ilsiya.sabirzyanova.controller;

import ilsiya.sabirzyanova.model.Cat;
import ilsiya.sabirzyanova.model.ResponseMetadata;
import ilsiya.sabirzyanova.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

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
        return catService.getShuffleList();
    }

    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMetadata ratingUpdate(@RequestParam(value = "catId") UUID id) {
        Cat entity = catService.getById(id);
        System.out.println("rating:" + entity.getRating());
        int rating = entity.getRating() + 1;
        entity.setRating(rating);
        catService.saveOrUpdate(entity);
        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setMessage("success");
        metadata.setStatus(200);
        return metadata;
    }
}

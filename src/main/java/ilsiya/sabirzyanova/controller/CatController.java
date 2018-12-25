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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/cat")
public class CatController {

    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMetadata handleFileUpload(@RequestParam(value = "name") String name, @RequestParam(value = "pict") MultipartFile pict) throws IOException {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setPict(pict.getBytes());
        catService.saveOrUpdate(cat);
        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setMessage("success");
        metadata.setStatus(200);
        return metadata;
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Cat> getTop() {
        return catService.getTop();
    }


}
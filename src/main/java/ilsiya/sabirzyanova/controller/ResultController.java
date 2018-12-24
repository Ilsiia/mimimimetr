package ilsiya.sabirzyanova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String getResultPage() {
        return "result";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getVotePage() {
        return "vote";
    }
}
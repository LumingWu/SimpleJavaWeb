package controller;

import bean.GameMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ByteHunterController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/rest/gamemap", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public GameMap getGameMap() {
        return new GameMap();
    }

}

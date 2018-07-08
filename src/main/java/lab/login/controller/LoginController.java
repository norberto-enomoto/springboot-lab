package lab.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucas
 */
@Controller
public class LoginController {

    @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("login/view.login.form");
    }

    @RequestMapping(path = {"/home"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("home/view.home.index");
    }
}

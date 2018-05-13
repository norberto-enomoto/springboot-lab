package lab.cliente.controller;

import javax.validation.Valid;
import lab.cliente.model.Cliente;
import lab.cliente.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucas
 */
@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository model;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelMap map) {
        ModelAndView mv = new ModelAndView("/cliente/view.cliente.index");
        map.addAttribute("list", model.findAllByOrderByIdAsc());
        return mv;
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("/cliente/view.cliente.form");
        return view;
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public ModelAndView adicionar(@Valid Cliente cliente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return form();
        }
        model.save(cliente);
        return new ModelAndView("redirect:/cliente");
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("/cliente/view.cliente.form");
        view.addObject("obj", model.getOne(id));
        return view;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public ModelAndView atualizar(@PathVariable("id") int id, @Valid Cliente cliente, BindingResult result) {
        cliente.setId(id);
        if (result.hasErrors()) {
            return form();
        }
        model.save(cliente);
        return new ModelAndView("redirect:/cliente");
    }

    @RequestMapping(path = "/deletar/{id}", method = RequestMethod.GET)
    public String deletar(@PathVariable int id) {
        Cliente c = model.getOne(id);
        model.delete(c);
        return "redirect:/cliente";
    }
}

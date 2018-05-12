package lab.cliente;

import javax.validation.Valid;
import lab.cliente.model.Cliente;
import lab.cliente.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public ModelAndView index(ModelMap map) {
        ModelAndView mv = new ModelAndView("/cliente/view.index");
        map.addAttribute("list", model.findAll());
        return mv;
    }

    @GetMapping(path = "/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("/cliente/view.form");
        return view;
    }

    @PostMapping
    public ModelAndView adicionar(@Valid Cliente cliente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return form();
        } else {
            model.save(cliente);
            return new ModelAndView("redirect:/cliente");
        }
    }

    @GetMapping(path = "/{id}")
    public ModelAndView get(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("/cliente/view.form");
        view.addObject("obj", model.getOne(id));
        return view;
    }

    @PostMapping(path = "/{id}")
    public ModelAndView atualizar(@PathVariable("id") int id, @Valid Cliente cliente, BindingResult result) {
        cliente.setId(id);
        if (result.hasErrors()) {
            return form();
        }
        model.save(cliente);
        return new ModelAndView("redirect:/cliente");
    }

    @GetMapping(path = "/deletar/{id}")
    public String deletar(@PathVariable int id) {
        Cliente c = model.getOne(id);
        model.delete(c);
        return "redirect:/cliente";
    }
}

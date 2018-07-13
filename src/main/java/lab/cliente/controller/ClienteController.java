package lab.cliente.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lab.cliente.model.Cliente;
import lab.cliente.model.ClienteRepository;
import lab.reports.FileType;
import lab.reports.ReportUtils;
import lab.utils.Formata;
import net.sf.jasperreports.engine.JRException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private ClienteReportService service;

    @Autowired
    private ServletContext context;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/cliente/view.cliente.index");
        mv.addObject("list", model.findAllByOrderByIdAsc());
        return mv;
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        return new ModelAndView("/cliente/view.cliente.form");
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
    public ModelAndView atualizar(@PathVariable("id") int id,
            @Valid @ModelAttribute(name = "obj") Cliente cliente, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        cliente.setId(id);
        if (bindingResult.hasErrors()) {
            return form();
        }
        model.save(cliente);
        modelAndView.setViewName("redirect:/cliente");
        return modelAndView;
    }

    @RequestMapping(path = "/deletar/{id}", method = RequestMethod.GET)
    public String deletar(@PathVariable int id) {
        Cliente c = model.getOne(id);
        model.delete(c);
        return "redirect:/cliente";
    }

    @RequestMapping(path = "/report/clientes", method = RequestMethod.GET)
    public ModelAndView reportClientes() {
        ModelAndView view = new ModelAndView("/cliente/view.cliente.report");
        HashMap fileType = ReportUtils.tipoArquivo();
        view.addObject("filetype", fileType);
        return view;
    }

    @RequestMapping(path = "/report/clientes", method = RequestMethod.POST)
    public void reportClientes(@RequestParam(value = "acao") String acao,
            @RequestParam(value = "tipoArquivo") String tipoArquivo,
            HttpServletResponse response) {
        try{
            if (StringUtils.isNotBlank(acao)
                    && StringUtils.isNotBlank(tipoArquivo)) {
                String realPath = ReportUtils.contextPath(context);
                service.setReportFilePath(realPath + "cliente/reports/clientes.jasper");
                service.setOutputFileName("lista_clientes");
                service.setFileType(FileType.fromId(Formata.getInteger(tipoArquivo)));
                ByteArrayOutputStream clienteReport = service.clienteReport();
                service.abrirArquivoBrowser(response, clienteReport);
            }
        } catch (SQLException | JRException | IOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

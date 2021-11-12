package de.hhu.propra.alkomat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class WebController {

    @GetMapping
    public String index(Model m){
        m.addAttribute("form",new Form("m",0,0,0));
        return "index";
    }

    @PostMapping
    public String processData(Model m, @Valid Form form, BindingResult bindingResult){
        m.addAttribute("form", form);
        System.out.println(form.geschlecht());
        return "index";
    }
}

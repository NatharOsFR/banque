package com.banque.mvcControllers;

import com.banque.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TypeProduitController {
    private final TypeProduitService typeProduitService;

    @Autowired
    public TypeProduitController(TypeProduitService typeProduitService) {
        this.typeProduitService = typeProduitService;
    }

    @GetMapping("/typeProduit")
    public String listTYpeProduit(Model model)
    {
        model.addAttribute("listeTypeProduit", typeProduitService.getAllTypeProduit());
        return "LesTypeProduit/typeProduit";
    }
}
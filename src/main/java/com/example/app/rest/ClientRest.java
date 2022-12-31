package com.example.app.rest;

import com.example.app.domain.Client;
import com.example.app.service.ClientService;
import com.example.app.service.UploadFileDB;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping( "/clients")
public class ClientRest {
    private final ClientService clientService;

    private final UploadFileDB uploadFileDB;

    @PostMapping("/novo")
    public ModelAndView save(@RequestParam("file") MultipartFile file,
                             Client client, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors())  return null;
        uploadFileDB.gravaImagemBase64Service(file, clientService, client);
        attributes.addFlashAttribute("mensagem","Salvo com sucesso!");

        return new ModelAndView("redirect:/clients/novo").addObject(client);
    }
}

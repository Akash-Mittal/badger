package com.am.innovations.badger.controller;

import java.net.URISyntaxException;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.am.innovations.badger.API;
import com.am.innovations.badger.configurations.yml.BadgesConfiguration;
import com.am.innovations.badger.enums.OPS;
import com.am.innovations.badger.service.RepoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RestController
@RequestMapping(API.BASE_PATH)
@Api
public class RepoController {

    Logger logger = LoggerFactory.getLogger(RepoController.class);

    @Autowired
    private RepoService repoService;


    @GetMapping("/json/{size}")
    @ApiOperation(value = "Get Json Array With Given Size", notes = "", response = String.class)
    public String getJSONDataInArray(@NonNull @PathVariable(value = "size") Integer size) throws URISyntaxException {
        PodamFactoryImpl podamFactoryImpl = new PodamFactoryImpl();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String dataToReturn[] = new String[size];
        for (int i = 0; i < dataToReturn.length; i++) {
            dataToReturn[i] = podamFactoryImpl.manufacturePojo(BadgesConfiguration.class).toString();
        }
        return gson.toJson(dataToReturn);
    }

}

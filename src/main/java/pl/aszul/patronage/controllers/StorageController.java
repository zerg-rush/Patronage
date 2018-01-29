package pl.aszul.patronage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pl.aszul.patronage.bootstrap.SpringBootstrap;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/storage", produces = { "application/json", "application/xml" })
@Api(value = "onlinestore", description = "Controller exposing Storage engine mode", tags = "StorageController")
public class StorageController {

    @ApiOperation(value = "Show current storage type (H2 vs HashMap)")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map storageType(){
        return Collections.singletonMap("storage mode", (SpringBootstrap.h2StorageEnabled ? "new H2 database (in memory)" :
                "old basic HashMap object (in memory)"));
    }

}
package com.udacity.gradle.builditbigger.backend;

import com.example.joketellinglib.JokeTelling;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
//
//import com.example.joketellinglib.JokeTelling;
//
import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();

        JokeTelling jokeMaker = new JokeTelling();
        String newJoke = jokeMaker.getJoke();
        response.setData(newJoke);

        return response;
    }

}

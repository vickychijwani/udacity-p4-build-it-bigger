/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package me.vickychijwani.udacity.jokebackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import me.vickychijwani.udacity.libjoke.JokeFactory;

/** An endpoint class we are exposing */
@Api(
  name = "libjoke",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "jokebackend.udacity.vickychijwani.me",
    ownerName = "jokebackend.udacity.vickychijwani.me",
    packagePath=""
  )
)
public class JokeEndpoint {

    @ApiMethod(name = "getRandomJoke")
    public Joke getRandomJoke() {
        return new Joke(JokeFactory.getRandomJoke());
    }

}

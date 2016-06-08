package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import me.vickychijwani.udacity.jokebackend.libjoke.Libjoke;

class FetchJokeTask extends AsyncTask<Void, Void, String> {
    private static Libjoke myApiService = null;

    @Override
    protected final String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            Libjoke.Builder builder = new Libjoke.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://udacity-jokebackend.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJoke().execute().getText();
        } catch (IOException e) {
            Log.e(FetchJokeTask.class.getSimpleName(), e.getMessage());
            return null;
        }
    }

}

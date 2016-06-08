package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import me.vickychijwani.jokedisplay.ViewJokeActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new FetchAndDisplayJokeTask(this).execute();
    }


    private static class FetchAndDisplayJokeTask extends FetchJokeTask {
        private final Context mContext;

        public FetchAndDisplayJokeTask(Context context) {
            mContext = context;
        }

        @Override
        protected void onPostExecute(@Nullable String jokeText) {
            if (jokeText == null) {
                Toast.makeText(mContext, "Error fetching joke", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent viewJokeIntent = new Intent(mContext, ViewJokeActivity.class);
            viewJokeIntent.putExtra(ViewJokeActivity.INTENT_EXTRA_JOKE, jokeText);
            mContext.startActivity(viewJokeIntent);
        }

    }

}

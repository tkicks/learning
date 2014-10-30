package com.example.tkicks.statechange;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class StateChangeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_change);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.state_change, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // super.method overrides the method

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("TAG", "onStart");  // log "onStart" each time onStart happens
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("TAG", "onSaveInstanceState");

        // saving the state so it isn't destroyed with onDestroy(rotate phone, etc.)
        final EditText textBox = (EditText)findViewById(R.id.editText2);
        CharSequence theText = textBox.getText();
        outState.putCharSequence("savedText", theText);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("TAG", "onRestoreInstanceState");

        // restoring the state after being onDestroyed
        // could also be restored in onCreate()
        final EditText textBox = (EditText)findViewById(R.id.editText2);
        CharSequence theText = savedInstanceState.getCharSequence("savedText");
        textBox.setText(theText);
    }
}

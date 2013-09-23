package com.example.testproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button[] buttons = new Button[9];
	boolean isXTurn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons[0] = (Button)findViewById(R.id.button1);
        buttons[1] = (Button)findViewById(R.id.button2);
        buttons[2] = (Button)findViewById(R.id.button3);
        buttons[3] = (Button)findViewById(R.id.button4);
        buttons[4] = (Button)findViewById(R.id.button5);
        buttons[5] = (Button)findViewById(R.id.button6);
        buttons[6] = (Button)findViewById(R.id.button7);
        buttons[7] = (Button)findViewById(R.id.button8);
        buttons[8] = (Button)findViewById(R.id.button9);
        final TextView text = (TextView)findViewById(R.id.textView1);
        for(int i = 0; i < buttons.length; i++){
        	 buttons[i].setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     Button b = (Button)v;
                     if(!b.getText().equals("")) return;
                     String player = isXTurn ? "X" : "O";
                     b.setText(player);
                     if(isGameEnded()){
                    	 text.setText(player + " wins!");
                    	 clearButtons();
                     }
                     isXTurn = !isXTurn;
                 }
             });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private boolean isGameEnded(){
    	for(int i = 0; i < 3; i++){
    		if(equalButtons(buttons[3*i], buttons[3*i+1],buttons[3*i+2])) return true;
    		if(equalButtons(buttons[i],buttons[3+i],buttons[6+i])) return true;
    	}
    	if(equalButtons(buttons[0],buttons[4],buttons[8])) return true;
    	if(equalButtons(buttons[2],buttons[4],buttons[6])) return true;
    	return false;
    }
    
    private boolean equalButtons(Button b1, Button b2, Button b3){
    	if(b1.getText().equals(""))return false;
    	return b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }
    
    private void clearButtons(){
    	for(Button b : buttons){
    		b.setText("");
    	}
    }
}

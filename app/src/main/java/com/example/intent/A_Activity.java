package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class A_Activity extends Activity {
    private TextView textView,fen;

    private TextView title, computerActionText, playerActionText,
            whatComputerActedText, resultText;
    private Button scissorButton, stoneButton, clothButton;
    private String[] fingers = new String[] {"剪刀", "石头", "布"};
    private String player_win = "恭喜,你赢了!";
    private String player_draw = "双方平手!";
    private String player_lose = "很可惜,你输了!";
    int iComPlay;


    private int fen_win = 10;
    private int fen_draw = 0;
    private int fen_lose = 10;
    private int sum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        textView = (TextView) findViewById(R.id.msg);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");

        String personInfo = "欢迎"+name+"登录";
        textView.setText(personInfo);


        AssetManager assets = getAssets();
        super.onCreate(savedInstanceState);

        title = (TextView)findViewById(R.id.title);
        computerActionText = (TextView)findViewById(R.id.computerActionText);
        playerActionText = (TextView)findViewById(R.id.playerActionText);
        whatComputerActedText = (TextView)findViewById(R.id.whatComputerActedText);
        fen = (TextView)findViewById(R.id.fen);
        resultText = (TextView)findViewById(R.id.resultText);
        scissorButton = (Button)findViewById(R.id.scissorButton);
        stoneButton = (Button)findViewById(R.id.stoneButton);
        clothButton = (Button)findViewById(R.id.clothButton);
        iComPlay = (int)(Math.random()*3 + 1);
        fen.setText("0");
        scissorButton.setOnClickListener(btnOnClick);
        stoneButton.setOnClickListener(btnOnClick);
        clothButton.setOnClickListener(btnOnClick);

    }

    private Button.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button b = (Button)view;
            String currentText = b.getText().toString();
            iComPlay = (int)(Math.random() * 3);
            whatComputerActedText.setText(fingers[iComPlay]);
            //1 - 剪刀, 2 - 石头, 3 - 布
            switch (iComPlay) {
                case 0: //剪刀
                    if (currentText.equals("剪刀")) {
                        resultText.setText(player_draw);
                        fen.setText(Integer.toString(sum));
                    }
                    if (currentText.equals("石头")) {
                        resultText.setText(player_win);
                        sum=sum+fen_win;
                        fen.setText(Integer.toString(sum));
                    }
                    if (currentText.equals("布")){
                        resultText.setText(player_lose);
                        sum=sum-fen_lose;
                        fen.setText(Integer.toString(sum));
                    }
                    break;
                case 1: //石头
                    if (currentText.equals("剪刀")){
                        resultText.setText(player_lose);
                        sum=sum-fen_lose;
                        fen.setText(Integer.toString(sum));
                    }
                    if (currentText.equals("石头")){
                        resultText.setText(player_draw);
                        fen.setText(Integer.toString(sum));
                    }
                    if (currentText.equals("布")) {
                        resultText.setText(player_win);
                        sum=sum+fen_win;
                        fen.setText(Integer.toString(sum));
                    }
                    break;
                case 2: //布
                    if (currentText.equals("剪刀")) {
                        resultText.setText(player_win);
                        sum=sum+fen_win;
                        fen.setText(Integer.toString(sum));
                    }
                    if (currentText.equals("石头")) {
                        resultText.setText(player_lose);
                        sum=sum-fen_lose;
                        fen.setText(Integer.toString(sum));
                    }
                    if (currentText.equals("布")){
                        resultText.setText(player_draw);
                        fen.setText(Integer.toString(sum));
                    }
                    break;
            }
        }
    };


}

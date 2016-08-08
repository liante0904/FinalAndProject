package com.project.finalandproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.finalandproject.dto.MemberDTO;
import com.project.finalandproject.member.Info;
import com.project.finalandproject.member.Mem_Join_Page;
import com.project.finalandproject.naver.OAuthSampleActivity;

/**
 * Created by Administrator on 2016-08-02.
 */
public class Main_Page extends Activity {

    Intent intent;
    Button Joinbt, naverbt, daumbt;

    EditText member_id;
    EditText member_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Joinbt = (Button)findViewById(R.id.joinbt);
        member_id = (EditText)findViewById(R.id.num1);
        member_pwd = (EditText)findViewById(R.id.num2);
    /*    naverbt = (Button) findViewById(R.id.naverbt);
        daumbt = (Button) findViewById(R.id.daumbt);*/



        daumbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), OAuthSampleActivity.class);
                startActivity(intent);
                finish();

            }
        });


        naverbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplication(), OAuthSampleActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void Joinbt(View v){
        intent = new Intent(getApplication(), Mem_Join_Page.class);
        startActivity(intent);
    }

    public void Login(View v){

        Log.d("로그인","버튼누름");
        MemberDTO m = new MemberDTO();
        m.setId(member_id.getText().toString());
        m.setPwd(member_pwd.getText().toString());

        if(Info.connServer("login", m)){
            Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();


    }


}

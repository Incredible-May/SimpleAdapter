package com.example.simpleadapter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
private String[] names=new String[]
        {
               "Lion","Tiger","Monkey","Dog","Cat","Elephant"
        };
    private int[] imageIds=new int[]
            {
                    R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,
                    R.drawable.cat,R.drawable.elephant
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems =new ArrayList<Map<String, Object>>();
        for(int i=0;i<names.length;i++)
        {
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("annimalname",names[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,
                R.layout.simple_item,
                new String[]{"annimalname","header"},
                 new int[]{R.id.name,R.id.header});
        ListView list=(ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);


        //toast 单击事件
       //为按钮的单击事件绑定事件监听器
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
                //创建一个Toast提示信息
                //Toast toast =Toast.makeText(MainActivity.this,"简单的提示信息",Toast.LENGTH_SHORT);//最后一句是设置信息的提示时间
               // Toast toast =new Toast(MainActivity.this);
                Toast toast = Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_LONG);
                if (((ListView)parent).getTag() != null){

                    ((View)((ListView)parent).getTag()).setBackgroundDrawable(null);

                }
                ((ListView)parent).setTag(view);
                parent.getChildAt(position);
                View view1=parent.getChildAt(position);
                view1.setBackgroundColor(Color.parseColor("#40ff9c"));
                toast.show();
            }


        });

    }
}

package com.maadlabs.circledragselectsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;

import com.maadlabs.circledragselect.view.CircleView;
import com.maadlabs.circledragselect.view.CirclesOptionView;
import com.maadlabs.circledragselect.view.CustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    CirclesOptionView mCirclesOptionView;
    SimpleAdapter mCirclesOptionAdapter;
    ArrayList<HashMap<String, String>> mCirclesOptionData;
    String[] mCirclesOptionAdapterFrom;
    int[] mCirclesOptionAdapterTo;
    CustomAdapter<HashMap<String, String>> mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProperties();
        initData();
        initAdapter();
    }

    void initProperties(){
        mCirclesOptionView = (CirclesOptionView) findViewById(R.id.circlesOptionViewMain);

    }

    void initData(){

        mCirclesOptionData = new ArrayList<HashMap<String, String>>();
        mCustomAdapter = new CustomAdapter<HashMap<String, String>>(this, R.layout.circle_option_item, mCirclesOptionData) {

            Holder holder;

            @Override
            public void holderInitIf(View row) {
                holder = new Holder();
                holder.circleView = (CircleView) row.findViewById(R.id.circleViewOptions);
                row.setTag(holder);
            }

            @Override
            public void holderInitElse() {
                holder = (Holder) row.getTag();
            }

            @Override
            public void setValues() {
                HashMap<String, String> hashMap = mCirclesOptionData.get(getPosition());
                holder.circleView.setText(hashMap.get("text"));
            }
        };

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("text", "Circle - 1");
        mCirclesOptionData.add(hashMap);

        hashMap = new HashMap<String, String>();
        hashMap.put("text", "Circle - 2");
        mCirclesOptionData.add(hashMap);

        hashMap = new HashMap<String, String>();
        hashMap.put("text", "Circle - 3");
        mCirclesOptionData.add(hashMap);

        mCirclesOptionAdapterFrom = new String[]{"text"};
        mCirclesOptionAdapterTo = new int[]{R.id.circleViewOptions};

        mCirclesOptionAdapter = new SimpleAdapter(this, mCirclesOptionData, R.layout.circle_option_item, mCirclesOptionAdapterFrom, mCirclesOptionAdapterTo);

    }

    void initAdapter(){
        mCirclesOptionView.setAdapter(mCustomAdapter);
    }

    public class Holder {
        CircleView circleView;
    }
}

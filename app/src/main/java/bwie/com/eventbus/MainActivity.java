package bwie.com.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static bwie.com.eventbus.R.id.tv;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * btn_bty
     */
    private Button mBtnTry;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册
        EventBus.getDefault().register(this);


        initView();
    }

    private void initView() {
        mBtnTry = (Button) findViewById(R.id.btn_try);
        mBtnTry.setOnClickListener(this);
        mTv = (TextView) findViewById(tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_try:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册
        EventBus.getDefault().register(this);

    }
    @Subscribe
    public void onEventMainThread(FirstEvent event){
        String msg = "onEventMainThread收到了消息：" + event.getmMsg();
        Log.d("harvic", msg);
        mTv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}

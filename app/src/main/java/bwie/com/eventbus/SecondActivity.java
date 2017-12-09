package bwie.com.eventbus;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * First Event
     */
    private Button mBtnFirstEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

    }

    private void initView() {
        mBtnFirstEvent = (Button) findViewById(R.id.btn_first_event);
        mBtnFirstEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first_event:

                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
                break;
        }
    }
}

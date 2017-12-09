package bwie.com.eventbus;

/**
 * Created by 不将就 on 2017/12/8.
 */

public class FirstEvent {
    private String mMsg;

    public FirstEvent(String mMsg) {
        this.mMsg = mMsg;
    }

    public String getmMsg() {
        return mMsg;
    }

    public void setmMsg(String mMsg) {
        this.mMsg = mMsg;
    }
}

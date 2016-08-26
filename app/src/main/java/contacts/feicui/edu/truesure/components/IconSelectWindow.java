package contacts.feicui.edu.truesure.components;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import butterknife.ButterKnife;
import butterknife.OnClick;
import contacts.feicui.edu.truesure.R;

/**
 * 用户头像更改弹出式窗口(从相册，从相机，取消)
 */
public class IconSelectWindow extends PopupWindow{

    public interface Listener{
        void toGallery();

        void toCamera();
    }

    private final Activity activity;
    private final Listener listener;

    public IconSelectWindow(@NonNull Activity activity,@NonNull Listener listener){
        /**
         * 默认布局，宽，高
         */
        super(activity.getLayoutInflater().inflate(R.layout.window_select_icon, null),
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        this.activity = activity;
        this.listener = listener;
        ButterKnife.bind(this, getContentView());

        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }

    public void show(){
        //在底部弹出
        showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM,0,0);
    }

    @OnClick({R.id.btn_gallery, R.id.btn_camera, R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                break;
            case R.id.btn_gallery:
                listener.toGallery();
                break;
            case R.id.btn_camera:
                listener.toCamera();
                break;
        }
        dismiss();
    }
}

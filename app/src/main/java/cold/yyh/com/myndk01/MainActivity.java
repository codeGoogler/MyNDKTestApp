package cold.yyh.com.myndk01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 我的ndk项目实战：
 （hellWord，及其监听SD卡）
 */
public class MainActivity extends AppCompatActivity {
    private Button  btn_onclick,btn_onclick2;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) this.findViewById(R.id.test);
        btn_onclick = (Button) this.findViewById(R.id.btn_onclick);
        final NdkJniUtils jni = new NdkJniUtils();
        btn_onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mTextView.setText(jni.getCLanguageString());

            }
        });
       findViewById(R.id.btn_onclick2).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              jni.uninstallListener();
               mTextView.setText("监听SD卡状态，查log日志");
           }
       });
    }
}

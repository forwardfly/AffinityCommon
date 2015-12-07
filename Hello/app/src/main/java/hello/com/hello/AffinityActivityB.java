package hello.com.hello;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kongfei on 12/3/15.
 */
public class AffinityActivityB extends Activity {

    private TextView tvInfo;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.content_affinity_a);

        this.setTitle("AffinityActivityB");

        tvInfo = (TextView) this.findViewById(R.id.tv_info);
        btnStart = (Button) this.findViewById(R.id.btn_start);

        tvInfo.setText("AffinityActivityB:" + getTaskId());

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent("action.ttt.affinity.c");
                AffinityActivityB.this.startActivity(startIntent);

//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                ComponentName cn = new ComponentName("com.helloaffinity", "com.helloaffinity.MainActivity");
//                intent.setComponent(cn);
//                startActivity(intent);

            }
        });


    }
}

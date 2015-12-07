package hello.com.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kongfei on 12/3/15.
 */
public class AffinityActivityA extends Activity {

    private TextView tvInfo;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.content_affinity_a);

        this.setTitle("AffinityActivityA");

        tvInfo = (TextView) this.findViewById(R.id.tv_info);
        btnStart = (Button) this.findViewById(R.id.btn_start);

        tvInfo.setText("AffinityActivityA:" + getTaskId());

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent("android.intent.action.APP_A_SECOND_ACTIVITY");
                AffinityActivityA.this.startActivity(startIntent);

//                Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT

            }
        });



    }
}

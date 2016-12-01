package io.yale.rxfields;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static io.yale.tinyuikit.lib.ViewExtension.v_findView;
import static io.yale.tinyuikit.lib.ViewExtension.v_setClickListener;
import static io.yale.tinyuikit.lib.ViewExtension.v_setText;

/**
 * Created by yalez on 2016/11/30.
 */

public class MainActivity extends AppCompatActivity {
    PageVM vm = new PageVM();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        final TextView countLabel = v_findView(this, R.id.label_count);
    }

    private static class PageVM {
    }
}

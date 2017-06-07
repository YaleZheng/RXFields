package io.yale.rxfields;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import io.yale.rxfields.lib.RxInt;

import static io.yale.tinyuikit.lib.ViewExtension.v_findView;
import static io.yale.tinyuikit.lib.ViewExtension.v_setClickListener;
import static io.yale.tinyuikit.lib.ViewExtension.v_setText;

/**
 * Created by yalez on 2016/11/30.
 */

@SuppressWarnings("Convert2MethodRef")
public class MainActivity extends AppCompatActivity {
    PageVM vm = new PageVM();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        initContentView();

        Button increaseBtn = v_findView(this, R.id.btn_increase);
        v_setClickListener(increaseBtn, v -> {
            vm.num.add(1);
        });

        Button decreaseBtn = v_findView(this, R.id.btn_increase);
        v_setClickListener(decreaseBtn, v -> {
            vm.num.add(-1);
        });

    }

    private void initContentView() {
        TextView countLabel = v_findView(this, R.id.label_count);
        vm.num.ob()
                .map(num -> num.toString())
                .subscribe(text -> v_setText(countLabel, text));
        countLabel.setText(String.valueOf(vm.num));
    }

    private static class PageVM {
        private RxInt num = new RxInt(0);
    }
}

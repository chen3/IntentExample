package cn.qiditu.android.guet.intentexample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);

        fixEditTextLeftDrawable(textUsername);
        fixEditTextLeftDrawable(textPassword);

        @ColorInt
        int white = ContextCompat.getColor(this.getApplicationContext(),
                                            android.R.color.white);
        textUsername.setHintTextColor(white);
        textPassword.setHintTextColor(white);
    }

    @BindView(R.id.username)
    EditText textUsername;
    @BindView(R.id.password)
    EditText textPassword;

    @OnClick(R.id.btnAdd)
    void onBtnAddClicked() {
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("username", textUsername.getText().toString());
        intent.putExtra("password", textPassword.getText().toString());
        startActivity(intent);
    }

    private void fixEditTextLeftDrawable(@NonNull EditText editText) {
        Drawable[] drawables = editText.getCompoundDrawables();
        Drawable drawable = drawables[0];
        if(drawable == null) {
            return;
        }
        int size = (int)(textUsername.getLineHeight() * 1.5);
        drawable.setBounds(0, 0, size, size);
        editText.setCompoundDrawables(drawable, drawables[1], drawables[2], drawables[3]);
    }

}

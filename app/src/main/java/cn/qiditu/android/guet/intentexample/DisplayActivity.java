package cn.qiditu.android.guet.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextView textUsername;
    @BindView(R.id.password)
    TextView textPassword;

    @BindString(R.string.username_display)
    String usernamePrefix;
    @BindString(R.string.password_display)
    String passwordPrefix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        textUsername.setText(String.format(usernamePrefix,
                                            intent.getStringExtra("username")));
        textPassword.setText(String.format(passwordPrefix,
                                            intent.getStringExtra("password")));
    }
}

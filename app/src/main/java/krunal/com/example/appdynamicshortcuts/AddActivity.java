package krunal.com.example.appdynamicshortcuts;

import android.annotation.TargetApi;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class AddActivity extends AppCompatActivity {

    private Button button;

    @TargetApi(Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        button = findViewById(R.id.button);

        final ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(AddActivity.this, "Add_shortcut_id")
                        .setShortLabel("Changed")
                        .build();

                shortcutManager.updateShortcuts(Arrays.asList(dynamicShortcut));
            }
        });
    }
}

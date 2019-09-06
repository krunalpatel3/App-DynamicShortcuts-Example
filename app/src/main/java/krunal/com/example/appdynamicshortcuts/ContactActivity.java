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

public class ContactActivity extends AppCompatActivity {

    private Button button;

    @TargetApi(Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        button = findViewById(R.id.button2);

        final ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ShortcutInfo thirdShortcut = new ShortcutInfo.Builder(ContactActivity.this, "Add_shortcut_id")
                        .setRank(2)
                        .build();

                ShortcutInfo fourthShortcut = new ShortcutInfo.Builder(ContactActivity.this, "Contact_shortcut_id")
                        .setRank(1)
                        .build();

                shortcutManager.updateShortcuts(Arrays.asList(thirdShortcut,fourthShortcut));
            }
        });
    }
}

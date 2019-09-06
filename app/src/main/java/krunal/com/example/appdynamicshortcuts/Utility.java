package krunal.com.example.appdynamicshortcuts;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

public class Utility {

    private static final String Add_SHORTCUT_ID = "Add_shortcut_id";
    private static final List<String> SHORTCUT_IDS1 = Arrays.asList(Add_SHORTCUT_ID);

    private static final String Contact_SHORTCUT_ID = "Contact_shortcut_id";
    private static final List<String> SHORTCUT_IDS2 = Arrays.asList(Contact_SHORTCUT_ID);


    @TargetApi(Build.VERSION_CODES.N_MR1)
    public static void CreateAddShortcut(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return;
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);

        Intent newTaskIntent = new Intent(context, AddActivity.class);
        newTaskIntent.setAction(Intent.ACTION_VIEW);
        newTaskIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ShortcutInfo postShortcut
                = new ShortcutInfo.Builder(context, Add_SHORTCUT_ID)
                .setShortLabel(context.getString(R.string.add_shortcut_short_label))
                .setLongLabel(context.getString(R.string.add_shortcut_long_label))
                .setIcon(Icon.createWithResource(context, R.drawable.ic_add))
                .setIntent(newTaskIntent)
                .build();
        shortcutManager.addDynamicShortcuts(Arrays.asList(postShortcut));
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    public static void disableAddShortcut(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return;
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        shortcutManager.disableShortcuts(SHORTCUT_IDS1);
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    public static void CreateContactShortcut(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return;
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);

        Intent newTaskIntent = new Intent(context, ContactActivity.class);
        newTaskIntent.setAction(Intent.ACTION_VIEW);
        newTaskIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ShortcutInfo postShortcut
                = new ShortcutInfo.Builder(context, Contact_SHORTCUT_ID)
                .setShortLabel(context.getString(R.string.contact_shortcut_short_label))
                .setLongLabel(context.getString(R.string.contact_shortcut_long_label))
                .setIcon(Icon.createWithResource(context, R.drawable.ic_contact))
                .setIntent(newTaskIntent)
                .build();
        shortcutManager.addDynamicShortcuts(Arrays.asList(postShortcut));
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    public static void disableContactShortcut(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return;
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
        shortcutManager.disableShortcuts(SHORTCUT_IDS2);
    }


}

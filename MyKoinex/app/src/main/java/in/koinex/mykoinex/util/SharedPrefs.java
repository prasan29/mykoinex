package in.koinex.mykoinex.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 1130665 on 11/28/2017.
 */

public class SharedPrefs {
    private static SharedPrefs sharedPrefs;
    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPreferences;

    public static SharedPrefs getInstance() {
        if (sharedPrefs == null) {
            sharedPrefs = new SharedPrefs();
            return sharedPrefs;
        } else {
            return sharedPrefs;
        }
    }

    public static boolean getNotification() {
        return sharedPreferences.getBoolean("isNotificationOn", false);
    }

    public static void setNotification(Boolean isNotificationOn) {
        editor.putBoolean("isNotificationOn", isNotificationOn);
        editor.commit();
    }

    public void initSharedPrefs(Context context) {
        if (editor == null) {
            sharedPreferences = context.getApplicationContext().getSharedPreferences("koinex_pref", 0);
            editor = sharedPreferences.edit();
        }
    }
}

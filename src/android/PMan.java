package org.iwanjunaid.pman;

import android.content.*;
import android.net.*;
import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class PMan extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        JSONObject argObject = data.getJSONObject(0);

        try {
            if (action.equals("uninstall")) {
                Context context = cordova.getActivity().getApplicationContext();
                Intent intent = new Intent(Intent.ACTION_DELETE);
                intent.setData(Uri.parse("package:" + argObject.getString("packageName")));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                callbackContext.success();

                return true;
            }
            else
                return false;
        }
        catch(Exception e) {
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}



package org.apache.cordova.openblank;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import android.annotation.SuppressLint;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;


@SuppressLint("SetJavaScriptEnabled")
public class OpenBlank extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
    	Log.d("OpenBlank", "OpenBlank execute called with action " + action);

    	return true;
	}

    @Override
	   public Boolean shouldOpenExternalUrl(String url) {
	   		Log.d("OpenBlank", "OpenBlank Plugin called with URL " + url);
	   		if(url.indexOf("utm_content") > -1) {
	   			return true;
	   		}

	        return null;
	    }
}
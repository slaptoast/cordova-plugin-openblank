

package org.apache.cordova.openblank;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
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

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

		Log.d("OpenBlank", "initialized");        
    }

    @Override
	   public Boolean shouldOpenExternalUrl(String url) {
	   		Log.d("OpenBlank", "shouldOpenExternalUrl called with URL " + url);
	   		// if(url.indexOf("utm_content") > -1) {
	   		// 	return true;
	   		// }

	        return null;
	    }

	@Override
    public Boolean shouldAllowNavigation(String url) {
   		Log.d("OpenBlank", "shouldAllowNavigation called with URL " + url);
	    
        return null;
    }

    @Override
    public boolean onOverrideUrlLoading(String url) {
    	Log.d("OpenBlank", "onOverrideUrlLoading called with URL " + url);
        return false;
    }


}
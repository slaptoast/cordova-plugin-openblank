

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

import android.util.Log;

@SuppressLint("SetJavaScriptEnabled")
public class OpenBlank extends CordovaPlugin {
    @Override
	   public Boolean shouldOpenExternalUrl(String url) {
	   		Log.d("OpenBlank Plugin called with URL " + url);
	   		if(url.indexOf("utm_content") > -1) {
	   			return true;
	   		}

	        return null;
	    }
}
package org.apache.cordova.openblank;

@SuppressLint("SetJavaScriptEnabled")
public class OpenBlank extends CordovaPlugin {
    @Override
	   public Boolean shouldOpenExternalUrl(String url) {
	   		if(url.indexOf("utm_content") > -1) {
	   			return true;
	   		}

	        return null;
	    }
}
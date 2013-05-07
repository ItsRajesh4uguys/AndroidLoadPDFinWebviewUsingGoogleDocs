package org.example.webviewdemo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewDemo extends Activity {
		
	
	private WebView webView;


    Activity activity ;
    private ProgressDialog progDailog; 
   
	@SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        activity = this;
       
        progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
		progDailog.setCancelable(false);
     
        
        
       webView = (WebView) findViewById(R.id.webview_compontent);
       
        
     
       webView.getSettings().setJavaScriptEnabled(true);     
       webView.getSettings().setLoadWithOverviewMode(true);
       webView.getSettings().setUseWideViewPort(true);        
        webView.setWebViewClient(new WebViewClient(){
        	
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        	progDailog.show();
	            view.loadUrl(url);
	         
	            return true;                
	        }
	        @Override
	        public void onPageFinished(WebView view, final String url) {
	        	progDailog.dismiss();
	        }
	    });
        
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url=http://178.239.16.28/fzs/sites/default/files/dokumenti-vijesti/sample.pdf");
        
	}
    
    
}

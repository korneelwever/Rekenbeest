package nl.korneel.tafelbeest;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.Window;
import android.view.WindowManager;
public class MainActivity extends Activity {
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setStatusBarColor(0xFF101827);
    getWindow().setNavigationBarColor(0xFF101827);
    WebView web = new WebView(this);
    web.setBackgroundColor(0xFF101827);
    WebSettings settings = web.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setDomStorageEnabled(true);
    settings.setAllowFileAccess(true);
    settings.setAllowContentAccess(true);
    web.setWebViewClient(new WebViewClient());
    setContentView(web);
    web.loadUrl("file:///android_asset/index.html");
  }
}
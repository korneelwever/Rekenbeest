package nl.korneel.tafelbeest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Window window = getWindow();
    window.setStatusBarColor(0xFF101827);
    window.setNavigationBarColor(0xFF101827);
    if (Build.VERSION.SDK_INT >= 29) window.setNavigationBarContrastEnforced(false);
    if (Build.VERSION.SDK_INT >= 30) window.setDecorFitsSystemWindows(false);

    WebView web = new WebView(this);
    web.setBackgroundColor(0xFF101827);
    web.setOnApplyWindowInsetsListener((view, insets) -> {
      int top;
      int bottom;
      if (Build.VERSION.SDK_INT >= 30) {
        android.graphics.Insets bars = insets.getInsets(
          WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars()
            | WindowInsets.Type.displayCutout()
        );
        top = bars.top;
        bottom = bars.bottom;
      } else {
        top = insets.getSystemWindowInsetTop();
        bottom = insets.getSystemWindowInsetBottom();
      }
      view.setPadding(0, top, 0, bottom);
      return insets;
    });
    WebSettings settings = web.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setDomStorageEnabled(true);
    settings.setAllowFileAccess(true);
    settings.setAllowContentAccess(true);
    web.setWebViewClient(new WebViewClient());
    setContentView(web);
    web.requestApplyInsets();
    web.loadUrl("file:///android_asset/index.html");
  }
}
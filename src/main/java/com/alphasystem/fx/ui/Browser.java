package com.alphasystem.fx.ui;

import com.alphasystem.fx.ui.util.UiUtilities;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author sali
 */
public class Browser extends BorderPane {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser() {
        webEngine.setJavaScriptEnabled(true);
        setCenter(UiUtilities.wrapInScrollPane(browser));
    }

    public void loadUrl(final String url) {
        if (isBlank(url)) {
            return;
        }
        webEngine.load(url);
    }

    public void loadUrl(final URL url) {
        if (url == null) {
            return;
        }
        loadUrl(url.toString());
    }

    public void loadUrl(final File file) {
        if (file == null) {
            return;
        }
        try {
            loadUrl(file.toURI().toURL());
        } catch (MalformedURLException e) {
            System.err.println(format("%s: %s", e.getClass().getName(), e.getMessage()));
        }
    }

    public void loadContent(final String content) {
        webEngine.loadContent(content);
    }

    public WebEngine getWebEngine() {
        return webEngine;
    }
}

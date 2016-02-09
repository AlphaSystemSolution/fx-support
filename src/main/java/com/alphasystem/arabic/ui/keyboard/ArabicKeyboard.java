package com.alphasystem.arabic.ui.keyboard;

import com.alphasystem.arabic.ui.keyboard.skin.ArabicKeyboardSkin;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import static com.alphasystem.util.AppUtil.getResource;

/**
 * @author sali
 */
public class ArabicKeyboard extends Control {

    private final StringProperty unicodeValue = new SimpleStringProperty(null, "unicodeValue");
    private final StringProperty htmlCodeValue = new SimpleStringProperty(null, "htmlCodeValue");
    private final BooleanProperty clearText = new SimpleBooleanProperty(null, "clearText");

    public ArabicKeyboard() {
        setSkin(createDefaultSkin());
        setPrefSize(800, 600);
        getStyleClass().add("popup");
        clearText.addListener((o, ov, nv) -> {
            if(!nv){
                return;
            }
            ((ArabicKeyboardSkin)getSkin()).clearText();
            // send another event
            clearText.set(false);
        });
    }

    @Override
    public String getUserAgentStylesheet() {
        return getResource("arabic-ui-support.css").toExternalForm();
    }

    public KeyboardView getKeyboard() {
        return ((ArabicKeyboardSkin) getSkin()).getKeyboard();
    }

    public final String getUnicodeValue() {
        return unicodeValue.get();
    }

    public final void setUnicodeValue(String unicodeValue) {
        this.unicodeValue.set(unicodeValue);
    }

    public final StringProperty unicodeValueProperty() {
        return unicodeValue;
    }

    public final String getHtmlCodeValue() {
        return htmlCodeValue.get();
    }

    public final void setHtmlCodeValue(String htmlCodeValue) {
        this.htmlCodeValue.set(htmlCodeValue);
    }

    public final StringProperty htmlCodeValueProperty() {
        return htmlCodeValue;
    }

    public final void setClearText(boolean clearText) {
        this.clearText.set(clearText);
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ArabicKeyboardSkin(this);
    }
}

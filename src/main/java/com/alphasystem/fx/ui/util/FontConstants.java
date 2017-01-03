package com.alphasystem.fx.ui.util;

import javafx.scene.text.Font;

import static java.lang.System.getProperty;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.FontPosture.ITALIC;
import static javafx.scene.text.FontPosture.REGULAR;
import static javafx.scene.text.FontWeight.BLACK;

/**
 * @author sali
 */
public interface FontConstants {

    String ARABIC_FONT_NAME_KEY = "arabic.font.name";
    String ENGLISH_FONT_NAME_KEY = "english.font.name";
    String ARABIC_NORMAL_FONT_SIZE_KEY = "arabic.normal.font.size";
    String ARABIC_HEADING_FONT_SIZE_KEY = "arabic.heading.font.size";
    String ARABIC_FONT_NAME = getProperty(ARABIC_FONT_NAME_KEY, "Arabic Typesetting");
    String ENGLISH_FONT_NAME = getProperty(ENGLISH_FONT_NAME_KEY, "Candara");
    long ARABIC_NORMAL_FONT_SIZE = Long.getLong(ARABIC_NORMAL_FONT_SIZE_KEY, 32);
    long ARABIC_HEADING_FONT_SIZE = Long.getLong(ARABIC_HEADING_FONT_SIZE_KEY, 72);

    // Arabic Fonts
    Font ARABIC_NORMAL_FONT = font(ARABIC_FONT_NAME, BLACK, REGULAR, ARABIC_NORMAL_FONT_SIZE);
    Font ARABIC_HEADING_FONT = font(ARABIC_FONT_NAME, BLACK, REGULAR, ARABIC_HEADING_FONT_SIZE);
    Font ARABIC_FONT_48 = font(ARABIC_FONT_NAME, BLACK, REGULAR, 48.0);
    Font ARABIC_FONT_36 = font(ARABIC_FONT_NAME, BLACK, REGULAR, 36.0);
    Font ARABIC_FONT_30 = font(ARABIC_FONT_NAME, BLACK, REGULAR, 30);
    Font ARABIC_FONT_26 = font(ARABIC_FONT_NAME, BLACK, REGULAR, 26);
    Font ARABIC_FONT_24 = font(ARABIC_FONT_NAME, BLACK, REGULAR, 24);
    Font ARABIC_FONT_20 = font(ARABIC_FONT_NAME, BLACK, REGULAR, 20);
    Font ARABIC_FONT_14 = font(ARABIC_FONT_NAME, BLACK, REGULAR, 14);

    // English Fonts
    Font ENGLISH_FONT_14 = font(ENGLISH_FONT_NAME, BLACK, REGULAR, 14);
    Font ENGLISH_FONT_12 = font(ENGLISH_FONT_NAME, BLACK, REGULAR, 12);
    Font ENGLISH_FONT_ITALIC_12 = font(ENGLISH_FONT_NAME, BLACK, ITALIC, 12);
}

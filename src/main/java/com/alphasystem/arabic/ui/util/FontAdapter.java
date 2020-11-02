package com.alphasystem.arabic.ui.util;

import com.alphasystem.util.GenericPreferences;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.apache.commons.lang3.StringUtils;

/**
 * This class is an adapter between {@link UIUserPreferences} and {@link FontUtilities} to font properties.
 */
public final class FontAdapter {

    private static final FontAdapter instance;

    static {
        UIUserPreferences preferences = null;
        try {
            preferences = GenericPreferences.getInstance(UIUserPreferences.class);
        } catch (RuntimeException ex) {
            // ignore
            System.err.println("user preferences are not defined.");
        }
        instance = new FontAdapter(preferences);
    }

    private String arabicFontName;
    private String englishFontName;
    private long arabicFontSize;
    private long englishFontSize;
    private long arabicHeadingFontSize;

    public FontAdapter() {
        this(null);
    }

    public static FontAdapter getInstance() {
        return instance;
    }

    public FontAdapter(final UIUserPreferences userPreferences) {
        arabicFontName = userPreferences == null ? FontUtilities.defaultArabicFontName :
                userPreferences.getArabicFontName();
        englishFontName = userPreferences == null ? FontUtilities.defaultEnglishFontName :
                userPreferences.getEnglishFontName();
        arabicFontSize = userPreferences == null ? FontUtilities.defaultArabicRegularFontSize :
                userPreferences.getArabicFontSize();
        englishFontSize = userPreferences == null ? FontUtilities.defaultEnglishFontSize :
                userPreferences.getEnglishFontSize();
        arabicHeadingFontSize = userPreferences == null ? FontUtilities.defaultArabicHeadingFontSize :
                userPreferences.getArabicHeadingFontSize();
    }

    public String getArabicFontName() {
        return arabicFontName;
    }

    public void setArabicFontName(String arabicFontName) {
        if (StringUtils.isNotBlank(arabicFontName)) {
            this.arabicFontName = arabicFontName;
        }
    }

    public String getEnglishFontName() {
        return englishFontName;
    }

    public void setEnglishFontName(String englishFontName) {
        if (StringUtils.isNotBlank(englishFontName)) {
            this.englishFontName = englishFontName;
        }
    }

    public long getArabicFontSize() {
        return arabicFontSize;
    }

    public void setArabicFontSize(long arabicFontSize) {
        this.arabicFontSize = arabicFontSize <= 0 ? FontUtilities.defaultArabicRegularFontSize : arabicFontSize;
    }

    public long getEnglishFontSize() {
        return englishFontSize;
    }

    public void setEnglishFontSize(long englishFontSize) {
        this.englishFontSize = englishFontSize <= 0 ? FontUtilities.defaultEnglishFontSize : englishFontSize;
    }

    public long getArabicHeadingFontSize() {
        return arabicHeadingFontSize;
    }

    public void setArabicHeadingFontSize(long arabicHeadingFontSize) {
        this.arabicHeadingFontSize = arabicHeadingFontSize <= 0 ? FontUtilities.defaultArabicHeadingFontSize : arabicHeadingFontSize;
    }

    public Font getArabicRegularFont() {
        return getArabicRegularFont(-1);
    }

    public Font getArabicRegularFont(long fontSize) {
        return Font.font(arabicFontName, FontWeight.BLACK, FontPosture.REGULAR, fontSize <= 0 ? arabicFontSize : fontSize);
    }
}

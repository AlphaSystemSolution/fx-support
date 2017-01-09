package com.alphasystem.fx.ui.util;

import javafx.util.StringConverter;

/**
 * @author sali
 */
public class FontSizeStringConverter extends StringConverter<Long> {

    @Override
    public String toString(Long object) {
        return (object == null) ? "" : String.valueOf(object);
    }

    @Override
    public Long fromString(String string) {
        return (string == null) ? 0 : Long.parseLong(string);
    }
}

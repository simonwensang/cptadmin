package com.cpt.common;

import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import java.beans.PropertyEditorSupport;

 
public class StringEscapeEditor extends PropertyEditorSupport {

    private boolean escapeHTML;
    private boolean escapeJavaScript;

    public StringEscapeEditor() {
        super();
    }

    public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript) {
        super();
        this.escapeHTML = escapeHTML;
        this.escapeJavaScript = escapeJavaScript;
    }

    @Override
    public String getAsText() {
        return getValue() != null ? getValue().toString() : "";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null) {
            if (escapeHTML) {
                text = HtmlUtils.htmlEscape(text);
            }
            if (escapeJavaScript) {
                text = JavaScriptUtils.javaScriptEscape(text);
            }
        }
        setValue(text);
    }

}

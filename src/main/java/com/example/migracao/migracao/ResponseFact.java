package com.example.migracao.migracao;

public class ResponseFact {
    private String id;
    private String text;
    private String source;
    private String sourceUrl;
    private String language;
    private String permalink;

    public ResponseFact() {
    }

    public ResponseFact(String id, String text, String source, String sourceUrl, String language, String permalink) {
        this.id = id;
        this.text = text;
        this.source = source;
        this.sourceUrl = sourceUrl;
        this.language = language;
        this.permalink = permalink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }
}

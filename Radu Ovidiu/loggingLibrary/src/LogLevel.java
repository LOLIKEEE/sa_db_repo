public enum LogLevel {
    INFO("[INFO]"),
    WARN("[WARN]"),
    DEBUG("[DEBUG]"),
    ERROR("[ERROR]"),
    FATAL("[FATAL]");
    private String text;

    LogLevel(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return getText();
    }
}

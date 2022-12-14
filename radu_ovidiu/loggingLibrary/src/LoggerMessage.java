public class LoggerMessage {
    private String info = "Some info message";
    private String warn = "Some warning message";
    private String debug = "Something to be 'debugged'";
    private String error = "We have some errors";
    private String fatal = "Everithing is down";
public LoggerMessage(){
    this.info = info;
    this.warn = warn;
    this.debug = debug;
    this.error = error;
    this.fatal = fatal;
    }
       public String getInfo(){
    return info;
        }

     public String getWarn() {
        return warn;
    }

    public String getDebug() {
        return debug;
    }

    public String getError() {
        return error;
    }

    public String getFatal() {
        return fatal;
    }


}

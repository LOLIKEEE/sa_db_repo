package Tables;

public class ResultStatus {
    private static int count = 0;
    private int id;
    private String status;

    public ResultStatus(){
    }

    public ResultStatus(String status){
        id = ++count;
        this.status = status;
    }
    public int getId(){
        return id;
    }
    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
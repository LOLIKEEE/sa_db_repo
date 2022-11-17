package tables;

public class RecordStatus {
    protected int recordStatusId;
    protected String recordDescription;

    public RecordStatus(int recordStatusId, String recordDescription) {
        this.recordDescription = recordDescription;
        this.recordStatusId = recordStatusId;
    }

    void setRecordStatusId(int recordStatusId) {
        this.recordStatusId = recordStatusId;
    }

    void setRecordStatusDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }

    public int getRecordStatusId() {
        return recordStatusId;
    }

    public String getRecordStatusDescription() {
        return recordDescription;
    }
}

package Tables;
public class RecordStatus {
	protected short recordStatusId;
	protected String recordDescription;
	
	public RecordStatus(short recordStatusId, String recordDescription) {
		this.recordDescription = recordDescription;
		this.recordStatusId = recordStatusId;
	}
	
	void setRecordStatusId(short recordStatusId) {
		this.recordStatusId = recordStatusId;
	}
	
	void setRecordStatusDescription(String recordDescription) {
		this.recordDescription = recordDescription;
	}
	
	public short getRecordStatusId() {
		return recordStatusId;
	}
	
	public String getRecordStatusDescription() {
		return recordDescription;
	}
}

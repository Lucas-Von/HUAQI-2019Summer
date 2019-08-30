package financial_management.vo.message;

public class NewMessageVO {
    //调仓消息是1
    //系统消息是2
    //回复提醒是3
    private int type;
    private String latest;
    private int unreadAmount;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public int getUnreadAmount() {
        return unreadAmount;
    }

    public void setUnreadAmount(int unreadAmount) {
        this.unreadAmount = unreadAmount;
    }

    public NewMessageVO() {
    }

    public NewMessageVO(int type, String latest, int unreadAmount) {
        this.type = type;
        this.latest = latest;
        this.unreadAmount = unreadAmount;
    }
}

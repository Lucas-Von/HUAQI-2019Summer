package financial_management.vo.message;

import financial_management.entity.MessagePO;

public class TransMessageVO extends MessageVO {
    private long transID;

    private boolean accepted;

    public long getTransID() {
        return transID;
    }

    public void setTransID(long transID) {
        this.transID = transID;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public TransMessageVO(MessagePO po) {
        super(po);
    }
}

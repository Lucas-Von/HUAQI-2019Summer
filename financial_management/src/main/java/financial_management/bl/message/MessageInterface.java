package financial_management.bl.message;

import financial_management.vo.BasicResponse;

public interface MessageInterface {
    @Deprecated
    BasicResponse<?> postMessageToUserBy(Long userID, String content);

    BasicResponse<?> postMessageToUserBy(Long userID, String content, MsgType msgType);

    enum MsgType{
        TRANSFER_MSG(1),
        SYSTEM_MSG(2),
        INTERACT_MSG(3);

        public int getType() {
            return type;
        }

        int type;

        MsgType(int type) {
            this.type = type;
        }
    }
}

package financial_management.bl.message;

import financial_management.vo.BasicResponse;

public interface MessageInterface {
    @Deprecated
    BasicResponse<?> postMessageToUserBy(Long userID, String content);

    BasicResponse<Long> postMessageToUserBy(Long userID, String content, MsgType msgType);

    void postTransMessage(Long userID, String content, long transID) throws RuntimeException;

    enum MsgType{
        TRANSFER_MSG(1),//调仓消息
        SYSTEM_MSG(2),//系统消息
        INTERACT_MSG(3);//暂且叫互动消息，包括文章互动和反馈答复

        public int getType() {
            return type;
        }

        int type;

        MsgType(int type) {
            this.type = type;
        }
    }
}

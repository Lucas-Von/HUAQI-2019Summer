package financial_management.bl.message;

import financial_management.vo.message.TransMessageVO;

public interface ITransferMessage {
    TransMessageVO getTransMessageInfoByID(TransMessageVO transMessageVO);
}

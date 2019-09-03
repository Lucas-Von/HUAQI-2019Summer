package financial_management.bl.product;

public interface StockService {
    void changeDomStock(Long userId);

    void changeForStock(Long userId);

    void weeklyDomTransfer(Long userId);

    void weeklyForTransfer(Long userId);

    //获取股票和股指的总额
    double getTotalStockByUser(long userID);

    double getTotalQDIIByUser(long userID);
}

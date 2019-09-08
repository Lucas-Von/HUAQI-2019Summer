package financial_management.bl.wallet;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 15:50
 * @Version 1.0
 **/
public interface FundService4Wallet {

    public void IncreaseCapital(Long userId, Double cost);

    public void DecreaseCapital(Long userId, Double cost);

    public Double checkBalance(Long userId);

    public void setPayPassword(Long userId, String password);

    public boolean checkPayPassword(Long userId,String paypassword);
}

package financial_management.entity;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/13 20:56
 * @Version 1.0
 **/
public class CardPO {
    /**
     * @Author jyh
     * @Description //卡号
     **/
    String cardnum;

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public CardPO(String cardnum) {
        this.cardnum = cardnum;
    }
    public CardPO(){

    }
}

package financial_management.vo.order;

import financial_management.bl.order.OrderService;
import financial_management.entity.PersonalTradePO;

import java.util.Date;

public class PersonalTradeVO {
    //ID，需要插入记录时请填null
    private Long ID;

    //调仓记录ID（已废弃）
    private Long transID;

    //交易时间填在这个属性里面
    private Date createTime;

    //暂时没用
    private Date completeTime;

    private OrderService.Type type;

    private ProductVO4Order product;

    //数量，买入为正，卖出为负
    private float amount;

    private float price;

    //手续费
    private float fee;

    private float total;

    private long userID;

    //暂时没用，随便填或不填
    private Integer status;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getTransID() {
        return transID;
    }

    public void setTransID(Long transID) {
        this.transID = transID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public OrderService.Type getType() {
        return type;
    }

    public void setType(OrderService.Type type) {
        this.type = type;
    }

    public ProductVO4Order getProduct() {
        return product;
    }

    public void setProduct(ProductVO4Order product) {
        this.product = product;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PersonalTradeVO() {
    }

    public PersonalTradeVO(PersonalTradePO po) {
        ID = po.getID();
        transID = po.getTransID();
        createTime = po.getCreateTime();
        completeTime = po.getCompleteTime();
        type = OrderService.Type.valueOf(po.getType().toUpperCase());
        amount = po.getAmount();
        price = po.getPrice();
        fee = po.getFee();
        total = po.getTotal();
        userID = po.getUserID();
        status = po.getStatus();
    }

}

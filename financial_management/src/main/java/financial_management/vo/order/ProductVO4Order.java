package financial_management.vo.order;

public class ProductVO4Order {
    private Long pID;
    private String name;
    private String code;

    public Long getpID() {
        return pID;
    }

    public void setpID(Long pID) {
        this.pID = pID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProductVO4Order(Long pID, String name, String code) {
        this.pID = pID;
        this.name = name;
        this.code = code;
    }

    public ProductVO4Order() {
    }
}

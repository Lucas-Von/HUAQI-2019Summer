package financial_management.util.PyInvoke.PyParam;

public class PyParamDemo extends PyParam{
    private int id;
    private String str;

    public PyParamDemo() {
    }

    public PyParamDemo(int id, String str) {
        this.id = id;
        this.str = str;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

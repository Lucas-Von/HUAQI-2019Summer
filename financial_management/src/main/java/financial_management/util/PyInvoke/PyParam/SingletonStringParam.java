package financial_management.util.PyInvoke.PyParam;

public class SingletonStringParam extends PyParam {
    private String q;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public SingletonStringParam(String q) {
        this.q = q;
    }
}

package financial_management.vo;

import java.util.ArrayList;

public class PropertyVO {

    /**
     * 用户资产列表
     */
    private ArrayList<Integer> assets;

    /**
     * 用户投资偏好
     */
    private String prefers;

    public PropertyVO() {
    }

    public PropertyVO(ArrayList<Integer> assets, String prefers) {
        this.assets = assets;
        this.prefers = prefers;
    }

}
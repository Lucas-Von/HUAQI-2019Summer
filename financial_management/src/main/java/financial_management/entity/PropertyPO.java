package financial_management.entity;

import java.util.ArrayList;

/**
 * @author lt
 * @date 2019/08/13 14:25
 */
public class PropertyPO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 管理员id
     */
    private Long adminId;

    /**
     * 用户请求查看的方式：最近30天【按天返回数据】 or 自注册起所有月份【按月返回数据】
     */
    private String viewType;

    /**
     * 用户请求查看的类型：资产 or 投资
     */
    private String proOrInvest;

    /**
     * 用户请求查看的资产信息的类型
     */
    private String assetType;

    /**
     * 用户投资偏好
     */
    private ArrayList<String> prefers;

    public Long getUsrId() {
        return userId;
    }

    public void setUsrId(long userId) {
        this.userId = userId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getProOrInvest() {
        return proOrInvest;
    }

    public void setProOrInvest(String proOrInvest) {
        this.proOrInvest = proOrInvest;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public ArrayList<String> getPrefers() {
        return prefers;
    }

    public void setPrefers(ArrayList<String> prefers) {
        this.prefers = prefers;
    }

}

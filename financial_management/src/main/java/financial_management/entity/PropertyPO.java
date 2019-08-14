package financial_management.entity;

import financial_management.vo.PropertyVO;

import java.util.ArrayList;

public class PropertyPO {

    /**
     * 用户id
     */
    private long usrId;

    /**
     * 管理员id
     */
    private long adminId;

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
     * 用户资产列表
     */
    private ArrayList<Integer> assets;

    /**
     * 用户投资偏好
     */
    private ArrayList<String> prefers;

    /**
     * 用户填写的问卷信息
     */
    public PropertyVO getPropertyVO() {
        return new PropertyVO(assets, prefers);
    }

    public long getUsrId() {
        return usrId;
    }

    public void setUsrId(long usrId) {
        this.usrId = usrId;
    }

    public long getAdminId() {
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

    public ArrayList<Integer> getAssets() {
        return assets;
    }

    public void setAssets(ArrayList<Integer> assets) {
        this.assets = assets;
    }

    public ArrayList<String> getPrefers() {
        return prefers;
    }

    public void setPrefers(ArrayList<String> prefers) {
        this.prefers = prefers;
    }

}

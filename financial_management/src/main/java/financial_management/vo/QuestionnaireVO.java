package financial_management.vo;

import java.util.List;

/**
 * @author lt
 * @date 2019/08/17 17:00
 */
public class QuestionnaireVO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 资产
     */
    private AssetsVO assetsVO;

    /**
     * 投资偏好
     */
    private List<PreferVO> preferList;

    public QuestionnaireVO() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AssetsVO getAssetsVO() {
        return assetsVO;
    }

    public void setAssetsVO(AssetsVO assetsVO) {
        this.assetsVO = assetsVO;
    }

    public List<PreferVO> getPreferList() {
        return preferList;
    }

    public void setPreferList(List<PreferVO> preferList) {
        this.preferList = preferList;
    }

}

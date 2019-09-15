package financial_management.util.PyInvoke;

import financial_management.entity.fund.InfoParam;
import financial_management.entity.fund.InfoResponse;
import financial_management.entity.insurance.RecommandInsuranceParam;
import financial_management.entity.insurance.RecommandInsuranceResponse;
import financial_management.entity.insurance.RecommandWrapperResponse;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.AssetConfigParam;
import financial_management.util.PyInvoke.PyResponse.questionnaire.AssetConfigResponse;
import financial_management.util.PyInvoke.PyParam.PyParamDemo;
import financial_management.util.PyInvoke.PyParam.bond.*;
import financial_management.util.PyInvoke.PyParam.stock.QDII_UniversalParam;
import financial_management.util.PyInvoke.PyResponse.stock.QDIIAdjustment;

import java.util.ArrayList;
import java.util.List;

public class PyInvokeDemo {
    public static void main(String[] args) {
/**
        List<Float> liest = new ArrayList<>();
        liest.add(0.03F);
        liest.add(0.02F);
        liest.add(0.033F);
//        PyParam pyParam = new AdjuestmentVO(0.75F,0.25F,20000F,3000f,4000f,liest,1000F);
//        PyParam pyParam = new First_PurchaseVO(0.03F, 0.033F, 0.02F, 43020F, 2000F, 2000F, liest,3333F);

//        List<Float> liest = new ArrayList<>();
//        liest.add(0.03F);
//        liest.add(0.02F);
//        liest.add(0.033F);
//        PyParam pyParam = new First_PurchaseVO(0.9F, 0.09F, 0.09F, 43020F, 2000F, 2000F, liest,3333F);
//        List<BondsInfo> infos = new ArrayList<>();
//        BondsInfo info = new BondsInfo("债券1","111111",0.4F,10000F,14);
//        infos.add(info);
//        info = new BondsInfo("债券2","222222",0.35F,30000F,16);
//        infos.add(info);
//        info = new BondsInfo("债券3","333333",0.25F,20000F,11);
//        infos.add(info);
//        List<BondsInfo> infos2 = new ArrayList<>();
//        info = new BondsInfo("债券4","444444",0.4F,30000F,13);
//        infos2.add(info);
//        info = new BondsInfo("债券5","555555",0.6F,30000F,11);
//        infos2.add(info);
//        List<NewFundInfo> new_fund_info = new ArrayList<>();
//        NewFundInfo fundInfo = new NewFundInfo();
//        fundInfo.setProduct("national");
//        fundInfo.setCode("777777");
//        fundInfo.setProportion(0.6F);
//        fundInfo.setProduct("national");
//        fundInfo.setCode("888888");
//        fundInfo.setProportion(0.4F);
//        new_fund_info.add(fundInfo);
//        PyParam pyParam = new IndexVO("国债",3000F,120000F,infos,infos2,60000F,60000F,new_fund_info);
        PyParam pyParam = new AssetConfigParam(-1, 2);
        List<Object> invokeResult = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_ASSET_ALLOCATION, pyParam, AssetConfigResponse.class);
        List<AssetConfigResponse> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((AssetConfigResponse) object);
            list.add((QDIIAdjustment) object);
        }
        System.out.println(list.size());
 */
    }
}


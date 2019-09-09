
package financial_management.util.PyInvoke;

import financial_management.util.PyInvoke.PyParam.GoldConfigParam;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyParam.PyParamDemo;
import financial_management.util.PyInvoke.PyParam.bond.*;
import financial_management.util.PyInvoke.PyParam.questionnaire.AssetConfigParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.MLearningConfigParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.VulnerabilityConfigParam;
import financial_management.util.PyInvoke.PyResponse.GoldConfigResponse;
import financial_management.util.PyInvoke.PyResponse.PyResponseDemo;
import financial_management.util.PyInvoke.PyResponse.questionnaire.AssetConfigResponse;
import financial_management.util.PyInvoke.PyResponse.questionnaire.MLearningConfigResponse;
import financial_management.util.PyInvoke.PyResponse.questionnaire.VulnerabilityConfigResponse;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PyInvokeDemo {
    public static void main(String[] args) {

        PyParam pyParam = new AssetConfigParam(-1, 1);
        List<Object> invokeResult = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_ASSET_ALLOCATION, pyParam, AssetConfigResponse.class);
        List<AssetConfigResponse> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((AssetConfigResponse) object);
        }
        System.out.println(list.size());
    }
}

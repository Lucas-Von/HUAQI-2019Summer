
package financial_management.util.PyInvoke;

import financial_management.util.PyInvoke.PyParam.GoldConfigParam;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyParam.PyParamDemo;
import financial_management.util.PyInvoke.PyResponse.GoldConfigResponse;
import financial_management.util.PyInvoke.PyResponse.PyResponseDemo;

import java.util.ArrayList;
import java.util.List;

public class PyInvokeDemo {
    public static void main(String[] args) {

        PyParam pyParam = new GoldConfigParam(100,1.2,10000);
        List<Object> invokeResult = PyInvoke.invoke(PyFunc.GOLD_INVEST, pyParam, GoldConfigResponse.class);
        List<GoldConfigResponse> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((GoldConfigResponse) object);
        }
        System.out.println(list.size());
        for (GoldConfigResponse response : list){
            System.out.println(response.getAccounet_all_deployed());
        }
    }
}

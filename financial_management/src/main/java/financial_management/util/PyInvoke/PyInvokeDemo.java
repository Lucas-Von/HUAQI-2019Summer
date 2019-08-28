package financial_management.util.PyInvoke;

import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyParam.PyParamDemo;
import financial_management.util.PyInvoke.PyResponse.PyResponseDemo;

import java.util.ArrayList;
import java.util.List;

public class PyInvokeDemo {
    public static void main(String[] args) {
        PyParam pyParam = new PyParamDemo(100, "ASD");
        List<Object> invokeResult = PyInvoke.invoke(PyFunc.FUN_1, pyParam, PyResponseDemo.class);
        List<PyResponseDemo> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((PyResponseDemo) object);
        }
        for (PyResponseDemo response : list){
            System.out.println(response.getId() + "   " + response.getStr());
        }
    }
}
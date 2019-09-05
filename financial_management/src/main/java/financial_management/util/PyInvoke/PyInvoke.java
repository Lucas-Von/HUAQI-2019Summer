package financial_management.util.PyInvoke;

import com.alibaba.fastjson.JSON;
import financial_management.util.PyInvoke.PyParam.PyParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PyInvoke {

    private static final String invokeCmd = "python";

    /**
     *
     * @param func      需要调用的python函数
     * @param param     入参
     * @param clazz     出参的类型
     * @return
     */

    public static List<Object> invoke(PyFunc func, PyParam param, Class clazz){
        String path = func.path;
        StringBuffer cmd = new StringBuffer();
        cmd.append(invokeCmd + " ");
        cmd.append(path + " ");
        String rawString = JSON.toJSONString(param);
//        处理双引号转义
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < rawString.length(); i ++){
            if (rawString.charAt(i) == '\"'){
                stringBuffer.append("\"\"\"");
            }
            else {
                stringBuffer.append(rawString.charAt(i));
            }
        }
        cmd.append(stringBuffer.toString());
        System.out.println(cmd.toString());
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("pip list");
            List<Object> res = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String input = null;
            while ((input = reader.readLine()) != null){
//                res.add(JSON.parseObject(input, clazz));
                System.out.println(input);
            }
            return res;
        } catch (IOException e) {
            return null;
        }
    }

}

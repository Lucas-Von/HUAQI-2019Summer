package financial_management.util.PyInvoke;

import com.alibaba.fastjson.JSON;
import financial_management.configuration.PyInvokeProperties;
import financial_management.util.PyInvoke.PyParam.PyParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class PyInvoke {

    private static PyInvokeProperties pyInvokeProperties;

    private static final String invokeCmd = "python";

    @Autowired
    public PyInvoke(PyInvokeProperties pyInvokeProperties) {
        PyInvoke.pyInvokeProperties = pyInvokeProperties;
    }


    /**
     * @param func  需要调用的python函数
     * @param param 入参
     * @param clazz 出参的类型
     * @return
     */

    public static List<Object> invoke(PyFunc func, PyParam param, Class clazz) {
        String path = func.path;
        StringBuffer cmd = new StringBuffer();
        cmd.append(invokeCmd + " ");

        //文件路径的最终形成在这里
        cmd.append(pyInvokeProperties.getDir() + path + " ");
        String rawString = JSON.toJSONString(param);
//        处理双引号转义
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < rawString.length(); i++) {
            if (rawString.charAt(i) == '\"') {
                stringBuffer.append("\"\"\"");
            } else {
                stringBuffer.append(rawString.charAt(i));
            }
        }
        cmd.append(stringBuffer.toString());
        System.out.println(cmd.toString());
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(cmd.toString());
            List<Object> res = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String input = null;
            while ((input = reader.readLine()) != null) {
                System.out.println(input);
                if (input.startsWith("[")) {
                    res = JSON.parseArray(input, clazz);
                } else {
                    res.add(JSON.parseObject(input, clazz));
                }
            }
            return res;
        } catch (IOException e) {
            return null;
        }
    }


}

package financial_management.runner;

import financial_management.data.product.DepositMapper;
import financial_management.entity.OverseasBondRecommendPO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author xyh
 * @date 2019/9/8
 */
@Component
public class OverseasBondRecommendRunner implements ApplicationRunner {
    @Autowired
    private DepositMapper depositMapper;

    @Override
    public void run(ApplicationArguments args) {
        if(depositMapper.selectDepositRecommendByRiskRating(1).size() == 0) {
            String s = System.getProperty("file.separator");
            File file = new File("src" + s + "main" + s + "java" + s + "financial_management" + s + "整合债券表.xlsx");
            Workbook workbook = null;
            try {
                InputStream inputStream = new FileInputStream(file);
                workbook = new XSSFWorkbook(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 1; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                String[] temp = new String[14];

                for (int index = 0; index < 14; index++) {
                    try {
                        row.getCell(index).setCellType(CellType.STRING);
                        temp[index] = row.getCell(index).getStringCellValue();
                    } catch (Exception e) {
                        temp[index] = "";
                    }
                }
                String code = temp[0];
                String rate = temp[1];
                String endTime = temp[2];
                String redemption = temp[3];
                String bondType = temp[4];
                String currency = temp[5];
                String mechanism = temp[6];
                String frequency = temp[7];
                String rating = temp[8];
                String assetsType = temp[9];
                String subscriptionRate = temp[10];
                String earlyRedemptionFee = temp[11];
                String serviceFee = temp[12];
                Integer riskRating = Integer.valueOf(temp[13]);
                OverseasBondRecommendPO overseasBondRecommendPO = new OverseasBondRecommendPO(code,
                        rate,
                        endTime,
                        redemption,
                        bondType,
                        currency,
                        mechanism,
                        frequency,
                        rating,
                        assetsType,
                        subscriptionRate,
                        earlyRedemptionFee,
                        serviceFee,
                        riskRating);
                depositMapper.insertDepositRecommend(overseasBondRecommendPO);
            }
        }
    }
}

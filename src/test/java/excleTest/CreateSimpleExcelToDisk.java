package excleTest;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
public class CreateSimpleExcelToDisk {

    private static List<Member> getMember()throws Exception{
        List<Member> memberList = new ArrayList<>();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");
        Member user1 = new Member(1,"熊大",24,sm.parse("1993-08-28"));
        Member user2 = new Member(1,"熊二",24,sm.parse("1993-08-19"));
        Member user3 = new Member(1,"熊三",24,sm.parse("1993-08-20"));
        memberList.add(user1);
        memberList.add(user2);
        memberList.add(user3);
        return memberList;
    }

    public static void main(String [] args){
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("学生表一");
        HSSFRow row = sheet.createRow((int)0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell((short)2);
        cell.setCellValue("年龄");
        cell.setCellStyle(style);
        cell = row.createCell((short)3);
        cell.setCellValue("生日");
        cell.setCellStyle(style);

        List list = new ArrayList<>();
        try {
              list = CreateSimpleExcelToDisk.getMember();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            Member stu = (Member) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue((double) stu.getCode());
            row.createCell((short) 1).setCellValue(stu.getName());
            row.createCell((short) 2).setCellValue((double) stu.getAge());
            cell = row.createCell((short) 3);
            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu
                    .getBirth()));
        }
        // 第六步，将文件存到指定位置
        try
        {
            FileOutputStream fout = new FileOutputStream("E:/Members.xls");
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }













    }



}

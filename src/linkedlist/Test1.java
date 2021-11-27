package linkedlist;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/4/29 13:08
 */
public class Test1 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("2019-12-31 用yyyy格式化的结果:" + format1.format(calendar.getTime()));
        System.out.println("2019-12-31 用YYYY格式化的结果:" + format2.format(calendar.getTime()));


        System.out.println("=================================");
        // 获取当前信息
        LocalDate now = LocalDate.now();
        System.out.println(now.getYear());
        System.out.println(now);
        // 设置日期
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        int year = localDate.getYear();
        System.out.println(year);
        int year1 = localDate.get(ChronoField.YEAR);
        System.out.println(year1);

        System.out.println("========================================");
        // 获取当前时间
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println("现在时间" + nowTime);
        // 自定义时间
        LocalDateTime customTime = LocalDateTime.of(2019, 4, 12, 14 ,34 ,44);
        System.out.println("自定义时间" + customTime);
        System.out.println("=============================");
        // 获取当前时间的具体信息
        int thisYear = nowTime.getYear();
        System.out.println("当前时间的年份" + thisYear);
        int monthValue = nowTime.getMonthValue();
        System.out.println("当前年份的月份" + monthValue);
        int dayOfMonth = nowTime.getDayOfMonth();
        System.out.println("当前日期的在月份中的哪一天" + dayOfMonth);
        int hour = nowTime.getHour();
        System.out.println("一天中的哪个小时" + hour);
        int minute = nowTime.getMinute();
        System.out.println("一小时的哪个分钟" + minute);
        int second = nowTime.getSecond();
        System.out.println("一分钟的哪个秒" + second);

        int daysOfThisYear = LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear);

        System.out.println("1".equals("2"));
    }

}

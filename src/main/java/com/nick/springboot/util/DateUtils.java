package com.nick.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author zwj
 * @date 2021/6/4
 */
public class DateUtils
{

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 常用时间格式
     */
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    public static final String FORMAT_TIME = "HH:mm:ss";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_DATE_TIME_NUM = "yyMMddHHmmss";

    public static Date date = null;

    public static DateFormat dateFormat = null;

    public static Calendar calendar = null;

    /**
     * 根据传入的格式，将日期对象格式化为日期字符串
     *
     * @param date
     *            待被格式化日期
     * @param format
     *            自定义日期格式器
     * @return 格式后的日期字符串
     */
    public static String formatDate(Date date, String format)
    {
        String s = "";

        if(date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            s = sdf.format(date);
        }

        return s;
    }


    /**
     * 时间转换
     * @param date date
     * @param format format
     * @return date
     */
    public static Date formatDates(String date, String format)
    {
        SimpleDateFormat sim = new SimpleDateFormat(format);
        try
        {
            return sim.parse(date);
        }
        catch (ParseException e)
        {
            logger.error("/////日期转化异常////////////{}", e);
            return null;
        }
    }

    /**
     * 获取前n天开始时间
     * @param n 天数
     * @return Date
     */
    public static Date getStartPreDay(int n)
    {
        n = -n;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, n);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取每天20点的时间
     * @param n 前n天数
     * @return Date
     */
    public static Date getCurBefore21ClockDay(int n)
    {
        n = -n;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, n);
        cal.set(Calendar.HOUR_OF_DAY, 21);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取前n天开始时间
     *
     * @param n 天数
     * @return Date
     */
    public static Date getEndPreDay(int n)
    {
        n = -n;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, n);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取制定时间后n天的日期
     * @param date 指定日期
     * @param amount  指定天数
     * @return 指定日期后n的日期
     */
    public static Date getAfterDate(Date date, int amount)
    {
        // 获取日历实例
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        return calendar.getTime();
    }

    /**
     * 判断星期几
     */
    public static int dayForWeek(Date date) throws Exception
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(format.format(date)));
        int dayForWeek;
        if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            dayForWeek = 7;
        }
        else
        {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * 根据输入的参数获取星期n
     * @param n n
     * @return  String
     */
    public static String week(int n)
    {
        String str;
        switch (n)
        {

            case 1:
                str = "一";
                break;

            case 2:
                str = "二";
                break;

            case 3:
                str = "三";
                break;

            case 4:
                str = "四";
                break;

            case 5:
                str = "五";
                break;

            case 6:
                str = "六";
                break;

            case 7:
                str = "日";
                break;

            default:
                str = "一";
                break;

        }
        return str;
    }

    /**
     * 判断是上午还是下午
     * @param date 时间
     * @return string
     */
    public static String isAmPm(Date date)
    {
        GregorianCalendar curDate = new GregorianCalendar();
        curDate.setTime(date);
        if(curDate.get(GregorianCalendar.AM_PM) == 0)
        {
            return "上午";
        }
        else
        {
            return "下午";
        }

    }

    /**
     * 转换时间
     * @param date date
     * @return String
     * @throws Exception Exception
     */
    public static String parseDate(Date date) throws Exception
    {
        String dateStr = "";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        // 格式化为相同格式
        if(fmt.format(date).equals(fmt.format(new Date())))
        {
            dateStr = formatDate(date, "HH:mm");

        }
        else if(date.after(getStartPreDay(1)) && date.before(getEndPreDay(1)))
        {
            dateStr = "昨天";
        }
        else if(date.after(getStartPreDay(6)) && date.before(getEndPreDay(2)))
        {
            dateStr = "星期";
            dateStr += week(dayForWeek(date));

        }
        else
        {
            dateStr = formatDate(date, "yy/M/dd");
        }
        return dateStr;
    }

    /**
     * 获取不同格式的时间
     * @param date date
     * @return  String
     * @throws Exception 系统异常
     */
    public static String parseDateDital(Date date) throws Exception
    {
        String dateStr = "";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        // 格式化为相同格式
        if(fmt.format(date).equals(fmt.format(new Date())))
        {

            dateStr = isAmPm(date) + formatDate(date, "HH:mm");

        }
        else if(date.getTime() >= getStartPreDay(1).getTime() && date.getTime() <= getEndPreDay(1).getTime())
        {
            dateStr = "昨天 " + isAmPm(date) + formatDate(date, "HH:mm");
        }
        else if(date.after(getStartPreDay(6)) && date.before(getEndPreDay(2)))
        {
            dateStr = "星期" + week(dayForWeek(date)) + " " + isAmPm(date) + formatDate(date, "HH:mm");

        }
        else
        {
            dateStr = formatDate(date, "yy/M/dd") + " " + isAmPm(date) + formatDate(date, "HH:mm");
        }
        return dateStr;
    }

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Date getCurrentDate()
    {
        return Calendar.getInstance().getTime();
    }

    /**
     * 计算传入时间跟当前时间相差的分钟数并向上取整
     * @param date  时间
     * @return 分钟数
     */
    public static Integer calcTimeSubMinutes(Date date)
    {
        Long curDate = getCurrentDate().getTime();
        Long inputDate = date.getTime();
        Long diff;
        if(inputDate > curDate)
        {
            diff = inputDate - curDate;
        }
        else
        {
            diff = curDate - inputDate;
        }
        return Double.valueOf((Math.ceil((double)(diff) / 60000))).intValue();
    }

    /**
     * 功能描述：格式化日期
     *
     * @param dateStr
     *            String 字符型日期
     * @param format
     *            String 格式
     * @return Date 日期
     */
    public static Date parseDate(String dateStr, String format) {
        try {
            dateFormat = new SimpleDateFormat(format);
            String dt = dateStr.replaceAll("-", "/");
            if ((!"".equals(dt)) && (dt.length() < format.length())) {
                dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]",
                        "0");
            }
            date = (Date) dateFormat.parse(dt);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 功能描述：格式化日期
     *
     * @param dateStr
     *            String 字符型日期：YYYY-MM-DD 格式
     * @return Date
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, "yyyy/MM/dd");
    }

    /**
     * 功能描述：格式化输出日期
     *
     * @param date
     *            Date 日期
     * @param format
     *            String 格式
     * @return 返回字符型日期
     */
    public static String format(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                dateFormat = new SimpleDateFormat(format);
                result = dateFormat.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 功能描述：
     *
     * @param date
     *            Date 日期
     * @return
     */
    public static String format(Date date) {
        return format(date, "yyyy/MM/dd");
    }

    /**
     * 功能描述：返回年份
     *
     * @param date
     *            Date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 功能描述：返回月份
     *
     * @param date
     *            Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日份
     *
     * @param date
     *            Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分钟
     *
     * @param date
     *            日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date
     *            Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫秒
     *
     * @param date
     *            日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 功能描述：返回字符型日期
     *
     * @param date
     *            日期
     * @return 返回字符型日期 yyyy/MM/dd 格式
     */
    public static String getDate(Date date) {
        return format(date, "yyyy/MM/dd");
    }

    /**
     * 功能描述：返回字符型时间
     *
     * @param date
     *            Date 日期
     * @return 返回字符型时间 HH:mm:ss 格式
     */
    public static String getTime(Date date) {
        return format(date, "HH:mm:ss");
    }

    /**
     * 功能描述：返回字符型日期时间
     *
     * @param date
     *            Date 日期
     * @return 返回字符型日期时间 yyyy/MM/dd HH:mm:ss 格式
     */
    public static String getDateTime(Date date) {
        return format(date, "yyyy/MM/dd HH:mm:ss");
    }

    /**
     * 功能描述：日期相加
     *
     * @param date
     *            Date 日期
     * @param day
     *            int 天数
     * @return 返回相加后的日期
     */
    public static Date addDate(Date date, int day) {
        calendar = Calendar.getInstance();
        long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    /**
     * 功能描述：日期相减
     *
     * @param date
     *            Date 日期
     * @param date1
     *            Date 日期
     * @return 返回相减后的日期
     */
    public static int diffDate(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

    /**
     * 功能描述：取得指定月份的第一天
     *
     * @param strdate
     *            String 字符型日期
     * @return String yyyy-MM-dd 格式
     */
    public static String getMonthBegin(String strdate) {
        date = parseDate(strdate);
        return format(date, "yyyy-MM") + "-01";
    }

    /**
     * 功能描述：取得指定月份的最后一天
     *
     * @param strdate
     *            String 字符型日期
     * @return String 日期字符串 yyyy-MM-dd格式
     */
    public static String getMonthEnd(String strdate) {
        date = parseDate(getMonthBegin(strdate));
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return formatDate(calendar.getTime());
    }

    /**
     * 功能描述：常用的格式化日期
     *
     * @param date
     *            Date 日期
     * @return String 日期字符串 yyyy-MM-dd格式
     */
    public static String formatDate(Date date) {
        return formatDateByFormat(date, "yyyy-MM-dd");
    }

    /**
     * 功能描述：以指定的格式来格式化日期
     *
     * @param date
     *            Date 日期
     * @param format
     *            String 格式
     * @return String 日期字符串
     */
    public static String formatDateByFormat(Date date, String format) {
        String result = "";
        if (date != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                result = sdf.format(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

}

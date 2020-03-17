package food.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class StringUtil {
    public Integer autoCode(){
        int digits = 1000000 + new Random().nextInt(9000000);
        return digits;
    }

    public String convertMillToString(long timeStamp){
        Date date = new Date(timeStamp);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format.format(date);
    }

    public String convertIntstatusToString(int i){
        String stt ="";
        switch (i){
            case 0:
                stt = "DeActive";
                break;
            case 1:
                stt = "Active";
                break;
            case -1:
                stt ="Deleted";
                break;
        }
        return stt;
    }

    public String convertIntstatusToStringOrder(int i){
        String stt ="";
        switch (i){
            case 0:
                stt = "DeActive";
                break;
            case 1:
                stt = "Active";
                break;
            case 2:
                stt = "On Going";
                break;
            case 3:
                stt = "Done";
                break;
            case -1:
                stt ="Cancel";
                break;
        }
        return stt;
    }

    public String convertIntstatusToStringMember(int i){
        String stt ="";
        switch (i){
            case 0:
                stt = "female";
                break;
            case 1:
                stt = "male";
                break;
            case 2:
                stt = "others";
                break;
        }
        return stt;

    }
}

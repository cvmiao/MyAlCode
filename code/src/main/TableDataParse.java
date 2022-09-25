package main;

import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TableDataParse {
    private static final String VALUE_FILED_NAME = "number";
    private static final String TIME_FILED_NAME = "time";

    public static void main(String[] args) {
        String data = "text,time,number\n" +
                "1,0023,2\n" +
                "2,0024,3";

        List<StaticModel> result = parseData(data);
        System.out.printf(JSONObject.toJSONString(result));
    }

    private static List<StaticModel> parseData(String data) {
        String[] dataArgs = data.split("\n");
        if (dataArgs.length > 1) {
            String[] headers = dataArgs[0].split(",");
            int timeIndex = Integer.MAX_VALUE;
            int valueIndex = Integer.MAX_VALUE;
            for (int i = 0; i < headers.length; i++) {
                if (VALUE_FILED_NAME.equals(headers[i])) {
                    valueIndex = i;
                }
                if (TIME_FILED_NAME.equals(headers[i])) {
                    timeIndex = i;
                }
            }
            if ((valueIndex != Integer.MAX_VALUE) && (timeIndex != Integer.MAX_VALUE)) {
                List<StaticModel> resultList = new ArrayList<>();
                StaticModel model;
                for (int i = 1; i < dataArgs.length; i++) {
                    model = new StaticModel();
                    model.setTime(dataArgs[i].split(",")[timeIndex]);
                    model.setValue(dataArgs[i].split(",")[valueIndex]);
                    resultList.add(model);
                }
                return resultList;
            }
        }
        return new ArrayList<>();
    }
}

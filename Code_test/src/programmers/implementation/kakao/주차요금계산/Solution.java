package programmers.implementation.kakao.주차요금계산;

import java.util.*;

class Car implements Comparable<Car>{
    String carNum;
    int fee;

    Car(String carNum, int fee){
        this.carNum = carNum;
        this.fee = fee;
    }

    @Override
    public int compareTo(Car o){
        return this.carNum.compareTo(o.carNum);
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {1, 2};


        int baseMinute = fees[0];
        int baseFee = fees[1];
        int unitMinute = fees[2]; // 1439 이하
        int unitFee = fees[3]; // 10000 이하

        HashMap<String, Integer> map = new HashMap<>(); // <차량번호, 시간>
        HashMap<String, Integer> prefixMap = new HashMap<>(); // <차량번호, 누적시간>
        ArrayList<Car> list = new ArrayList<>();

        for(int i=0;i<records.length;i++){
            String[] current = records[i].split(" "); // [0] : 시간, [1] : 차량 번호, [2] : {IN, OUT}
            if(current[2].equals("IN")){
                map.put(current[1], hourToMin(current[0]));
            }else{
                int preTime = map.get(current[1]);
                map.remove(current[1]);
                int timeDiff = hourToMin(current[0]) - preTime;
                prefixMap.put(current[1], prefixMap.getOrDefault(current[1], 0) + timeDiff);
            }
        }
        for(String car : map.keySet()){
            int preTime = map.get(car);
            int timeDiff = hourToMin("23:59") - preTime;
            prefixMap.put(car, prefixMap.getOrDefault(car, 0) + timeDiff);
        }
        for(String car : prefixMap.keySet()){
            int min = prefixMap.get(car) - baseMinute;
            int pay = baseFee;
            if(min > 0){
                if(min % unitMinute == 0){
                    pay += unitFee * (min / unitMinute);
                }else{
                    pay += unitFee * (min / unitMinute + 1);
                }
            }
            list.add(new Car(car, pay));
        }
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).fee;
        }
        return answer;
    }

    public int hourToMin(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[1]) + Integer.parseInt(t[0]) * 60;
    }
}
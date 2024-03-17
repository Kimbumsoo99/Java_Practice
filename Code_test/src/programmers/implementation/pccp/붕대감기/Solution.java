package programmers.implementation.pccp.붕대감기;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health;
        int count = 0;
        int attackIdx = 0;
        int time = 0;
        while(true){
            time++;
            if(attacks[attackIdx][0] == time){
                health -= attacks[attackIdx][1];
                if(health <= 0) return -1;
                count = 0;
                if(++attackIdx == attacks.length) break;
                continue;
            }
            health += bandage[1];
            if(++count == bandage[0]){
                health += bandage[2];
                count = 0;
            }
            if(health > maxHealth) health = maxHealth;

        }
        return health;
    }
}
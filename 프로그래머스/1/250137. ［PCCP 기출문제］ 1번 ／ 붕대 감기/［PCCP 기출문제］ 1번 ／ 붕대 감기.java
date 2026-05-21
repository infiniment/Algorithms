class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int castTime = bandage[0];   // 붕대 감기 시전 시간
        int healPerSec = bandage[1]; // 초당 회복량
        int bonusHeal = bandage[2];  // 추가 회복량

        int maxHealth = health;
        int currentHealth = health;
        int successTime = 0;

        int attackIndex = 0;
        int lastTime = attacks[attacks.length - 1][0];

        for (int time = 1; time <= lastTime; time++) {

            // 현재 시간이 공격 시간인 경우
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                currentHealth -= attacks[attackIndex][1];
                successTime = 0;
                attackIndex++;

                if (currentHealth <= 0) {
                    return -1;
                }
            }
            // 공격 시간이 아닌 경우 회복
            else {
                currentHealth += healPerSec;
                successTime++;

                // 연속 성공 시간이 시전 시간과 같아지면 추가 회복
                if (successTime == castTime) {
                    currentHealth += bonusHeal;
                    successTime = 0;
                }

                // 최대 체력을 넘을 수 없음
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }

        return currentHealth;
    }
}
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = toSec(video_len);
        int cur = toSec(pos);
        int opStartSec = toSec(op_start);
        int opEndSec = toSec(op_end);
        
        cur = skipOpening(cur, opStartSec, opEndSec);
        
         for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else if (cmd.equals("next")) {
                cur = Math.min(videoLenSec, cur + 10);
            }

            cur = skipOpening(cur, opStartSec, opEndSec);
        }
        
    
        
        return toTime(cur);
    }
    

    private int toSec(String time) {
        String[] parts = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        return min * 60 + sec;
    }


    private String toTime(int totalSec) {
        int min = totalSec / 60;
        int sec = totalSec % 60;
        return String.format("%02d:%02d", min, sec);
    }

    private int skipOpening(int cur, int opStart, int opEnd) {
        if (opStart <= cur && cur <= opEnd) {
            return opEnd;
        }
        return cur;
    }
}
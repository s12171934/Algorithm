class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int video_int = getInt(video_len);
        int now = getInt(pos);
        int op_start_int = getInt(op_start);
        int op_end_int = getInt(op_end);
        
        for (String command : commands) {
            if (now >= op_start_int && now < op_end_int) now = op_end_int;
            if (command.equals("next")) now = Math.min(now + 10, video_int);
            else now = Math.max(now - 10, 0);
            
        }
        if (now >= op_start_int && now < op_end_int) now = op_end_int;
        
    
        return String.format("%02d:%02d", now / 60, now % 60);
    }
    
    int getInt(String time) {
        String[] time_arr = time.split(":");
        return Integer.parseInt(time_arr[0]) * 60 + Integer.parseInt(time_arr[1]);
    }
}
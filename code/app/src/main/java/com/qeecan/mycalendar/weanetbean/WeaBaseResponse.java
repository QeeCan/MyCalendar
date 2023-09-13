package com.qeecan.mycalendar.weanetbean;

import com.qeecan.mycalendar.weanetbean.Result;

public class WeaBaseResponse {

    private String reason;
    private Result result;
    private int error_code;;
        public void setReason(String reason) {
            this.reason = reason;
        }
        public String getReason() {
            return reason;
        }



        public void setError_code(int error_code) {
            this.error_code = error_code;
        }
        public int getError_code() {
            return error_code;
        }


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeaBaseResponse{" +
                "reason='" + reason + '\'' +
                ", result2=" + result +
                ", error_code=" + error_code +
                '}';
    }
}

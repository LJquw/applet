package www.xiyou.utils;

public enum ResponseCode {
    SUCCESS("0","请求成功"),
    FAIL("9999","网络不稳定"),
    ERROR_1("9001","参数不能为空"),
    ERROR_2("9002","手机号已经注册"),
    ERROR_3("9003","非正常登录！！"),
    ERROR_4("9004","账号密码不匹配");

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

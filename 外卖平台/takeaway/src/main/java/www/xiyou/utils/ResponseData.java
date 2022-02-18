package www.xiyou.utils;

/**
 * 定义所有请求返回的对象
 */
public class ResponseData {
    private Object data;
    private String code;
    private String msg;
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public ResponseData(Object data, ResponseCode responseCode, Long count) {
        this.data = data;
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.count = count;
    }

    public ResponseData(Object data, ResponseCode responseCode) {
        this.data = data;
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public ResponseData(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public ResponseData() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

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
}

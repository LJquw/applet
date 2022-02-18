package www.xiyou.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-08-19 09:46:10
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 474531188606665761L;

    /**
     * 订单id
     */
    private Long id;
    /**
     * 关联user表的openid
     */
    private String openid;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 餐品名称
     */
    private String foodname;
    /**
     * 预约时间
     */
    private String makedate;
    //下单时间
    private String placedate;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 餐品状态
     */
    private String orderstate;
    /**
     * 用户电话
     */
    private String usertell;
    /**
     * 备注留言
     */
    private String information;
    //关联商家id
    private Long busid;
    //关联产品id
    private Long foodid;

    private Businesss businesss;

    private Food food;


    public String getPlacedate() {
        return placedate;
    }

    public void setPlacedate(String placedate) {
        this.placedate = placedate;
    }

    public Businesss getBusinesss() {
        return businesss;
    }

    public void setBusinesss(Businesss businesss) {
        this.businesss = businesss;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Long getFoodid() {
        return foodid;
    }

    public void setFoodid(Long foodid) {
        this.foodid = foodid;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getMakedate() {
        return makedate;
    }

    public void setMakedate(String makedata) {
        this.makedate = makedata;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrdertype() {
        return orderstate;
    }

    public void setOrdertype(String ordertype) {
        this.orderstate = ordertype;
    }

    public String getUsertell() {
        return usertell;
    }

    public void setUsertell(String usertell) {
        this.usertell = usertell;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Long getBusid() {
        return busid;
    }

    public void setBusid(Long busid) {
        this.busid = busid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", userid='" + userid + '\'' +
                ", foodname='" + foodname + '\'' +
                ", makedate='" + makedate + '\'' +
                ", placedate='" + placedate + '\'' +
                ", username='" + username + '\'' +
                ", orderstate='" + orderstate + '\'' +
                ", usertell='" + usertell + '\'' +
                ", information='" + information + '\'' +
                ", busid=" + busid +
                ", foodid=" + foodid +
                '}';
    }
}

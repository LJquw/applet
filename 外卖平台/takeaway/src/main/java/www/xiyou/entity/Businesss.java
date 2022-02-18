package www.xiyou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Businesss)实体类
 *
 * @author makejava
 * @since 2021-08-19 09:25:09
 */
public class Businesss implements Serializable {
    private static final long serialVersionUID = -49597027433748854L;

    private Long id;
    /**
     * 商家名称
     */
    private String busname;
    /**
     * 商家地址
     */
    private String busaddress;
    /**
     * 商家简介
     */
    private String busexplain;
    /**
     * 商家电话
     */
    private String bustell;
    /**
     * 图片id
     */
    private Long busimgid;
    private Image image;

    /**
     * 食物
     */
    private Food food;

    List<Food> foods;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getBusaddress() {
        return busaddress;
    }

    public void setBusaddress(String busaddress) {
        this.busaddress = busaddress;
    }

    public String getBusexplain() {
        return busexplain;
    }

    public void setBusexplain(String busexplain) {
        this.busexplain = busexplain;
    }

    public String getBustell() {
        return bustell;
    }

    public void setBustell(String bustell) {
        this.bustell = bustell;
    }

    public Long getBusimgid() {
        return busimgid;
    }

    public void setBusimgid(Long busimgid) {
        this.busimgid = busimgid;
    }

}

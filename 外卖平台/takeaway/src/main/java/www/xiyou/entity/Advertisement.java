package www.xiyou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Advertisement)实体类
 *
 * @author makejava
 * @since 2021-08-19 10:55:00
 */
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 847864179776304729L;
    /**
     * 广告id
     */
    private Long id;
    /**
     * 广告图片id
     */
    private Long imageid;
    /**
     * 关联餐品id
     */
    private Long foodid;
    /**
     * 关联商家id
     */
    private Long busid;
    /**
     * 广告名称
     */
    private String adname;
    /**
     * 广告图片
     */
    private Image image;
    /**
     * 对应食物
     */
    private Food food;

    private String adtitle;

    private String adexplain;

    private Food adfood;

    private Businesss businesss;

    public Food getAdfood() {
        return adfood;
    }

    public void setAdfood(Food adfood) {
        this.adfood = adfood;
    }

    public Businesss getBusinesss() {
        return businesss;
    }

    public void setBusinesss(Businesss businesss) {
        this.businesss = businesss;
    }

    public String getAdtitle() {
        return adtitle;
    }

    public void setAdtitle(String adtitle) {
        this.adtitle = adtitle;
    }

    public String getAdexplain() {
        return adexplain;
    }

    public void setAdexplain(String adexplain) {
        this.adexplain = adexplain;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public Long getImageid() {
        return imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public Long getFoodid() {
        return foodid;
    }

    public void setFoodid(Long foodid) {
        this.foodid = foodid;
    }

    public Long getBusid() {
        return busid;
    }

    public void setBusid(Long busid) {
        this.busid = busid;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

}

package www.xiyou.entity;

import java.io.Serializable;

/**
 * (Food)实体类
 *
 * @author makejava
 * @since 2021-08-19 09:46:06
 */
public class Food implements Serializable {
    private static final long serialVersionUID = -84991723757420815L;
    /**
     * 餐品id
     */
    private Long id;
    /**
     * 餐品介绍
     */
    private String proexplain;
    /**
     * 餐品价格
     */
    private Object proprice;
    /**
     * 关联类型id
     */
    private Long protypeid;
    /**
     * 餐品名称
     */
    private String proname;
    /**
     * 关联图片id
     */
    private Long imageid;
    /**
     * 详情描述
     */
    private String material;
    /**
     * 餐品状态
     */
    private String prostatus;
    /**
     * 关联商家id
     */
    private Long busid;
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProexplain() {
        return proexplain;
    }

    public void setProexplain(String proexplain) {
        this.proexplain = proexplain;
    }

    public Object getProprice() {
        return proprice;
    }

    public void setProprice(Object proprice) {
        this.proprice = proprice;
    }

    public Long getProtypeid() {
        return protypeid;
    }

    public void setProtypeid(Long protypeid) {
        this.protypeid = protypeid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public Long getImageid() {
        return imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public String getProstatus() {
        return prostatus;
    }

    public void setProstatus(String prostatus) {
        this.prostatus = prostatus;
    }

    public Long getBusid() {
        return busid;
    }

    public void setBusid(Long busid) {
        this.busid = busid;
    }

}

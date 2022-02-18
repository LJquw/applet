package www.xiyou.entity;

import java.io.Serializable;

/**
 * (Recommend)实体类
 *
 * @author makejava
 * @since 2021-08-19 09:46:11
 */
public class Recommend implements Serializable {
    private static final long serialVersionUID = -33149831996566107L;
    /**
     * 导航栏推荐类型id
     */
    private Long id;
    /**
     * 导航栏推荐类型
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

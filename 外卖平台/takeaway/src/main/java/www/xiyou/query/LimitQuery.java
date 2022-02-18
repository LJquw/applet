package www.xiyou.query;

public class LimitQuery {
    private Long page; //当前第几页
    private Long limit; //每页多少条数据

    @Override
    public String toString() {
        return "LimitQuery{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }
}

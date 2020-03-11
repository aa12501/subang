package entity;

import java.util.List;

public class PageResult <T> {
    private long total;
    private List<T> cows;

    public PageResult() {
    }

    public PageResult(long total, List<T> cows) {
        this.total = total;
        this.cows = cows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getCows() {
        return cows;
    }

    public void setCows(List<T> cows) {
        this.cows = cows;
    }
}

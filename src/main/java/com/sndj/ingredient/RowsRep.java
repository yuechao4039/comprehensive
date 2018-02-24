package com.sndj.ingredient;

import java.util.ArrayList;
import java.util.List;

public class RowsRep<T> extends BaseResp {

    private List<T> rows = new ArrayList<T>();


    public void add(T t) {
        rows.add(t);
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

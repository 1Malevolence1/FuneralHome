package basedate.dataaccess;

import java.util.ArrayList;
import java.util.List;

public class ListLoaders {
    private  static List<Object> list;


        public  void addListLoader(Object object){
        if(list.isEmpty()){
            list = new ArrayList<>();
        }

        list.add(object);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}

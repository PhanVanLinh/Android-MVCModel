package pvlinh.demo.mvcmodelapplicationbasic2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 13/03/2016.
 */
public class Model extends Observable{

    private List<Integer> mList;

    public Model(){
        mList = new ArrayList<>();
        mList.add(0);
        mList.add(0);
        mList.add(0);
    }

    public int getValueAtIndex(int index) throws IndexOutOfBoundsException{
        return  mList.get(index);
    }

    public void setValueAtIndex(int index) throws IndexOutOfBoundsException{
        mList.set(index, mList.get(index) + 1);
        setChanged();
        notifyObservers();
    }

}

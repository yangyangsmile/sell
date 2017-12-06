package test.designMode.FactoryPattern;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Factory {

    public FactoryPattern getFactoyr(String AA){
        if (AA == "AA"){
            return new PatternAA();
        }
        if (AA == "BB"){
            return new PatternBB();
        }
        return null;
    }
}

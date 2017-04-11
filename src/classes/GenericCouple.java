package classes;

/**
 * Created by simon.calabrese on 07/04/2017.
 */
public class GenericCouple<A,B> {
    private A f;
    private B s;

    public GenericCouple(A f, B s) {
        this.f = f;
        this.s = s;
    }

    public A getF() {
        return f;
    }

    public void setF(A f) {
        this.f = f;
    }

    public B getS() {
        return s;
    }

    public void setS(B s) {
        this.s = s;
    }
}

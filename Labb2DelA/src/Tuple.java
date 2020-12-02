public class Tuple<A,B>{
    private A firstMember;
    private B secondMember;

    public Tuple (A first, B second){
        this.firstMember = first;
        this.secondMember = second;
    }

    public A getFirstMember(){
        return this.firstMember;
    }

    public B getSecondMember(){
        return this.secondMember;
    }
}
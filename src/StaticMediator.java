import java.util.ArrayList;
import java.util.Arrays;

public class StaticMediator {
    private Spy s1, s2, s3, s4;
    private Agent a1, c1;
    private Mole m1;
    //step 2
    //private Agent a2, a3;
    //private Mole m2, m3;
    //private CompositeAgent duo;

    public void createSpyTeam () {

        s1 = new Spy("spy1 ", "secret 1 ", 10, this);
        s2 = new Spy("spy2 ", "secret 2 ", 5, this);
        s3 = new Spy("spy3 ", "secret 3 ", 2, this);
        s4 = new Spy("spy4 ", "secret 4 ", 20, this);
        a1 = new Agent("a1 ", "ultra secret 1 ",this);
        m1 = new Mole("m1 ", "deep secret 1 ", this);
        c1 = new Agent("cleaner ", " no secret ",this);

        //step2
        //a2 = new Agent("a2 ", " ultra secret 2 ",this);
        //m2 = new Mole("m2 ", " deep secret 2 ", this);
        //a3 = new Agent("a3 ", " ultra secret 3 ",this);
        //m3 = new Mole("m3 ", " deep secret 3 ", this);
        //duo = new CompositeAgent (new ArrayList<CoordinatedAsset>(Arrays.asList(a2, m2)));


    }

    public StaticMediator() {
        createSpyTeam();
    }

    public void runScenario1 () {
        System.out.println("Initial set up");
        printStatus();
        System.out.println("s4 status update: ");
        s4.statusChange();
        printStatus();
        System.out.println("s1 status update: ");
        s1.statusChange();
        printStatus();
        System.out.println("s2 status update: ");
        s2.statusChange();
        printStatus();
        System.out.println("s3 status update: ");
        s3.statusChange();
        printStatus();
        System.out.println("s4 status update: ");
        s4.statusChange();
        printStatus();
        System.out.println("a1 status update: ");
        a1.statusChange();
        printStatus();
        System.out.println("m1 status update: ");
        m1.statusChange();
        printStatus();
        System.out.println("c1 status update: ");
        c1.statusChange();
        printStatus();
    }

//    public void runScenario2 () {
//        System.out.println("Initial set up");
//        printStatus();
//        duo.statusChange();
//        a3.statusChange();
//        m3.statusChange();
//    }

    private void printStatus() {
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println(s4.toString());
        if(a1==null){
            System.out.println("null");
        }
        else{
            System.out.println(a1.toString());
        }
        if(m1==null){
            System.out.println("null");
        }
        else{
            System.out.println(m1.toString());
        }
        System.out.println(c1.toString());
        //Step 2
        //System.out.println(duo);
    }

    public Spy getS1() {
        return s1;
    }

    public Spy getS2() {
        return s2;
    }

    public Spy getS3() {
        return s3;
    }

    public Spy getS4() {
        return s4;
    }

    public Agent getA1() {
        return a1;
    }

    public Agent getC1() {
        return c1;
    }

    public Mole getM1() {
        return m1;
    }

    public void setA1(Agent a1) {
        this.a1 = a1;
    }

    public void setM1(Mole m1) {
        this.m1 = m1;
    }

   //missing code

}
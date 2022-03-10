import java.util.ArrayList;
import java.util.Arrays;

public class StaticMediator {
    private Spy s1, s2, s3, s4;
    private Agent a1, c1;
    private Mole m1;
    //step 2
    private Agent a2, a3;
    private Mole m2, m3;

    private CompositeAgent duo;

    public void createSpyTeam () {

        s1 = new Spy("spy1 ", "secret 1 ", 10, this);
        s2 = new Spy("spy2 ", "secret 2 ", 5, this);
        s3 = new Spy("spy3 ", "secret 3 ", 2, this);
        s4 = new Spy("spy4 ", "secret 4 ", 20, this);
        a1 = new Agent("a1 ", "ultra secret 1 ",this);
        m1 = new Mole("m1 ", "deep secret 1 ", this);
        c1 = new Agent("cleaner ", " no secret ",this);

        //step2
        a2 = new Agent("a2 ", " ultra secret 2 ",this);
        m2 = new Mole("m2 ", " deep secret 2 ", this);
        a3 = new Agent("a3 ", " ultra secret 3 ",this);
        m3 = new Mole("m3 ", " deep secret 3 ", this);
        duo = new CompositeAgent (new ArrayList<CoordinatedAsset>(Arrays.asList(a2, m2)));


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

    public void runScenario2 () {
        System.out.println("Initial set up");
        printStatus();
        System.out.println("Team Status changed");
        duo.statusChange();
        printStatus();
        a3.statusChange();
        printStatus();
        m3.statusChange();
        printStatus();
    }

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
        duo.printing();
    }
   //missing code

    public void hasChanged(CoordinatedAsset obj){
        if (obj.getName().equals("spy1 ")){
            String temp = s1.getSecret();
            s1.setSecret(s2.getSecret());
            s2.setSecret(temp);
        }
        else if (obj.getName().equals("spy2 ")){
            s2.setSecret(s2.getSecret()+" " + s3.getSecret());
        }
       else if (obj.getName().equals("spy3 ")){
           s3.setClearance(s1.getClearance()+ s2.getClearance());
           s4.setClearance(0);
        }
       else if (obj.getName().equals("spy4 ")){
           if(s4.getClearance() > 0){
               s1.setClearance(s4.getClearance());
               s2.setClearance(s3.getClearance());
           }
        }
       else if (obj.getName().equals("a1 ")){
           a1.setSecret(s3.getSecret());
           m1.setSecret("forgotten");
        }
       else if (obj.getName().equals("a2 ")){
           a2.setSecret(a1.getSecret()+" "+m1.getSecret());
        }
       else if (obj.getName().equals("a3 ")){
            duo.settingSecrets(a1.getSecret()+" "+m2.getSecret());
            a3.setSecret(s1.getSecret());
            m3.setSecret("forgotten");
        }
       else if (obj.getName().equals("m1 ")){
            String temp = m1.getSecret();
            m1.setSecret(s4.getSecret());
            s4.setSecret(temp);
        }
       else if (obj.getName().equals("m2 ")){
           s1.setSecret(m2.getSecret());
        }
        else if (obj.getName().equals("m3 ")){
            duo.swappingSecrets(m1);
        }
       else if (obj.getName().equals(("cleaner "))){
           a1 = null;
           m1 = null;
        }
    }
}
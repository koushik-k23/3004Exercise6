public class Spy implements Component{

    private String name;
    private String secret;
    private StaticMediator mediator;
    private int clearance;

    public Spy(String name, String secret, int clearance, StaticMediator mediator){
        this.name = name;
        this.secret = secret;
        this.clearance = clearance;
        setMediator(mediator);
    }
    @Override
    public void setMediator(StaticMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void statusChange() {
        if (this.name.equals("spy1 ")){
            String temp = this.secret;
            this.secret = this.getMediator().getS2().getSecret();
            this.getMediator().getS2().setSecret(temp);
        }
        else if (this.name.equals("spy2 ")){
            this.secret += " " + this.getMediator().getS3().getSecret();
        }
        else if (this.name.equals("spy3 ")){
            this.clearance = this.getMediator().getS1().getClearance() + this.getMediator().getS2().getClearance();
            this.getMediator().getS4().setClearance(0);
        }
        else if (this.name.equals("spy4 ")){
            if (this.clearance > 0){
                this.mediator.getS1().setClearance(this.clearance);
                this.getMediator().getS2().setClearance(this.getMediator().getS3().getClearance());
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public StaticMediator getMediator() {
        return mediator;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public String toString(){
        return this.name + " " + this.secret + " and my clearance is " + this.clearance;
    }
}

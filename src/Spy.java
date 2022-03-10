public class Spy implements CoordinatedAsset{

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
    public void statusChange() {
        mediator.hasChanged(this);
    }

    @Override
    public String getSecret() {
        return secret;
    }

    @Override
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString(){
        return this.name + " " + this.secret + " and my clearance is " + this.clearance;
    }

    @Override
    public StaticMediator getMediator() {
        return mediator;
    }
    @Override
    public void setMediator(StaticMediator mediator) {
        this.mediator = mediator;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

}

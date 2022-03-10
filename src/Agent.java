public class Agent implements Component{

    private String name;
    private String secret;
    private StaticMediator mediator;

    public Agent (String name, String secret, StaticMediator mediator){
        this.name = name;
        this.secret = secret;
        setMediator(mediator);
    }
    @Override
    public void setMediator(StaticMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void statusChange() {
        if (this.name.equals("a1 ")){
            this.secret = this.getMediator().getS3().getSecret();
            this.getMediator().getM1().setSecret("forgotten");
        }
        else if (this.name.equals("cleaner ")){
            this.getMediator().setA1(null);
            this.getMediator().setM1(null);
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

    public String toString(){
        return this.name + " " + this.secret ;
    }
}

public class Agent implements CoordinatedAsset{

    private String name;
    private String secret;
    private StaticMediator mediator;

    public Agent (String name, String secret, StaticMediator mediator){
        this.name = name;
        this.secret = secret;
        setMediator(mediator);
    }

    @Override
    public void statusChange() {
        mediator.hasChanged(this);
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
    public String getSecret() {
        return secret;
    }
    @Override
    public void setSecret(String secret) {
        this.secret = secret;
    }
    @Override
    public StaticMediator getMediator() {
        return mediator;
    }
    @Override
    public void setMediator(StaticMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String toString(){
        return this.name + " " + this.secret ;
    }
}

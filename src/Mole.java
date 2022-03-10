public class Mole implements Component{

    private String name;
    private String secret;
    private StaticMediator mediator;

    public Mole (String name, String secret, StaticMediator mediator ){
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
        String temp = this.secret;
        this.secret = this.getMediator().getS4().getSecret();
        this.getMediator().getS4().setSecret(temp);
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
        if(this==null){
            return "null";
        }
        return this.name + " " + this.secret ;
    }
}

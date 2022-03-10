public interface CoordinatedAsset {
    public void statusChange();
    public String getSecret();
    public void setSecret(String secret);
    public String getName();
    public void setName(String name);
    public String toString();
    public StaticMediator getMediator();
    public void setMediator(StaticMediator mediator);
}

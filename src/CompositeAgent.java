import java.util.ArrayList;

public class CompositeAgent implements CoordinatedAsset{

    private ArrayList<CoordinatedAsset> list ;
    public CompositeAgent(ArrayList<CoordinatedAsset> list){
        this.list = list;


    }

    @Override
    public void statusChange() {
        for (CoordinatedAsset element : list){
            element.statusChange();
        }
    }

    @Override
    public String getSecret() {
        return null;
    }

    @Override
    public void setSecret(String secret) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public StaticMediator getMediator() {
        return null;
    }

    @Override
    public void setMediator(StaticMediator mediator) {

    }

    public void printing() {
        for (CoordinatedAsset element: list){
            System.out.println(element.toString());
        }
    }

    public void settingSecrets(String newSecret){
        for (CoordinatedAsset element: list){
            element.setSecret(newSecret);
        }
    }

    public void swappingSecrets(CoordinatedAsset newSecret){
        for (CoordinatedAsset element: list){
            String temp = element.getSecret();
            element.setSecret(newSecret.getSecret());
            newSecret.setSecret(temp);
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelevisionRemote extends Remote {

    private HashMap<String, Integer> minMaxVolume;
    private HashMap<String, Integer> minMaxChannel;

    public TelevisionRemote(int initalVolume, int initialChannel, int minVolume,int maxVolume, int minChannel, int maxChannel) {
        super(initalVolume, initialChannel);
        this.minMaxVolume = new HashMap<>();
        this.minMaxChannel = new HashMap<>();

        this.minMaxChannel.put("min", minChannel);
        this.minMaxChannel.put("max", maxChannel);

        this.minMaxVolume.put("min", minVolume);
        this.minMaxVolume.put("max", maxVolume);

    }

    @Override
    public void channelUp() {
        if (this.getCurrentChannel() < this.minMaxChannel.get("max")) {
            this.setCurrentChannel(this.getCurrentChannel() + 1);
        }
    }

    @Override
    public void channelDown() {
        if (this.getCurrentChannel() > this.minMaxChannel.get("min")) {
            this.setCurrentChannel(this.getCurrentChannel() - 1);
        }
    }

    @Override
    public void goToChannel(int channelNumber) throws ChannelOutOfBoundsException {
        if (channelNumber <= this.minMaxChannel.get("max") && channelNumber >= this.minMaxChannel.get("min") ) {
            this.setCurrentChannel(channelNumber);
        } else {
            throw new ChannelOutOfBoundsException("OH NO OUT OF BOUNDS!");
        }
    }

    @Override
    public void volumeUp() {
        if (this.getCurrentVolume() < this.minMaxVolume.get("max")) {
            this.setCurrentVolume(this.getCurrentVolume() + 1);
        }
    }

    @Override
    public void volumeDown() {
        if (this.getCurrentVolume() > this.minMaxVolume.get("min")) {
            this.setCurrentVolume(this.getCurrentVolume() - 1);
        }
    }

    /*
    Java II Review BONUS

Create a static method on the Main class called turnUp11Times that takes in a list of VolumeControllable objects and increases the volume 11 times for each TelevisionRemote object. Depending on the volume range, some objects may max out volume early while others may stop on 12 (if starting at volume level 1).
     */

    public static void turnUp11Times(List<VolumeAdjustable> adjustables) {
        for (VolumeAdjustable va : adjustables) {
            for (int i = 1; i <= 11; i++) {
                va.volumeUp();
            }
        }
    }


    // MAIN FOR TESTING BONUS
    public static void main(String[] args) {
        VolumeAdjustable tr1 = new TelevisionRemote(1, 1, 1, 20, 1, 3);
        VolumeAdjustable tr2 = new TelevisionRemote(1, 1, 1, 12, 1, 3);
        VolumeAdjustable tr3 = new TelevisionRemote(1, 1, 1, 5, 1, 3);

        List<VolumeAdjustable> adjustables = new ArrayList<>();
        adjustables.add(tr1);
        adjustables.add(tr2);
        adjustables.add(tr3);

        turnUp11Times(adjustables);

        TelevisionRemote testingRemoteObject1 = (TelevisionRemote) adjustables.get(0);
        System.out.println(testingRemoteObject1.getCurrentVolume()); // expect 12

        TelevisionRemote testingRemoteObject2 = (TelevisionRemote) adjustables.get(1);
        System.out.println(testingRemoteObject2.getCurrentVolume()); // expect 12

        TelevisionRemote testingRemoteObject3 = (TelevisionRemote) adjustables.get(2);
        System.out.println(testingRemoteObject3.getCurrentVolume()); // expect 5

    }

}

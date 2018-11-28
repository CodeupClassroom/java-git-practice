import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelevisionRemote extends Remote{

    private HashMap<String, Integer> minMaxVolume;
    private HashMap<String, Integer> minMaxChannel;

    public TelevisionRemote(int minVolume, int maxVolume, int minChannel, int maxChannel, int initialChannel, int initialVolume) {
        super(initialVolume, initialChannel);
        this.minMaxVolume = new HashMap<>();
        this.minMaxChannel = new HashMap<>();
        minMaxChannel.put("min", minChannel);
        minMaxChannel.put("max", maxChannel);
        minMaxVolume.put("min", minVolume);
        minMaxVolume.put("max", maxVolume);
    }

    @Override
    public void channelUp() {
        if (this.getCurrentChannel() < minMaxChannel.get("max")){
            this.setCurrentChannel(this.getCurrentChannel() + 1);
        }
    }

    @Override
    public void channelDown() {
        if (this.getCurrentChannel() > minMaxChannel.get("min")){
            this.setCurrentChannel(this.getCurrentChannel() - 1);
        }
    }

    @Override
    public void goToChannel(int channelNumber) throws ChannelOutOfBoundsException {
        if (channelNumber > minMaxChannel.get("max")){
            throw new ChannelOutOfBoundsException("That channel is to high");
        }else if (channelNumber < minMaxChannel.get("min")){
            throw new ChannelOutOfBoundsException("That channel is to low");
        }else {
            this.setCurrentChannel(channelNumber);
        }
    }

    @Override
    public void volumeUp() {
        if (this.getCurrentVolume() < minMaxVolume.get("max")){
            this.setCurrentVolume(this.getCurrentVolume() + 1);
        }
    }

    @Override
    public void volumeDown() {
        if (this.getCurrentVolume() > minMaxVolume.get("min")){
            this.setCurrentVolume(this.getCurrentVolume() - 1);
        }
    }

    public static void turnUp11Times(List<VolumeAdjustable> notJustTVs){
        for (VolumeAdjustable notTv : notJustTVs){
            for (int i = 0; i < 12; i++){
                notTv.volumeUp();
            }
        }
    }

}

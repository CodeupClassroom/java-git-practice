import java.util.HashMap;
public class TelevisionRemote extends Remote {

    private HashMap<String, Integer> minMaxVolume = new HashMap<>();
    private HashMap<String, Integer> minMaxChannel = new HashMap<>();

    public TelevisionRemote(int minVolume, int maxVolume, int minChannel, int maxChannel, int initialChannel, int initialVolume){

        super(initialVolume, initialChannel);

        this.minMaxVolume.put("Min Volume", minVolume);
        this.minMaxVolume.put("Max Volume", maxVolume);

        this.minMaxChannel.put("Min Channel", minChannel);
        this.minMaxChannel.put("Max Channel", maxChannel);

    }

    @Override
    public void volumeUp() {
        if (getCurrentVolume() != minMaxVolume.get("Max Volume")){
            setCurrentVolume(this.getCurrentVolume() + 1);
        }
    }

    @Override
    public void volumeDown() {
        if (getCurrentVolume() != minMaxVolume.get("Min Volume")){
            setCurrentVolume(this.getCurrentVolume() - 1);
        }
    }

    @Override
    public void channelUp() {
        if (getCurrentChannel() != minMaxChannel.get("Max Channel")){
            setCurrentChannel(this.getCurrentChannel() + 1);
        }
    }

    @Override
    public void channelDown() {
        if (getCurrentChannel() != minMaxChannel.get("Min Channel")){
            setCurrentChannel(this.getCurrentChannel() - 1);
        }
    }

    @Override
    public void goToChannel(int channelNumber) throws ChannelOutOfBoundsException {
        if (channelNumber > minMaxChannel.get("Min Channel") && channelNumber < minMaxChannel.get("Max Channel")){
            this.setCurrentChannel(channelNumber);
        } else if (channelNumber < minMaxChannel.get("Min Channel")){
            throw new ChannelOutOfBoundsException("Channel is to low!");
        } else if (channelNumber > minMaxChannel.get("Max Channel")){
            throw new ChannelOutOfBoundsException("Channel is to high!");
        }
    }
}

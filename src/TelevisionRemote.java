import java.util.HashMap;

public class TelevisionRemote extends Remote{
    private HashMap<String, Integer> minMaxVolume;
    private HashMap<String, Integer> minMaxChannel;

    public TelevisionRemote(int minVolume, int maxVolume, int minChannel, int maxChannel, int initialChannel, int initialVolume){
        super(initialVolume, initialChannel);
        minMaxChannel = new HashMap<>();
        minMaxVolume = new HashMap<>();

        minMaxVolume.put("min", minVolume);
        minMaxVolume.put("max", maxVolume);

        minMaxChannel.put("min", minChannel);
        minMaxChannel.put("max", maxChannel);


    }

    @Override
    public void goToChannel(int channelNumber) throws ChannelOutOfBoundsException{
        if(minMaxChannel.get("min") > channelNumber || channelNumber > minMaxChannel.get("max")){
            throw new ChannelOutOfBoundsException("Channel out of range");
        } else{
            this.setChannel(channelNumber);
        }
    }

}

import java.util.HashMap;

public class TelevisionRemote extends Remote {

    public static void main( String[] args ) {
        TelevisionRemote tvRemote = new TelevisionRemote(1, 3, 1, 3, 1, 10);
        try {
            tvRemote.goToChannel(9);
        } catch (ChannelOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println(tvRemote.getCurrentChannel());
    }

    private HashMap<String, Integer> minMaxVolume;
    private HashMap<String, Integer> minMaxChannel;

    public TelevisionRemote(int initialVolume, int initialChannel, int minVolume, int maxVolume, int minChannel, int maxChannel){
        super(initialVolume, initialChannel);
        this.minMaxChannel = new HashMap<>();
        this.minMaxVolume = new HashMap<>();

        this.minMaxVolume.put("min", minVolume);
        this.minMaxVolume.put("max", maxVolume);

        this.minMaxChannel.put("min", minChannel);
        this.minMaxChannel.put("max", maxChannel);
    }

    @Override
    public void channelUp() {
        if (this.getCurrentChannel() < this.minMaxChannel.get("max")){
            this.setCurrentChannel(this.getCurrentChannel() + 1);
        }
    }

    @Override
    public void channelDown() {
        if (this.getCurrentChannel() > this.minMaxChannel.get("min")){
            this.setCurrentChannel(this.getCurrentChannel() - 1);
        }
    }

    @Override
    public void goToChannel( int channelNumber ) throws ChannelOutOfBoundsException {
        if (channelNumber <= this.minMaxChannel.get("max") && channelNumber >= this.minMaxChannel.get("min")){
            this.setCurrentChannel(channelNumber);
        } else {
            throw new ChannelOutOfBoundsException("Oops, you are out of bounds");
        }
    }

    @Override
    public void volumeUp() {
        if (this.getCurrentVolume() < this.minMaxVolume.get("max")){
            this.setCurrentVolume(this.getCurrentVolume() + 1);
        }
    }

    @Override
    public void volumeDown() {
        if (this.getCurrentVolume() > this.minMaxVolume.get("min")){
            this.setCurrentVolume(this.getCurrentVolume() - 1);
        }
    }
}

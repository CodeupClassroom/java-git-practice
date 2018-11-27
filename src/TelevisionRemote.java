import java.util.HashMap;
import java.util.Scanner;

public class TelevisionRemote extends Remote {
    private HashMap<String, Integer> minMaxVolume;
    private HashMap<String, Integer> minMaxChannel;

    private int minVolume;
    private int maxVolume;
    private int minChannel;
    private int maxChannel;
    private int initialChannel;
    private int initialVolume;

    private int currentChannel;
    private int currentVolume;

    TelevisionRemote(int minVolume, int maxVolume, int minChannel, int maxChannel, int initialChannel, int initialVolume) {

        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.minChannel = minChannel;
        this.maxChannel = maxChannel;
        this.initialChannel = initialChannel;
        this.initialVolume = initialVolume;
        this.currentChannel = initialChannel;
        this.currentVolume = initialVolume;
        String stringedMinChan = "" + minChannel;
        String stringedMinVol = "" + minVolume;
        this.minMaxChannel = new HashMap<>();
        this.minMaxVolume = new HashMap<>();
        this.minMaxChannel.put(stringedMinChan, maxChannel);
        this.minMaxVolume.put(stringedMinVol, maxVolume);
    }

    @Override
    public void channelUp() {
        if (this.maxChannel > currentChannel){
            currentChannel++;
        } else {
            System.out.println("Current channel is at maximum.");
        }
    }

    @Override
    public void channelDown() {
        if (this.minChannel < currentChannel) {
            currentChannel--;
        } else {
            System.out.println("Current channel is at minimum.");
        }
    }

    @Override
    public void goToChannel() {
        Scanner sc = new Scanner(System.in);
        int proposedChannel = sc.nextInt();
        if (proposedChannel != currentChannel) {
            if (proposedChannel > minChannel && proposedChannel < maxChannel) {
                currentChannel = proposedChannel;
            } else {
                ChannelOutOfBoundsException bill = new ChannelOutOfBoundsException("Channel out of range");
                try {
                    throw bill;
                } catch (ChannelOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Channel is already being accessed.");
        }

    }

    @Override
    public void volumeUp() {
        if (this.maxVolume > currentVolume){
            currentVolume++;
        } else {
            System.out.println("Current volume is at maximum.");
        }
    }

    @Override
    public void volumeDown() {
        if (this.minVolume < currentVolume){
            currentVolume--;
        } else {
            System.out.println("Current volume is at minimum.");
        }
    }

    @Override
    public int getCurrentChannel() {
        return currentChannel;
    }

    @Override
    public int getCurrentVolume() {
        return currentVolume;
    }
}

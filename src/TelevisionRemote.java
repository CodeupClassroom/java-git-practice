import java.util.HashMap;
import java.util.Scanner;

public class TelevisionRemote extends Remote {
    private HashMap<String, Integer> minMaxVolume;
    private HashMap<String, Integer> minMaxChannel;

    private int currentChannel;
    private int currentVolume;

    TelevisionRemote(int minVolume, int maxVolume, int minChannel, int maxChannel, int initialChannel, int initialVolume) {

        this.currentChannel = initialChannel;
        this.currentVolume = initialVolume;
        this.minMaxChannel = new HashMap<>();
        this.minMaxVolume = new HashMap<>();
        this.minMaxChannel.put("min", minChannel);
        this.minMaxChannel.put("max", maxChannel);
        this.minMaxVolume.put("min", minVolume);
        this.minMaxVolume.put("max", maxVolume);
    }

    @Override
    public void channelUp() {
        if (minMaxChannel.get("max") > currentChannel){
            currentChannel++;
        } else {
            System.out.println("Current channel is at maximum.");
        }
    }

    @Override
    public void channelDown() {
        if (minMaxChannel.get("min") < currentChannel) {
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
            if (proposedChannel > minMaxChannel.get("min") && proposedChannel < minMaxChannel.get("max")) {
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
        if (minMaxVolume.get("max") > currentVolume){
            currentVolume++;
        } else {
            System.out.println("Current volume is at maximum.");
        }
    }

    @Override
    public void volumeDown() {
        if (minMaxVolume.get("min") < currentVolume){
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

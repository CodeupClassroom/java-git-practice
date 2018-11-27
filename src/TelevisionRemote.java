import java.util.HashMap;
import java.util.Scanner;

public class TelevisionRemote extends Remote {
    private HashMap<String, Integer> minMaxVolume;
    private HashMap<String, Integer> minMaxChannel;

    public TelevisionRemote(int minChannel, int maxChannel, int initalChannel, int initalVolume, int minVolume, int maxVolume) {
        super(initalVolume, initalChannel);
        this.minMaxVolume = new HashMap<>();
        minMaxVolume.put("Min Volume", minVolume);
        minMaxVolume.put("Max Volume", maxVolume);
        this.minMaxChannel = new HashMap<>();
        minMaxChannel.put("Max Channel", maxChannel);
        minMaxChannel.put("Min Channel", minChannel);
    }

    @Override
    public void channelUp() {
        int changeChannel = this.getCurrentChannel();
        changeChannel = changeChannel + 1;
        if (changeChannel > minMaxChannel.get("Max Channel")){
            System.out.println("Channels dont go any higher");
        }else {
            this.setCurrentChannel(changeChannel);
        }
    }

    @Override
    public void channelDown() {
        int changeChannel = this.getCurrentChannel();
        changeChannel = changeChannel - 1;
        if (changeChannel < minMaxChannel.get("Min Channel")){
            System.out.println("Channels dont go any lower");
        }else {
            this.setCurrentChannel(changeChannel);
        }
    }

    @Override
    public void goToChannel(int channelNumber) throws ChannelOutOfBoundsException {
      if (channelNumber < minMaxChannel.get("Min Channel")){
          throw new ChannelOutOfBoundsException("Channel is to low");
      }else if (channelNumber > minMaxChannel.get("Max Channel")){
          throw new ChannelOutOfBoundsException("Channel is to high");
        }else {
          this.setCurrentChannel(channelNumber);
      }
    }

    @Override
    public void volumeUp() {
        int changeVolume = this.getCurrentVolume();
        changeVolume = changeVolume + 1;
        if (changeVolume > minMaxVolume.get("Max Volume")){
            System.out.println("Volume dont go any higher");
        }else {
            this.setCurrentVolume(changeVolume);
        }
    }

    @Override
    public void volumeDown() {
        int changeVolume = this.getCurrentVolume();
        changeVolume = changeVolume - 1;
        if (changeVolume < minMaxVolume.get("Min Volume")){
            System.out.println("Volume dont go any lower");
        }else {
            this.setCurrentVolume(changeVolume);
        }
    }
}

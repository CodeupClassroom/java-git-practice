public abstract class Remote implements ChannelAdjustable, VolumeAdjustable {

    private int currentVolume;
    private int currentChannel;


    public Remote(int currentVolume, int currentChannel) {
        this.currentVolume = currentVolume;
        this.currentChannel = currentChannel;
    }


    public int getCurrentVolume() {
        return currentVolume;
    }
    public int getCurrentChannel() {
        return currentChannel;
    }


    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }
    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }
}
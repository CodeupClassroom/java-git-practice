public abstract class Remote implements VolumeAdjustable, ChannelAdjustable {

    private int currentVolume;
    private int currentChannel;

    public Remote(int currentVolume, int currentChannel) {
        this.currentVolume = currentVolume;
        this.currentChannel = currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }
}

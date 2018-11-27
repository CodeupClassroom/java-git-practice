abstract class Remote implements ChannelAdjustable, VolumeAdjustable{
    private int currentVolume;
    private int currentChannel;

    public Remote() { }

    public Remote(int currentVolume, int currentChannel) {
        this.currentVolume = currentVolume;
        this.currentChannel = currentChannel;
    }

    abstract int getCurrentVolume();

    abstract int getCurrentChannel();
}

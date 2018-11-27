public abstract class Remote implements ChannelAdjustable, VolumeAdjustable {
    private int currentVolume;
    private int currentChannel;

    public Remote(int currentVolume, int currentChannel){
        this.currentVolume = currentVolume;
        this.currentChannel = currentChannel;
    }

    public int getVolume(){
        return this.currentVolume;
    }

    public int getChannel(){
        return this.currentChannel;
    }

    public void setChannel(int currentChannel){
        this.currentChannel = currentChannel;
    }

    public void setVolume(int currentVolume){
        this.currentVolume = currentVolume;
    }

    @Override
    public void volumeUp(){
        this.currentVolume++;
    }

    @Override
    public void volumeDown(){
        this.currentVolume--;
    }

    @Override
    public void channelUp(){
        this.currentChannel++;
    }

    @Override
    public void channelDown(){
        this.currentChannel--;
    }


}
